package com.abead.datastructDemo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayQueueDemo {
    static class MyDelayed implements Delayed {

        @Override
        public long getDelay(TimeUnit unit) {
            return 0;
        }

        @Override
        public int compareTo(Delayed o) {
            return 0;
        }
    }
    public static void main(String[] args) {
        DelayQueue delayQueue = new DelayQueue();
        delayQueue.add(new MyDelayed());
        delayQueue.add(new MyDelayed());
        delayQueue.add(new MyDelayed());
        delayQueue.add(new MyDelayed());
        delayQueue.add(new MyDelayed());
        delayQueue.add(new MyDelayed());
        List<Delayed> list = new ArrayList<>();
        delayQueue.drainTo(list);
    }
}
