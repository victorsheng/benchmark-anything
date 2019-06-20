package cn.victor123.benchamrk.mockserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = "cn.victor123")
public class MockServerApplication {

	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(MockServerApplication.class, args);
//		Thread.currentThread().join();
	}


}
