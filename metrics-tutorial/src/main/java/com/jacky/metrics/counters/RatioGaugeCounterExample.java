package com.jacky.metrics.counters;

import com.codahale.metrics.*;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class RatioGaugeCounterExample {

    private final static MetricRegistry registry = new MetricRegistry();
    private final static ConsoleReporter reporter = ConsoleReporter.forRegistry(registry)
            .convertRatesTo(TimeUnit.SECONDS)
            .convertRatesTo(TimeUnit.SECONDS)
            .build();
    // new 出来的meter是不受register管理的
    private final static Counter successCounter = new Counter();
    private final static Counter totalCounter = new Counter();

    public static void main(String[] args) {
        reporter.start(10, TimeUnit.SECONDS);
        registry.gauge("success-rate", () -> new RatioGauge() {
            @Override
            protected Ratio getRatio() {
                return Ratio.of(successCounter.getCount(), totalCounter.getCount());
            }
        });

        for (; ; ) {
            business();
            randomSleep();
        }
    }

    private static void business() {
        // total inc ,请求进入方法后计数一次,相当于接收一次请求
        totalCounter.inc();
        try {
            int deal = 2 / ThreadLocalRandom.current().nextInt(5);
            // success inc,返回请求结果,或者请求处理最后 '成功meter' 计数一次
            successCounter.inc();
        } catch (Exception e) {
            System.err.println("error");
        }
    }

    private static void randomSleep() {
        try {
            TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(8));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
