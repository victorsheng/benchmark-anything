package cn.victor123.benchmark.benchmark;


import cn.victor123.benchmark.client.AbstractClient;
import cn.victor123.benchmark.constant.Constant;
import cn.victor123.benchmark.util.FileUtils;
import java.io.File;
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
@Warmup(iterations = 1, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 1, time = 1, timeUnit = TimeUnit.SECONDS)
public class ClientBenchMark {

  @Param({"cn.victor123.benchmark.client.ApacheHttpClient",
      "cn.victor123.benchmark.client.JdkHttpClient"
      , "cn.victor123.benchmark.client.OkHttpClientt"
      , "cn.victor123.benchmark.client.SpringHttpClient",
      "cn.victor123.benchmark.client.UnirestHttpClient"})
  protected String className;

  protected AbstractClient abstractClient;


  @Param({"NULL"})
  protected String diffFeature;

  protected Map<String, String> headerMap;

  protected File smallFile = FileUtils.get("/Users/victor/tmp/dataset.csv");

  protected File largeFile = FileUtils.get("/Users/victor/tmp/dataset2.csv");

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
      throw new RuntimeException();
    }


  }

  @Benchmark
  public void get_return_now(Blackhole bh) throws Exception {
    bh.consume(abstractClient.getMethod(Constant.i.getNow_url(), headerMap));
  }


  @Benchmark
  public void get_return_sleep5ms(Blackhole bh) throws Exception {
    bh.consume(abstractClient.getMethod(Constant.i.getSleep5_url(), headerMap));
  }

//  @Benchmark
//  public void download_210KB(Blackhole bh) throws Exception {
//    bh.consume(abstractClient.getMethod(LOCALHOST_DOWNLOAD_SMALL_URL, headerMap));
//  }
//
//  @Benchmark
//  public void download_420KB(Blackhole bh) throws Exception {
//    bh.consume(abstractClient.getMethod(LOCALHOST_DOWNLOAD_LARGE_URL, headerMap));
//  }
//
//  @Benchmark
//  public void post_upload_210KB(Blackhole bh) throws Exception {
//    bh.consume(abstractClient.postMethod(LOCALHOST_UPLOAD_URL, headerMap, smallFile));
//  }
//
//
//  @Benchmark
//  public void post_upload_420KB(Blackhole bh) throws Exception {
//    bh.consume(abstractClient.postMethod(LOCALHOST_UPLOAD_URL, headerMap, largeFile));
//  }


}
