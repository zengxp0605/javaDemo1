package com.stan.swgl.sleepalgorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Test {

    public static void main(String[] args) {
        Node node = new Node<Integer, String>(100, "test");
        System.out.println(node.getKey() + "--" + node.getValue());

        HashMap hashMap = new HashMap();
        hashMap.put(null, null);
        System.out.println(hashMap.size());

        List list = new ArrayList(10);
        System.out.println(list.size());
        list.add(12);
        list.add(0);
        list.set(1, "1234");
        System.out.println(list.get(1));

        Vector<Integer> vector = new Vector<>();
        vector.add(124);


        for(int i =0 ; i< 100; i++){
            hashMap.put(i, i);
        }

        for(int i =0 ; i< 100; i++){
            hashMap.remove(i);
        }

        System.out.println("hashMap.size: " + hashMap.size() );
        System.out.println("hashMap: " + hashMap );

        try {
            test2();

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void test2() throws InterruptedException {
        ConcurrentHashMap<String, AtomicInteger> map = new ConcurrentHashMap<>();
        AtomicInteger integer = new AtomicInteger(1);
        map.put("key", integer);
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        for (int i = 0; i < 1000; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    map.get("key").incrementAndGet();
                }
            });
        }
        Thread.sleep(3000); //模拟等待执行结束
        System.out.println("------" + map.get("key") + "------");
        executorService.shutdown();
    }
}

class Node<K, V>{
    K key;
    V value;

    Node(K key, V value){
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}
