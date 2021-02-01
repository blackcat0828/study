package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import dao.DogDAO;
import vo.Dog;

public class DogViewService {
	
	public Dog getDogView(int id) {
		DogDAO dogDAO = DogDAO.getInstance();
		Connection con = getConnection();
		dogDAO.setConnection(con);
		int updateCount = dogDAO.updateReadCount(id);
		
		if(updateCount>0) {
			commit(con);
		}else {
			rollback(con);
		}
		
		Dog dog = dogDAO.selectDog(id);
		close(con);
		return dog;
	}
}
