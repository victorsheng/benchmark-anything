package cn.victor123.benchmark.client;

import cn.victor123.benchmark.client.base.BaseTest;

public class UnirestHttpClientTest extends BaseTest {

  private static final AbstractClient client = new UnirestHttpClient();

  @Override
  public AbstractClient getClient() {
    return client;
  }

}
