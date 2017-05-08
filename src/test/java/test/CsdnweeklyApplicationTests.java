package test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import sample.data.jpa.ServletInitializer;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=ServletInitializer.class)
public class CsdnweeklyApplicationTests {

	@Test
	public void contextLoads() {
	}

}
