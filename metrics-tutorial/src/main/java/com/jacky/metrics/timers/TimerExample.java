package com.jacky.metrics.timers;

import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.Timer;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class TimerExample {

    private final static MetricRegistry registry = new MetricRegistry();
    private final static ConsoleReporter reporter = ConsoleReporter.forRegistry(registry)
            .convertDurationsTo(TimeUnit.SECONDS)
            .convertRatesTo(TimeUnit.SECONDS)
            .build();

    private final static Timer timer = registry.timer("requests", Timer::new);

    public static void main(String[] args) {
        reporter.start(5, TimeUnit.SECONDS);
        for (; ; ) {
            business();
        }
    }

    private static void business() {
        Timer.Context context = timer.time();
        try {
            TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(10));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            final long stop = context.stop();
            System.err.println("===== " + stop);
        }
    }
}
