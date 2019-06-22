package cn.victor123.benchmark.client;

import cn.victor123.benchmark.client.base.BaseTest;

public class ApacheClientTest extends BaseTest {

  private static final AbstractClient client = new ApacheHttpClient();

  @Override
  public AbstractClient getClient() {
    return client;
  }
}