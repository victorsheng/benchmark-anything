package cn.victor123.benchmark.client;

import cn.victor123.benchmark.constant.Constant;
import org.junit.Test;

public class SpringClientTest {

  @Test
  public void test() throws Exception {
    SpringClient springClient = new SpringClient();
    String method = springClient.getMethod(Constant.LOCALHOST_NOW_URL, null);
    System.out.println(method);
  }

}