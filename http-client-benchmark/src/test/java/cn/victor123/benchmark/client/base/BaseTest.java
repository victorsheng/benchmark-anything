package cn.victor123.benchmark.client.base;

import static cn.victor123.benchmark.constant.Constant.LOCALHOST_DOWNLOAD_SMALL_URL;

import cn.victor123.benchmark.client.AbstractClient;
import cn.victor123.benchmark.constant.Constant;
import cn.victor123.benchmark.util.FileUtils;
import java.io.File;
import org.junit.Test;

public abstract class BaseTest {

  protected File file = FileUtils.get();


  public abstract AbstractClient getClient();

  @Test
  public void get() throws Exception {
    String rs = getClient().getMethod(Constant.LOCALHOST_NOW_URL, null);
    System.out.println(rs);

  }


  @Test
  public void upload() throws Exception {
    String rs = getClient().postMethod(Constant.LOCALHOST_UPLOAD_URL, null, file);
    System.out.println(rs);
  }

  @Test
  public void download() throws Exception {
    String rs = getClient().getMethod(LOCALHOST_DOWNLOAD_SMALL_URL, null);
    System.out.println(rs);
  }


}
