package cn.victor123.benchmark.client;

import org.junit.Test;

public class SpringClientTest {

  @Test
  public void test() throws Exception {
    SpringClient springClient = new SpringClient();
    String method = springClient.getMethod(null);
    System.out.println(method);
  }

}