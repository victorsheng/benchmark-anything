package cn.victor123.benchamrk.mockserver;

import java.util.concurrent.TimeUnit;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MockController {

    @RequestMapping("/")
    public String sayHello() throws InterruptedException {
//      TimeUnit.MILLISECONDS.sleep(500);
      return "Hello,World!";
    }
  }

