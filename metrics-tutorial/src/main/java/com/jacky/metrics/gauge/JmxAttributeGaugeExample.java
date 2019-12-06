package com.jacky.metrics.gauge;

import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.JmxAttributeGauge;
import com.codahale.metrics.MetricRegistry;

import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import java.util.concurrent.TimeUnit;

public class JmxAttributeGaugeExample {

    private final static MetricRegistry registry = new MetricRegistry();
    private final static ConsoleReporter report = ConsoleReporter.forRegistry(registry)
            .convertRatesTo(TimeUnit.SECONDS)
            .convertDurationsTo(TimeUnit.SECONDS)
            .build();

    public static void main(String[] args) throws MalformedObjectNameException, InterruptedException {
        report.start(10, TimeUnit.SECONDS);

        // jconsole->MBean->java.lang:Memory
        registry.register(MetricRegistry.name(JmxAttributeGaugeExample.class,"HeapMemoryUsage"),
                new JmxAttributeGauge(new ObjectName("java.lang:type=Memory"),"HeapMemoryUsage"));
        registry.register(MetricRegistry.name(JmxAttributeGaugeExample.class,"NonHeapMemoryUsage"),
                new JmxAttributeGauge(new ObjectName("java.lang:type=Memory"),"NonHeapMemoryUsage"));

        Thread.currentThread().join();
    }
}
