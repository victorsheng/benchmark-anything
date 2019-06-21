package cn.victor123.benchamrk.mockserver;

import java.util.concurrent.TimeUnit;
import org.springframework.web.bind.annotation.RequestMapping;
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



}

