package com.example.pakkarans;

import com.example.pakkarans.entity.DemoEntity;
import com.example.pakkarans.repository.DemoEntityRepository;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import javax.annotation.PostConstruct;
import java.net.MalformedURLException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PakkaransApplicationTests {

	@Autowired
	DemoEntityRepository demoEntityRepository;

	@PostConstruct
	public void populate() {
		for (int i = 0; i < 100 ; i++) {
			DemoEntity demoEntity = new DemoEntity();
			demoEntity.setMessage("Message - " + i);
			demoEntityRepository.save(demoEntity);
		}
	}

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

	@Test
	public void contextLoadDB() throws MalformedURLException, JSONException {
		DemoEntity byMessageContaining = demoEntityRepository.findDemoEntityByMessageLike("Message - 1");
		org.testng.Assert.assertNotNull(byMessageContaining);
	}
}
