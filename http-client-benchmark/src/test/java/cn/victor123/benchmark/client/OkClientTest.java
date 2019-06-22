package cn.victor123.benchmark.client;

import cn.victor123.benchmark.client.base.BaseTest;

public class OkClientTest extends BaseTest {

  private static final AbstractClient client = new OkHttpClientt();

  @Override
  public AbstractClient getClient() {
    return client;
  }

}
