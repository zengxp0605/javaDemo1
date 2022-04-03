package com.stan.swgl.sleepalgorithm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.*;


/**
 * 心率分析
 */
public class HeartRateAnalysis {


    public static void main(String[] args) {
        int userAge = 40;
        new HeartRateAnalysis().setUserAge(userAge).test();
    }

    public static final Logger logger = LoggerFactory.getLogger(HeartRateAnalysis.class);

    private List<HeartRatePO> rawHrList = new ArrayList<>();
    // 测量时间 小->大排序
    private List<HeartRatePO> sortedTimeHrList = new ArrayList<>();
    // 心率值 小->大排序
    private List<HeartRatePO> sortedValHrList = new ArrayList<>();
    // 每个心率值出现的次数
    private Map<Integer, Integer> hrValCounterMap = new HashMap<>();

    // 最大心率值,测量时间
    private int maxHrValue;
    private int maxHrMeasureTime;

    // 最小心率值,测量时间
    private int minHrValue;
    private int minHrMeasureTime;

    // 心率平均值
    private int avgHrValue;
    // 心率中位数
    private int medianHrValue;

    // 深度睡眠心率参考值
    private int deepSleepHrReferValue;
    /**
     * 小于 (深度睡眠心率参考值 + N ) --> 判断为深度睡眠
     * N 为下面这个参数
     */
    public static final int DEEP_SLEEP_HR_UPPER_RANGE = 5;


    // TODO: 极限心率 220-年龄
    public static final int EXTREME_HREATE_PARAM = 220;
    private int extremeHrValue;
    private int userAge = 0;

    public HeartRateAnalysis() {

    }

    public HeartRateAnalysis setUserAge(int userAge) {
        this.userAge = userAge;
        return this;
    }

    private void initExtremeHrValue() {
        this.extremeHrValue = EXTREME_HREATE_PARAM - userAge;
    }

    private void test() {

        long startTime = System.currentTimeMillis();   //获取开始时间

        logger.info("SleepAnalysis 分析睡眠数据");

        init();

        checkDeepSleep();

        long endTime = System.currentTimeMillis(); //获取结束时间
        logger.info("程序运行时间: {}ms", endTime - startTime);
    }

    /**
     * 深度睡眠处理
     * - 判断标准,{一个时间段}内的心率{低且平稳}
     */
    public void checkDeepSleep() {
        List<int[]> timeList = new ArrayList<>();

        // 遍历时间排序的list
        int totalSize = sortedTimeHrList.size();
        for (int start = 0; start < totalSize; ) {
            boolean isOutOfIndex = false;
            int end = start + 5; // period 5个点,10分钟
            if (end > totalSize) {
                end = totalSize;
                isOutOfIndex = true;
            }

            List<HeartRatePO> newList = sortedTimeHrList.subList(start, end);
            boolean isDeep = isHrLowAndSteady(newList);
            logger.info("遍历数据: {},{},{}, {}", start, end, isDeep);
            if (isDeep) {
                int stime = newList.get(0).getMeasureTime();
                int etime = newList.get(newList.size() - 1).getMeasureTime();
                int[] arr = {stime, etime};
                timeList.add(arr);
            }
            start += 3;
 
            if (isOutOfIndex) {
                break;
            }
        }

        // TODO: 合并相邻时间段
        logger.info("深睡眠时间段: {}", timeList);
        for (int[] arr : timeList) {
            logger.info("深睡眠时间段: {}, 时长 {}s", arr, arr[1] - arr[0]);
        }
    }

    /**
     * 判断心率是否低且平稳
     *
     * @param list
     * @return
     */
    public boolean isHrLowAndSteady(List<HeartRatePO> list) {
        int totalSize = list.size();
        if (totalSize < 3) { // 数据过少,不做处理
            return false;
        }

        int lowerCount = 0;
        for (int i = 0; i < totalSize; i++) {
            HeartRatePO item = list.get(i);
            boolean isLower = (item.getHeartRate() <= this.deepSleepHrReferValue + DEEP_SLEEP_HR_UPPER_RANGE);
            if (isLower) {
                lowerCount++;
            }
        }

        double lowerPercent = lowerCount / (double) totalSize;
        // 超过 80%心率符合区间,则认为是平稳的睡眠
        boolean isSteay = lowerPercent >= 0.8D ? true : false;

        logger.info("[isHrLowAndSteady], {},{},{}", lowerCount, totalSize, isSteay);
        return isSteay;
    }


