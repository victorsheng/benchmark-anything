package cn.victor123.benchmark.client;

import cn.victor123.benchmark.constant.Constant;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;


public class ApacheClientClient extends AbstractClient {

  @Override
  public String getMethod(String url) throws Exception {
    CloseableHttpClient httpclient = HttpClients.createDefault();
    HttpGet httpGet = new HttpGet(Constant.LOCALHOST_GET_URL);
    CloseableHttpResponse response1 = httpclient.execute(httpGet);
    try {
      HttpEntity entity1 = response1.getEntity();
      String s = EntityUtils.toString(entity1);
      return s;
    } finally {
      response1.close();
    }
  }
}
