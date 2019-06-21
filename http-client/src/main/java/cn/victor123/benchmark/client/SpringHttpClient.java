package cn.victor123.benchmark.client;

import java.io.File;
import java.util.Map;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

public class SpringHttpClient extends AbstractClient {


  RestTemplate restTemplate = new RestTemplate();

  @Override
  public String getMethod(String accessUrl, Map<String, String> headerMap) throws Exception {
    String result = restTemplate.getForObject(accessUrl, String.class);
    return result;
  }

  @Override
  public String postMethod(String accessUrl, Map<String, String> headerMap, File file)
      throws Exception {

    FileSystemResource resource = new FileSystemResource(file);
    MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();
    param.add("file", resource);

    HttpEntity<MultiValueMap<String, Object>> httpEntity = new HttpEntity<>(param);
    String result = restTemplate
        .postForObject(accessUrl, httpEntity, String.class);
    return result;
  }
}
