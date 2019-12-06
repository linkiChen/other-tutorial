package com.jacky.metrics.gauge;

import com.codahale.metrics.CachedGauge;
import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.MetricRegistry;

import java.util.concurrent.TimeUnit;

public class CacheGaugeExample {

    private final static MetricRegistry registry = new MetricRegistry();
    private final static ConsoleReporter reporter = ConsoleReporter.forRegistry(registry)
            .convertRatesTo(TimeUnit.SECONDS)
            .convertDurationsTo(TimeUnit.SECONDS)
            .build();

    public static void main(String[] args) throws InterruptedException {
        reporter.start(10, TimeUnit.SECONDS);
        // 30 -> 在缓存中驻留的时间, TimeUnit.SECONDS ->时间单位
        registry.gauge("cached-db-size", () -> new CachedGauge(30, TimeUnit.SECONDS) {
            @Override
            protected Object loadValue() {
                return queryFromDb();
            }
        });
        Thread.currentThread().join();
    }

    private static long queryFromDb() {
        System.out.println("======= query data from db =======");
        return System.currentTimeMillis();
    }
}
