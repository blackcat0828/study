package board;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import board.board.entity.BoardEntity;
import board.board.service.JpaBoardService;

@RunWith(SpringRunner.class)
@SpringBootTest
class BoardApplicationTests {
	
	@Autowired
	private SqlSessionTemplate seqlSession;
	@Autowired
	private JpaBoardService jpaBoardService;
	
	@Test
	public void testSqlSession() {
		System.out.println(seqlSession.toString());
	}
	
	@Ignore
	public void insert() {
		BoardEntity board = new BoardEntity();
		
	}

}
