package cn.victor123.benchmark.client;

import cn.victor123.benchmark.client.base.BaseTest;
import cn.victor123.benchmark.constant.Constant;
import org.junit.Test;

public class SpringHttpClientTest extends BaseTest {

  private static final AbstractClient client = new SpringHttpClient();

  @Override
  public AbstractClient getClient() {
    return client;
  }

}