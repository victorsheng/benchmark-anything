package cn.victor123.benchmark.client;

import cn.victor123.benchmark.client.base.BaseTest;
import cn.victor123.benchmark.constant.Constant;
import cn.victor123.benchmark.util.FileUtils;
import java.io.File;
import org.junit.Test;

public class JDKClientTest extends BaseTest {


  private static final AbstractClient client = new JdkHttpClient();

  @Override
  public AbstractClient getClient() {
    return client;
  }

}