package cn.victor123.benchmark.client;

import java.io.File;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;


public class ApacheHttpShareClient extends AbstractClient {


  private CloseableHttpClient httpclient = HttpClientBuilder.create().setMaxConnTotal(16)
      .setMaxConnPerRoute(16).build();


  @Override
  public String getMethod(String accessUrl, Map<String, String> headerMap) throws Exception {
    HttpGet httpGet = new HttpGet(accessUrl);
    if (headerMap != null) {
      for (Entry<String, String> stringStringEntry : headerMap.entrySet()) {
        httpGet.addHeader(stringStringEntry.getKey(), stringStringEntry.getValue());
      }
    }
    CloseableHttpResponse response = httpclient.execute(httpGet);
    try {
      HttpEntity entity1 = response.getEntity();
      String s = EntityUtils.toString(entity1);
      return s;
    } finally {
      response.close();
    }
  }

  @Override
  public String postMethod(String accessUrl, Map<String, String> headerMap, File file)
      throws Exception {
    HttpPost post = new HttpPost(accessUrl);
    FileBody fileBody = new FileBody(file);
    MultipartEntityBuilder builder = MultipartEntityBuilder.create();
    builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
    builder.addPart("file", fileBody);
    HttpEntity entity = builder.build();
//
    post.setEntity(entity);
    CloseableHttpResponse response = httpclient.execute(post);
    try {
      HttpEntity entity1 = response.getEntity();
      String s = EntityUtils.toString(entity1);
      return s;
    } finally {
      response.close();
    }
  }
}
