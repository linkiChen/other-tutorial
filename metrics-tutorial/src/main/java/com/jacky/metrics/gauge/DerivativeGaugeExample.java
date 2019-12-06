package com.jacky.metrics.gauge;

import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.DerivativeGauge;
import com.codahale.metrics.Gauge;
import com.codahale.metrics.MetricRegistry;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.CacheStats;
import com.google.common.cache.LoadingCache;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class DerivativeGaugeExample {

    private final static LoadingCache<String, String> cache = CacheBuilder
            .newBuilder().maximumSize(10)
            .expireAfterAccess(5, TimeUnit.SECONDS)
            .recordStats()
            .build(new CacheLoader<String, String>() {
                @Override
                public String load(String key) throws Exception {
                    return key.toUpperCase();
                }
            });
    private final static MetricRegistry registry = new MetricRegistry();
    private final static ConsoleReporter reporter = ConsoleReporter.forRegistry(registry)
            .convertRatesTo(TimeUnit.SECONDS)
            .convertDurationsTo(TimeUnit.SECONDS)
            .build();

    public static void main(String[] args) throws InterruptedException {
        reporter.start(10, TimeUnit.SECONDS);
        final Gauge<CacheStats> cacheGauge = registry.gauge("cache-stats", () -> cache::stats);

        // loadExpCountDerivationGauge missCountDerivationGauge 都是由 cacheGauge衍生而来的
        final DerivativeGauge<CacheStats, Long> missCountDerivationGauge = registry.register("miss-count", new DerivativeGauge<CacheStats, Long>(cacheGauge) {
            @Override
            protected Long transform(CacheStats cacheStats) {
                return cacheStats.missCount();
            }
        });
        final DerivativeGauge<CacheStats, Long> loadExpCountDerivationGauge = registry.register("load-exception-count", new DerivativeGauge<CacheStats, Long>(cacheGauge) {
            @Override
            protected Long transform(CacheStats cacheStats) {
                return cacheStats.loadExceptionCount();
            }
        });
        for (; ; ) {
            business();
            TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(5));
        }
    }

    private static void business() {
        cache.getUnchecked("jacky");
    }

}
