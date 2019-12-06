package com.jacky.metrics.counters;

import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.Counter;
import com.codahale.metrics.MetricRegistry;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class CounterExample {

    private static final MetricRegistry registry = new MetricRegistry();
    private static final ConsoleReporter reporter = ConsoleReporter.forRegistry(registry)
            .convertRatesTo(TimeUnit.SECONDS)
            .convertDurationsTo(TimeUnit.SECONDS)
            .build();

    private static final BlockingDeque<Long> queue = new LinkedBlockingDeque<>(1_100);

    public static void main(String[] args) {
        reporter.start(10, TimeUnit.SECONDS);
        final Counter counter = registry.counter("queue-count", Counter::new);

        new Thread(() -> {
            for (; ; ) {
                randomSleep();
                queue.add(System.nanoTime());
                counter.inc();
            }
        }).start();

        new Thread(() -> {
            for (; ; ) {
                randomSleep();
                queue.poll();
                counter.dec();
            }
        }).start();
    }

    private static void randomSleep() {
        try {
            TimeUnit.MILLISECONDS.sleep(ThreadLocalRandom.current().nextInt(500));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
