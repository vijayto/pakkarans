package com.example.pakkarans;

import org.json.JSONException;
import org.json.JSONObject;
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


	@Test
	public void contextLoadsJson() throws MalformedURLException, JSONException {
		RestHandlers<String> restHandlers = new RestHandlers<>();
		String s = restHandlers.getRequest("https://jsonplaceholder.typicode.com/todos/1");
		JSONObject jsonObject = new JSONObject(s);
		String userId = jsonObject.getString("title");
		org.testng.Assert.assertEquals("delectus aut autem", "delectus aut autem");
	}
}
