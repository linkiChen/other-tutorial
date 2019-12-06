package com.jacky.metrics.gauge;

import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.Gauge;
import com.codahale.metrics.MetricRegistry;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class GaugeExample {

    private final static MetricRegistry registry = new MetricRegistry();
    private final static ConsoleReporter reporter = ConsoleReporter.forRegistry(registry)
            .convertRatesTo(TimeUnit.SECONDS)
            .convertDurationsTo(TimeUnit.SECONDS).build();

    private static final BlockingDeque<Long> queue = new LinkedBlockingDeque<>(1_100);

    public static void main(String[] args) {
        registry.register(MetricRegistry.name(GaugeExample.class, "queue-remains"), (Gauge<Integer>) queue::size);
        reporter.start(3, TimeUnit.SECONDS);

        new Thread(() -> {
            for (; ; ) {
                randomSleep();
                queue.add(System.nanoTime());
            }
        }).start();

        new Thread(() -> {
            for (; ; ) {
                randomSleep();
                queue.poll();
            }
        }).start();
    }

    private static void randomSleep() {
        try {
            TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
