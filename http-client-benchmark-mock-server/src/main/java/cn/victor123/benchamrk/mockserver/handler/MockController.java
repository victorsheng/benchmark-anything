package cn.victor123.benchamrk.mockserver.handler;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MockController {

  @RequestMapping("/now")
  public String now() throws InterruptedException {
//      TimeUnit.MILLISECONDS.sleep(500);
    return "Hello,World!";
  }

  @RequestMapping("/sleep1ms")
  public String sleep10() throws InterruptedException {
    TimeUnit.MILLISECONDS.sleep(1);
    return "Hello,World!";
  }

  @RequestMapping("/sleep5ms")
  public String sleep100() throws InterruptedException {
    TimeUnit.MILLISECONDS.sleep(5);
    return "Hello,World!";
  }


  @RequestMapping("/sleep10ms")
  public String sleep500() throws InterruptedException {
    TimeUnit.MILLISECONDS.sleep(10);
    return "Hello,World!";
  }


  @RequestMapping(value = "/upload", method = RequestMethod.POST)
  public String upload() throws InterruptedException {
    return "Hello,World!";
  }


  @RequestMapping(value = "/download_small", method = RequestMethod.GET)
  public ResponseEntity download_small() throws IOException {
    File file = new File("/Users/victor/tmp/dataset.csv");
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
    headers.setContentDispositionFormData("attachment", "model");
    return new ResponseEntity<>(FileUtils.readFileToByteArray(file), headers,
        HttpStatus.CREATED);
  }

  @RequestMapping(value = "/download_mid", method = RequestMethod.GET)
  public ResponseEntity download_mid() throws IOException {
    File file = new File("/Users/victor/tmp/dataset2.csv");
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
    headers.setContentDispositionFormData("attachment", "model");
    return new ResponseEntity<>(FileUtils.readFileToByteArray(file), headers,
        HttpStatus.CREATED);
  }

  @RequestMapping(value = "/download_large", method = RequestMethod.GET)
  public ResponseEntity download_large() throws IOException {
    File file = new File("/Users/victor/tmp/sm2.pdf");
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
    headers.setContentDispositionFormData("attachment", "model");
    return new ResponseEntity<>(FileUtils.readFileToByteArray(file), headers,
        HttpStatus.CREATED);
  }


}

