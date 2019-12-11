#### Metrics(version=3.2.6)

---

Metrics是一个提供了强大的度量功能的工具包,这个工具包可以用来衡量生产环境中关键组件的行为.也可以将其理解为一个数据监控工具.

**Metrics**提供了五个基本的度量类型:

1. Gauges: Gauges度量的是一个瞬时值,例如衡量一个待处理队列中的任务个数
2. Counters: Counter就是一个计数器,它只是用Gauges封装AtomicLong,可以通过增加或减少其值来达到计数的目的
3. Histograms: Histogram统计的是数据的分布情况.除了基本的最小值、最大值、中间值外,还有中位数,75百分位，90百分位，90百分位，95百分位，98百分位，99百分位，99.9百分位的值
4. Meters: Meters度量的是一系列事件发生的速率,如TPS( Transaction Per Second ),除了统计事件发生的平均速率外,Meters还会统计1、5、15分钟的平均速率
5. Timers: Timers是Histogram和Meter的结合,Histogram度量某部分代码/调用的耗时,Meter统计TPS

除了以上五个基本的度量外,Metrics还可以通过学习metrics-healthchecks检查模块集中化服务的运行状况

**Reporter**，Metrics除了提供度量外还提供了reporter(报表)功能,项目中的统计数据可以通过这此reporter输出来相应的地方供相关人员分析,Metrics提供了以下的Reporter:

1. JMX: (JmxReporter)将统计报告输出到JMX中,可以通过JConsole或者MBean查看工具进行查看
2. Console: (ConsoleReporter) 指向控制台输出统计报告
3. CSV: (CsvReporter) 向指定的CSV文件输出统计报告
4. SLF4J: (Slf4jReporter)将统计报告输出到日志文件
5. Graphite:(GraphiteReporter)将统计报告输出到Graphite

以上的报告可能需要其他的第三方依赖库支持及相应的配置,此外也可以扩展 ScheduledReporter 类实现自定义的报表类