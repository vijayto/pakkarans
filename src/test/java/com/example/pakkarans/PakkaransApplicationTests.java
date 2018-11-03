package com.example.pakkarans;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import java.net.MalformedURLException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PakkaransApplicationTests {

	@Test
	public void contextLoads() throws MalformedURLException {
		RestHandlers<String> restHandlers = new RestHandlers<>();
		String s = restHandlers.postRequest("http://www.google.com");
		Assert.notNull(s, "null response");


	}

}
