package com.stan.swgl.sleepalgorithm;

public class HeartRatePO {

    private int heartRate;
    private int measureTime;

    public int getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(int heartRate) {
        this.heartRate = heartRate;
    }

    public int getMeasureTime() {
        return measureTime;
    }

    public void setMeasureTime(int measureTime) {
        this.measureTime = measureTime;
    }

    public String toString(){
        return  "{measureTime=" + getMeasureTime()
                + ",heartRate=" +   getHeartRate()
                + "}";
    }
}
