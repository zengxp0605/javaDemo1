package stan.ziptest;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Random;
import java.util.Scanner;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;

/**
 * ZLib压缩工具
 */
public class ZlibUtils {

    static String cmd = "IWAPM1,device_sn,timestamp^IWAPPG,34,order_no,35,1,0,0,0,0,H|1000,997159,999815,1002367,1003969,1004995,1007447,1010897,1015129,1021015,1029189,1038977,1048313,1057149,1062059,1072601,1082819,1093275,1109049,1123661,1138035,1156455,^IWAPPG,35,order_no,36,1,0,0,0,0,H|1000,1169327,1181293,1190163,1195227,1194675,1194659,1195125,1194769,1190027,1182879,1176747,1173431,1171109,1168963,1165927,1164307,1162059,1160347,1158125,1155089,^IWAPPG,36,order_no,37,1,0,0,0,0,H|999,1149289,1143233,1138535,1133845,1132471,1130751,1128885,1126935,1125221,1122991,1118709,1113705,1109871,1105785,1102875,1100433,1097313,1095261,1092801,1090987,^IWAPPG,37,order_no,38,1,0,0,0,0,H|1005,1087865,1082861,1077605,1073093,1069191,1066029,1063663,1061093,1059015,1056717,1055275,1053613,1050229,1048423,1046541,1045277,1042945,1040087,1037959,1036177,^IWAPPG,38,order_no,39,1,0,0,0,0,H|995,1034965,1035083,1035093,1033243,1029139,1025171,1021879,1020217,1019353,1017759,1016461,1015087,1013409,1012899,1012585,1012043,1008405,1004369,1001689,999839,999399,^IWAPPG,39,order_no,40,1,0,0,0,0,H|1000,999297,998687,998339,998431,998313,998991,998721,996939,993539,991131,989545,988663,987883,988663,991979,996133,1000467,1005191,1008489,1010049,^IWAPPG,40,order_no,41,1,0,0,0,0,H|999,1008319,1006963,1006725,1007361,1008133,1009007,1009939,1011085,1012255,1013509,1015037,1016299,1016257,1014561,1013433,1012933,1013985,1014781,1015503,1016317,^IWAPPG,41,order_no,42,1,0,0,0,0,H|1000,1017199,1017683,1018319,1019379,1021133,1021379,1019505,1018005,1017267,1018835,1023831,1029445,1033049,1035763,1038153,1040943,1043259,1046227,1051901,1055895,1063747,^IWAPPG,42,order_no,43,1,0,0,0,0,H|1000,1070879,1069115,1064781,1067089,1078079,1106081,1130793,1145947,1152705,1156971,1159499,1161347,1163213,1166741,1169089,1171023,1172295,1173279,1174425,1175519,^IWAPSP,device_sn,1651562065,order_no,44,1,1,0,3,-1,0^";

    public static void main(String[] args) throws Exception {

//        for (int i = 0; i < 100; i++) {
//            makeRandomStr();
//        }

        // 获取表名输入
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入命令，start");
        String cmd = scanner.nextLine();
        if ("start".equals(cmd)) {
            while (true) {
                test(makeRandomStr());
                Thread.sleep(100);
            }
        }
    }

    public static String makeRandomStr(){
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 1024;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
            // 拼接时间
            buffer.append(System.currentTimeMillis());
        }
        String generatedString = buffer.toString();

//        System.out.println(generatedString);
        return generatedString;
    }

    public static void test(String string) {
        byte[] compress = ZlibUtils.compress(string.getBytes());
        byte[] decompress = ZlibUtils.decompress(compress);

        String s = new String(decompress);
        System.out.println(s);
        System.out.println("压缩前后byte len: " + compress.length + " ~ " + decompress.length);
        System.out.println("压缩前后string len: " + new String(compress).length() + " ~ " + s.length());
    }

    /**
     * 压缩
     *
     * @param data 待压缩数据
     * @return byte[] 压缩后的数据
     */
    public static byte[] compress(byte[] data) {
        byte[] output = new byte[0];

        Deflater compresser = new Deflater();

        compresser.reset();
        compresser.setInput(data);
        compresser.finish();
        ByteArrayOutputStream bos = new ByteArrayOutputStream(data.length);
        try {
            byte[] buf = new byte[1024];
            while (!compresser.finished()) {
                int i = compresser.deflate(buf);
                bos.write(buf, 0, i);
            }
            output = bos.toByteArray();
        } catch (Exception e) {
            output = data;
            e.printStackTrace();
        } finally {
            try {
                bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        compresser.end();
        return output;
    }

    /**
     * 压缩
     *
     * @param data 待压缩数据
     * @param os   输出流
     */
    public static void compress(byte[] data, OutputStream os) {
        DeflaterOutputStream dos = new DeflaterOutputStream(os);

        try {
            dos.write(data, 0, data.length);

            dos.finish();

            dos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 解压缩
     *
     * @param data 待压缩的数据
     * @return byte[] 解压缩后的数据
     */
    public static byte[] decompress(byte[] data) {
        byte[] output = new byte[0];

        Inflater decompresser = new Inflater();
        decompresser.reset();
        decompresser.setInput(data);

        ByteArrayOutputStream o = new ByteArrayOutputStream(data.length);
        try {
            byte[] buf = new byte[1024];
            while (!decompresser.finished()) {
                int i = decompresser.inflate(buf);
                o.write(buf, 0, i);
            }
            output = o.toByteArray();
        } catch (Exception e) {
            output = data;
            e.printStackTrace();
        } finally {
            try {
                o.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        decompresser.end();
        return output;
    }

    /**
     * 解压缩
     *
     * @param is 输入流
     * @return byte[] 解压缩后的数据
     */
    public static byte[] decompress(InputStream is) {
        InflaterInputStream iis = new InflaterInputStream(is);
        ByteArrayOutputStream o = new ByteArrayOutputStream(1024);
        try {
            int i = 1024;
            byte[] buf = new byte[i];

            while ((i = iis.read(buf, 0, i)) > 0) {
                o.write(buf, 0, i);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return o.toByteArray();
    }
}
