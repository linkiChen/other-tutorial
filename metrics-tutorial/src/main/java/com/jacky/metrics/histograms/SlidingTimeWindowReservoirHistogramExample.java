package com.jacky.metrics.histograms;

import com.codahale.metrics.*;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class SlidingTimeWindowReservoirHistogramExample {

    private final static MetricRegistry registry = new MetricRegistry();
    private final static ConsoleReporter reporter = ConsoleReporter.forRegistry(registry)
            .convertDurationsTo(TimeUnit.SECONDS)
            .convertRatesTo(TimeUnit.SECONDS)
            .build();

    private final static Histogram histogram = new Histogram(new SlidingTimeWindowArrayReservoir(30,TimeUnit.SECONDS));

    public static void main(String[] args) {
        reporter.start(5, TimeUnit.SECONDS);
        registry.register("sliding-time-window-reservoir-histogram", histogram);
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
