package com.stan.delegete;

import java.util.HashMap;
import java.util.Map;

/**
 * 委派者
 */
public class Leader implements ITarget {
    Map<String, ITarget> targets = new HashMap<>();

    Leader() {
        targets.put("encrypt", new TargetA());
        targets.put("sell", new TargetB());
    }

    @Override
    public void doWork(String command) {
        this.dispatch(command);
    }

    public void dispatch(String command) {
        this.targets.get(command).doWork(command);
    }


}
