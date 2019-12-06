package com.jacky.metrics.meter;

import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.Meter;
import com.codahale.metrics.MetricRegistry;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class MeterExample {

    private final static MetricRegistry registry = new MetricRegistry();
    // 统计tps(Transaction Per Second)的meter
    private final static Meter requestMeter = registry.meter("tps");
    // 统计请求数据的流量
    private final static Meter sizeMeter = registry.meter("volume");

    public static void main(String[] args) {
        // 在控制台打印出统计报告
        final ConsoleReporter reporter = ConsoleReporter.forRegistry(registry)
                .convertRatesTo(TimeUnit.MINUTES)
                .convertDurationsTo(TimeUnit.MINUTES).build();
        reporter.start(10, TimeUnit.SECONDS);

        /**
         * 模拟请求接口
         */
        for (; ; ) {
            handleRequest(new byte[ThreadLocalRandom.current().nextInt(1000)]);
            randomSleep();
        }
    }

    /**
     * 模拟服务端处理请求的接口
     *
     * @param requestData
     */
    private static void handleRequest(byte[] requestData) {
        requestMeter.mark();
        sizeMeter.mark(requestData.length);
        randomSleep();
    }

    /**
     * 模拟处理请求时间
     */
    private static void randomSleep() {
        try {
            TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