    public void init() {

        String fileName = "hr-demo-full.txt";
        initListByFile(fileName);


        logger.info("当前心率数量: {}, {}", rawHrList.size());

//        for(int i =1; i<rawHrList.size(); i++){
//            HeartRatePO prevHR = rawHrList.get(i-1);
//            HeartRatePO curHR = rawHrList.get(i);
//            System.out.println(curHR.getMeasureTime() - prevHR.getMeasureTime());
//        }
        logger.info("排序前,第一个值: {}, {}", rawHrList.get(0));

        // 拷贝对象
        sortedValHrList = new ArrayList<>(rawHrList);
        sortedTimeHrList = new ArrayList<>(rawHrList);

        Collections.sort(sortedValHrList, (HeartRatePO h1, HeartRatePO h2) -> h1.getHeartRate() > h2.getHeartRate() ? 1 : -1);
        Collections.sort(sortedTimeHrList, (HeartRatePO h1, HeartRatePO h2) -> h1.getMeasureTime() > h2.getMeasureTime() ? 1 : -1);

        logger.info("排序后,第一个值: {}, {}", sortedValHrList.get(0), sortedTimeHrList.get(0));

        HeartRatePO minItem = sortedValHrList.get(0);
        HeartRatePO maxItem = sortedValHrList.get(sortedValHrList.size() - 1);
        minHrMeasureTime = minItem.getMeasureTime();
        minHrValue = minItem.getHeartRate();
        maxHrMeasureTime = maxItem.getMeasureTime();
        maxHrValue = maxItem.getHeartRate();

        int totalVal = 0;
        int totalCount = sortedValHrList.size();
        for (HeartRatePO item : sortedValHrList) {
            int hr = item.getHeartRate();
            totalVal += hr;

            int curCount = 1;
            if (hrValCounterMap.containsKey(hr)) {
                curCount += hrValCounterMap.get(hr);
            }

            hrValCounterMap.put(hr, curCount);
        }

        avgHrValue = totalVal / totalCount;
        medianHrValue = calcMedianHrValue();

        logger.info("计算的基础数据: minHrMeasureTime={}, minHrValue={}, maxHrMeasureTime={}, maxHrValue={}, avgHrValue={}, medianHrValue={}",
                minHrMeasureTime,
                minHrValue,
                maxHrMeasureTime,
                maxHrValue,
                avgHrValue,
                medianHrValue);

        logger.info("心率各个值的统计: {}", hrValCounterMap);

        initExtremeHrValue();
        initDeepSleepHrReferValue();
    }

    /**
     * 深度睡眠心率参考值
     * TODO: 怎么计算得到?
     */
    private void initDeepSleepHrReferValue() {
        _initDeepSleepHrReferValue1();

        logger.info("计算得到的深度睡眠心率参考值: {}", deepSleepHrReferValue);
    }

    /**
     * 深度睡眠心率参考值
     * 计算方法1: 取最低10%心率的平均值
     */
    private void _initDeepSleepHrReferValue1() {
        int usedCount = (int) Math.ceil(sortedValHrList.size() * 0.1);
        int totalVal = 0;
        for (int i = 0; i < usedCount; i++) {
            HeartRatePO item = sortedValHrList.get(i);
            int hr = item.getHeartRate();
            totalVal += hr;
        }

        this.deepSleepHrReferValue = (int) Math.ceil(totalVal / usedCount);
    }

    /**
     * 计算心率中位数
     *
     * @return
     */
    private int calcMedianHrValue() {
        int totalCount = sortedValHrList.size();
        // 总数为奇数
        if (totalCount % 2 == 1) {
            int midIndex = (int) Math.ceil(totalCount / 2);
            return sortedValHrList.get(midIndex).getHeartRate();
        }

        // 总数为偶数
        int midIndex = (int) Math.ceil(totalCount / 2);
        int totalVal = sortedValHrList.get(midIndex).getHeartRate() + sortedValHrList.get(midIndex + 1).getHeartRate();
        return (int) Math.floor(totalVal / 2);
    }

    /**
     * 以行为单位读取文件，常用于读面向行的格式化文件
     */
    private void initListByFile(String fileName) {
        String path = "D:\\work\\workspace\\spring-boot-mydemo\\12-sleep-algorithm\\target\\classes\\debugData\\" + fileName;

        File file = new File(path);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int line = 1;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                // 显示行号
//                System.out.println("line " + line + ": " + tempString);
                line++;

                String[] tmpArr = tempString.split(",");
                HeartRatePO heartRatePO = new HeartRatePO();
                heartRatePO.setMeasureTime(Integer.valueOf(tmpArr[0]));
                heartRatePO.setHeartRate(Integer.valueOf(tmpArr[1]));
                rawHrList.add(heartRatePO);
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
    }
}
