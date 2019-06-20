package cn.victor123.benchmark.benchmark;

import cn.victor123.benchmark.client.AbstractClient;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.infra.Blackhole;

@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class ClientBenchMark {

  @Param({"cn.victor123.benchmark.client.ApacheClientClient",
      "cn.victor123.benchmark.client.JdkClientClient"
      , "cn.victor123.benchmark.client.OkHttpClientClient",
      "cn.victor123.benchmark.client.UnirestClient"})
  protected String className;

  protected AbstractClient abstractClient;


  @Param({"KEEP_ALIVE", "NULL"})
  protected String diffFeature;

  protected Map<String, String> headerMap;

  @Setup
  public void init()
      throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException, ClassNotFoundException {
    Class aClass = Class.forName(this.className);
    Constructor<? extends AbstractClient> constructor = aClass.getConstructor();
    AbstractClient abstractClient = constructor.newInstance();
    this.abstractClient = abstractClient;

    if ("NULL".equals(diffFeature)) {

    } else if ("KEEP_ALIVE".equals(diffFeature)) {
      HashMap<String, String> hashMap = new HashMap<>();
      hashMap.put("Connection", "keep-alive");
      headerMap = hashMap;
    } else {
//      System.out.println(c);
//      System.out.println("diffFeature:" + diffFeature);
      throw new RuntimeException();
    }

//    .header("accept-encoding", "gzip, deflate")

  }

  @Benchmark
  @Warmup(iterations = 1, time = 1, timeUnit = TimeUnit.SECONDS)
  @Measurement(iterations = 1, time = 1, timeUnit = TimeUnit.SECONDS)
  public void test(Blackhole bh) throws Exception {
    bh.consume(abstractClient.getMethod(headerMap));
  }


}
