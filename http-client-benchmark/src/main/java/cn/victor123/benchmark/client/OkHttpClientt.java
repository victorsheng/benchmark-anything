package cn.victor123.benchmark.client;

import java.io.File;
import java.util.Map;
import java.util.Map.Entry;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.RequestBody;
import okhttp3.Response;


public class OkHttpClientt extends AbstractClient {

  private OkHttpClient client = new OkHttpClient();


  @Override
  public String getMethod(String accessUrl, Map<String, String> headerMap) throws Exception {
    Builder url = new Builder()
        .url(accessUrl);

    if (headerMap != null) {
      for (Entry<String, String> stringStringEntry : headerMap.entrySet()) {
        url.addHeader(stringStringEntry.getKey(), stringStringEntry.getValue());
      }
    }

    Request request = url
        .get()
        .build();

    Response response = client.newCall(request).execute();
    String string = response.body().string();
    return string;
  }

  @Override
  public String postMethod(String accessUrl, Map<String, String> headerMap, File file)
      throws Exception {

    MultipartBody.Builder total = new MultipartBody.Builder().setType(MultipartBody.FORM);
    RequestBody fileBody = RequestBody.create(MediaType.parse("application/text"), file);
    total.addFormDataPart("file", file.getName(), fileBody);
    MultipartBody body = total.build();

    Builder url = new Builder()
        .url(accessUrl);

    if (headerMap != null) {
      for (Entry<String, String> stringStringEntry : headerMap.entrySet()) {
        url.addHeader(stringStringEntry.getKey(), stringStringEntry.getValue());
      }
    }

    Request request = url
        .post(body)
        .build();

    Response response = client.newCall(request).execute();
    String string = response.body().string();
    return string;
  }
}
