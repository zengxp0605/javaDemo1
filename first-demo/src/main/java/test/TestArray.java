package test;

public class TestArray {

    public static void main(String[] args) {
        double[] myList = getArray();
        printArray(myList);

        test2();
    }

    protected static double[] getArray() {
        // 数组大小
        int size = 10;
        // 定义数组
        double[] myList = new double[size];
        myList[0] = 5.6;
        myList[1] = 4.5;
        myList[2] = 3.3;
        myList[3] = 13.2;
        myList[4] = 4.0;
        myList[5] = 34.33;
        myList[6] = 34.0;
        myList[7] = 45.45;
        myList[8] = 99.993;
        myList[9] = 600;
        return myList;
    }

    public static void test2() {
        double[] myList = {11,23.0, 14.5, 29999};
        for (double element: myList ) {
               System.out.println(element);
        }

        // 计算所有元素的总和
        double total = 0;
        for (int i = 0; i < myList.length; i++) {
            total += myList[i];
        }
        System.out.println("myList总和为： " + total);
    }

    public static void printArray(double[] array) {
        long time1 = System.currentTimeMillis();
        System.out.println(time1 + "打印数组如下: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "  ");
        }
        System.out.println("\n----------------");
    }

}

