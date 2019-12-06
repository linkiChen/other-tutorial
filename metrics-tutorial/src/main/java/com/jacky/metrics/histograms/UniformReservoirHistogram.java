package com.jacky.metrics.histograms;

import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.Histogram;
import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.UniformReservoir;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class UniformReservoirHistogram {

    private final static MetricRegistry registry = new MetricRegistry();
    private final static ConsoleReporter reporter = ConsoleReporter.forRegistry(registry)
            .convertDurationsTo(TimeUnit.SECONDS)
            .convertRatesTo(TimeUnit.SECONDS)
            .build();

    private final static Histogram histogram = new Histogram(new UniformReservoir());

    public static void main(String[] args) {
        reporter.start(5, TimeUnit.SECONDS);
        registry.register("uniform-histogram", histogram);
        for (; ; ) {
            query();
            randomSleep();
        }
    }

    private static void query() {
        histogram.update(ThreadLocalRandom.current().nextInt(10));
    }

    private static void randomSleep() {
        try {
            TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(5));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
