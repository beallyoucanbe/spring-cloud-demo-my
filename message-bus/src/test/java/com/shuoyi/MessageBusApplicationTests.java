package com.shuoyi;

import com.shuoyi.message.Sender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MessageBusApplication.class)
public class MessageBusApplicationTests {

	@Autowired
	private Sender sender;

	@Test
	public void hello() {
		sender.send();
	}

}
