package com.jason.basejava.serialzableTest;

import java.io.*;

public class TestSerialzable implements Serializable {

    private static final long serialVersionUID = 4524039832331297119L;

    private int id;
    private String name;

    public TestSerialzable(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "TestSerialzable{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String fileName = "/Users/stan/tmp/TestSerialzable.obj";
        // 序列化
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName));
        objectOutputStream.writeObject("序列化测试");
        objectOutputStream.writeObject(9307);
        TestSerialzable testSerialzable = new TestSerialzable(124, "My-test");
        objectOutputStream.writeObject(testSerialzable);
        System.out.println("写入的obj: " + testSerialzable);

        // 反序列化
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName));
        System.out.println("1: " + ois.readObject());
        System.out.println("2: " + ois.readObject());
        TestSerialzable obj = (TestSerialzable) ois.readObject();
        System.out.println("3: " + obj);

    }
}
