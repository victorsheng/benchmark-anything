package cn.victor123.benchmark.client;

import cn.victor123.benchmark.constant.Constant;
import java.util.concurrent.TimeUnit;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.infra.Blackhole;


@State(Scope.Benchmark)
public abstract class AbstractClient {





  public abstract String getMethod(String url) throws Exception;

}
