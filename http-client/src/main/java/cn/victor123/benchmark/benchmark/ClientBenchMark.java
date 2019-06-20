package cn.victor123.benchmark.benchmark;

import cn.victor123.benchmark.client.AbstractClient;
import cn.victor123.benchmark.constant.Constant;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.TimeUnit;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.infra.Blackhole;

@State(Scope.Benchmark)
public class ClientBenchMark {

  @Param({"cn.victor123.benchmark.client.ApacheClientClient",
      "cn.victor123.benchmark.client.JdkClientClient"
      , "cn.victor123.benchmark.client.OkHttpClientClient",
      "cn.victor123.benchmark.client.UnirestClient"})
  private String className;

  private AbstractClient abstractClient;

  @Setup
  public void init()
      throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException, ClassNotFoundException {
    Class aClass = Class.forName(this.className);
    Constructor<? extends AbstractClient> constructor = aClass.getConstructor();
    AbstractClient abstractClient = constructor.newInstance();
    this.abstractClient = abstractClient;
  }

  @Benchmark
  @Warmup(iterations = 1, time = 5, timeUnit = TimeUnit.SECONDS)
  @Measurement(iterations = 1, time = 5, timeUnit = TimeUnit.SECONDS)
  public void oneThread(Blackhole bh) throws Exception {
    bh.consume(abstractClient.getMethod(Constant.LOCALHOST_GET_URL));
  }



}
