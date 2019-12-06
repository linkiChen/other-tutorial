package com.jacky.metrics.gauge;

import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.Meter;
import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.RatioGauge;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * 统计成功率/失败率
 */
public class RatioGaugeExample {

    private final static MetricRegistry registry = new MetricRegistry();
    private final static ConsoleReporter reporter = ConsoleReporter.forRegistry(registry)
            .convertRatesTo(TimeUnit.SECONDS)
            .convertRatesTo(TimeUnit.SECONDS)
            .build();
    // new 出来的meter是不受register管理的
    private final static Meter successMeter = new Meter();
    private final static Meter totalMeter = new Meter();

    public static void main(String[] args) {
        reporter.start(10, TimeUnit.SECONDS);
        registry.gauge("success-rate", () -> new RatioGauge() {
            @Override
            protected Ratio getRatio() {
                return Ratio.of(successMeter.getCount(), totalMeter.getCount());
            }
        });

        for (; ; ) {
            business();
            randomSleep();
        }
    }

    private static void business() {
        // total inc ,请求进入方法后计数一次,相当于接收一次请求
        totalMeter.mark();
        try {
            int deal = 2 / ThreadLocalRandom.current().nextInt(5);
            // success inc,返回请求结果,或者请求处理最后 '成功meter' 计数一次
            successMeter.mark();
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
