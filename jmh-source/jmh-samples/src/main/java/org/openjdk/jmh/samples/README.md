# JMHSample_01_HelloWorld.java
@Benchmark基本使用

# JMHSample_02_BenchmarkModes.java
@BenchmarkMode(Mode.AverageTime)/thrpt: 每单位时间的操作 ops/timeUnit
@BenchmarkMode(Mode.Throughput)/avgt: 每次操作的平均时间 timeUnits/op
@BenchmarkMode(Mode.SampleTime)/sample: 抽样检查 timeUnits/op
@BenchmarkMode(Mode.SingleShotTime)/ss: 测量单次操作的时间: 抽样检查 timeUnits/op

@OutputTimeUnit(TimeUnit.SECONDS)
@OutputTimeUnit(TimeUnit.MICROSECONDS)

# JMHSample_03_States.java
@State(Scope.Benchmark)
@State(Scope.Thread)


# JMHSample_04_DefaultState.java
@State(Scope.Thread)可以写在类上,测试方法无需显示传参数
```
    private double x = Math.PI;

   @Benchmark
    @BenchmarkMode(Mode.Throughput)
    public void measureDefaultState() {
        x++;
    }
```

# JMHSample_05_StateFixtures.java
在使用@State的基础上,可以继续使用
@Setup 开始
@TearDown 结束
作用类似于测试用例后面写断言的地方,保证执行的方法是生效的

# JMHSample_06_FixtureLevel.java
fixture方法的耗时不会被统计进性能指标，所以可以用它来做一些比较重的操作。

- Level.Trial: 整个基准测试
- Level.Iteration: 迭代
- Level.Invocation: 方法调用级别(此级别仅适用于超过一毫秒的基准测试)

fixture方法的耗时不会被统计进性能指标，所以可以用它来做一些比较重的操作。

# JMHSample_07_FixtureLevelInvocation.java

每次调用前做一些工作，并且这些工作不会被统计为有效载荷。

存在疑问?????????

# JMHSample_08_DeadCode.java


# JMHSample_09_Blackholes.java
Blackhole

# JMHSample_10_ConstantFold.java
@State(Scope.Thread

# JMHSample_11_Loops.java
@OperationsPerInvocation(次数)


# JMHSample_12_Forking.java
@Fork(0)代表不frok
@Fork(1)代表fork1个线程
@Fork(2)代表fork2个线程


# JMHSample_13_RunToRun.java
@Fork(1)配合@State(Scope.Thread)

# JMHSample_15_Asymmetric.java
@Group("g") 配合 GroupThreads(3)

# JMHSample_16_CompilerControl.java
@CompilerControl(CompilerControl.Mode.DONT_INLINE)禁止inline
@CompilerControl(CompilerControl.Mode.INLINE)j强制inline
@CompilerControl(CompilerControl.Mode.EXCLUDE)禁止编译

# JMHSample_17_SyncIterations.java
ChainedOptionsBuilder.syncIterations(true)

# JMHSample_18_Control.java
Controll类

# JMHSample_20_Annotations.java
注解的优先级:方法>类

# JMHSample_21_ConsumeCPU.java
Blackhole.consumeCPU( token )

# JMHSample_22_FalseSharing.java
伪共享
1.8
@sun.misc.Contended
-XX:-RestrictContended to enable.

# JMHSample_23_AuxCounters.java
@AuxCounters.Type.OPERATIONS 记录时间(连续的)
@AuxCounters.Type.EVENTS 及次数(非连续的)

# JMHSample_24_Inheritance.java
利用模板方法进行测试
先抽象一个接口,测试不同的实现

# JMHSample_25_API_GA.java


# JMHSample_26_BatchSize.java
@Measurement(iterations = 5, batchSize = 5000)

# JMHSample_27_Params.java
@Param({"1", "31", "65", "101", "103"})

# JMHSample_28_BlackholeHelpers.java
consume

# JMHSample_29_StatesDAG.java
有向无环图

# JMHSample_30_Interrupts.java
如果收尾阶段测试方法响应中断,则会超时

# JMHSample_31_InfraParams.java
ThreadParams
BenchmarkParams

# JMHSample_32_BulkWarmup.java
先统一进行预热,然后开始迭代

WarmupMode.INDI 每个benchmark做独立的热身
WarmupMode.BULK benchmark开始之前,就做一次热身
WarmupMode.BULK_INDI

fork中的0是为了debug用的,而大于零是为了多进行几次测试
所以需要bulk来混合,多个benchmark的预热结果

# JMHSample_33_SecurityManager.java
如果加载了System.setSecurityManager(new SecurityManager())
那么System.getProperty("java.home")就会变慢

# JMHSample_34_SafeLooping.java


# JMHSample_35_Profilers.java


# JMHSample_36_BranchPrediction.java


# JMHSample_37_CacheAccess.java


# JMHSample_38_PerInvokeSetup.java



