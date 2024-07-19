package port.sport;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import port.sport.entitiy.Posts;
import port.sport.entitiy.QPosts;

import static port.sport.entitiy.QPosts.*;

@SpringBootTest
class SportApplicationTests {
	JPAQueryFactory factory;

	@Test
	void contextLoads() {
	}

}
