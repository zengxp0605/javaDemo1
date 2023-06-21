package com.stan.easyexcel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.context.AnalysisContextImpl;
import com.alibaba.excel.metadata.data.ReadCellData;
import com.alibaba.excel.read.listener.ReadListener;
import com.alibaba.excel.read.metadata.ReadSheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.alibaba.excel.util.ListUtils;
import com.alibaba.fastjson.JSON;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UploadSample {
    public static void main(String[] args) throws IOException {
        System.out.println("test");

        // 读取文件
        ClassPathResource classPathResource = new ClassPathResource("excel/upload-file.xlsx");
        InputStream inputStream = classPathResource.getInputStream();

        List<Object> objectList = EasyExcel.read(inputStream) // .doReadAllSync()
                .sheet()
                .doReadSync();

        System.out.println("--------------------------------------------------------------------------------");

        testReadEverySheet();
//        testReadSyncAll();
//        testReadSync();
    }

    public static boolean isNumeric(String s) {
        if (s != null && !"".equals(s.trim())) {
            if (s.matches("^[0-9]*$")) {
                return true;
            }
        }

        return false;
    }

    public static void testReadEverySheet() throws IOException {
            ClassPathResource classPathResource = new ClassPathResource("excel/upload-file.xlsx");
            InputStream inputStream = classPathResource.getInputStream();

            List<ReadSheet> sheetList = new ArrayList<>();
            try (ExcelReader excelReader = EasyExcel.read(inputStream).build()) {

            List<ReadSheet> allSheet = excelReader.excelExecutor().sheetList();
            System.out.println("allSheet: " + allSheet.size());
//            for (int i = 0; i < allSheet.size(); i++) {
            for (ReadSheet sheet : allSheet) {
                String sheetName = sheet.getSheetName();
                if (!isNumeric(sheetName)) {
                    System.out.println("跳过sheet: " + sheetName);
                    continue;
                }

                ReadSheet curSheet = EasyExcel.readSheet(sheetName).head(ElectrovalenceDo.class)
                        .headRowNumber(2)
                        .registerReadListener(new ElectrovalenceReadListener())
                        .build();
                sheetList.add(curSheet);
            }
            if (sheetList.size() > 0) {
                // 这里注意 一定要把sheet1 sheet2 一起传进去，不然有个问题就是03版的excel 会读取多次，浪费性能
                excelReader.read(sheetList);
            }
        }
    }

    public static void testReadSyncAll() throws IOException {
        ClassPathResource classPathResource = new ClassPathResource("excel/upload-file.xlsx");
        InputStream inputStream = classPathResource.getInputStream();

        EasyExcel.read(inputStream, ElectrovalenceDo.class, new ElectrovalenceReadListener())
                .headRowNumber(2)
                .doReadAllSync();

    }

    private static class ElectrovalenceReadListener implements ReadListener<ElectrovalenceDo> {
        private static final int BATCH_COUNT = 100;

        private List<ElectrovalenceDo> cachedList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);

        @Override
        public void invoke(ElectrovalenceDo electrovalenceDo, AnalysisContext analysisContext) {
            String sheetName = analysisContext.readSheetHolder().getSheetName();
            Integer integer = Integer.valueOf(sheetName);
            electrovalenceDo.setYearMonth(integer);

            System.out.println(electrovalenceDo);
            cachedList.add(electrovalenceDo);
            if (cachedList.size() >= BATCH_COUNT) {
                batchSaveData();
                cachedList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);
            }
        }

        @Override
        public void doAfterAllAnalysed(AnalysisContext analysisContext) {
            System.out.println("数据完成保存：" + analysisContext.readSheetHolder().getSheetName());
        }

        private void batchSaveData() {
            System.out.println("开始保存数据,条数：" + cachedList.size());
        }
    }

    /**
     * 依次同步读取每个sheet
     *
     * @throws IOException
     */
    public static void testReadSync() throws IOException {
        String fileName = "D:\\git\\java-learn-demo\\springboot-demo\\25-easyexcel\\src\\main\\resources\\excel\\upload-file.xlsx";
        ExcelReader excelReader = EasyExcel.read(fileName).build();
        List<ReadSheet> sheetList = excelReader.excelExecutor().sheetList();

        for (ReadSheet sheet : sheetList) {
            String sheetName = sheet.getSheetName();
            System.out.println("--》sheetName: " + sheetName);

            ClassPathResource classPathResource1 = new ClassPathResource("excel/upload-file.xlsx");
            InputStream inputStream1 = classPathResource1.getInputStream();

            List<Object> list = EasyExcel.read(inputStream1)
                    .head(ElectrovalenceDo.class)
                    .headRowNumber(2) // 表头2行
                    .sheet(sheetName)
                    .doReadSync();
            System.out.println(list);
        }

    }


    /**
     * @author zengxp
     * @date 2023-06-20 14:59:20 中国标准时间
     */
    @Data
    @SuperBuilder
    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode
    @ToString
    public static class ElectrovalenceDo {

        @ExcelIgnore
        private Integer yearMonth;

        @ExcelProperty("城市编码")
        private String regionCode;

        @ExcelProperty("用电编码")
        private String powerCategoryCode;

        @ExcelProperty("电压等级编码")
        private String voltageTypeCode;

        @ExcelProperty("最大需量")
        private String specVoltageType;

        @ExcelProperty("尖峰")
        private java.math.BigDecimal topPrice;

        @ExcelProperty("高峰")
        private java.math.BigDecimal highPrice;

        @ExcelProperty("平时")
        private java.math.BigDecimal normalPrice;

        @ExcelProperty("低谷")
        private java.math.BigDecimal lowPrice;

        @ExcelProperty("深谷")
        private java.math.BigDecimal deepPrice;

        @ExcelProperty("电度用电价格")
        private java.math.BigDecimal sumPrice;

        @ExcelProperty("最大需量")
        private String maxNeed;

        @ExcelProperty("变压器容量")
        private String transformerCapacity;

    }
}
