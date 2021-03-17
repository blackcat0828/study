package board.board.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import board.board.entity.BoardEntity;
import board.board.entity.BoardFileEntity;

//CrudRepository<도메인 클래스명,클래스의 id 타입> ?
//CRUD(Create Read Update Delete) 기능을 제공
public interface JpaBoardRepository extends JpaRepository<BoardEntity,Integer> {

	//게시물 목록을 가져오는데 게시물 번호를 내림차순으로 가져온다.  
//	List<BoardEntity> findAllByOrderByBoardIdxDesc();
	List<BoardEntity> findAllByOrderByBoardIdxDesc();
	//개발자가 직접 sql문장을 수행하기 위해 사용
	@Query("select file from BoardFileEntity file where board_idx = :boardIdx and idx = :idx")
	//@Query(value="select * from BoardFileEntity where board_idx = :boardIdx and idx = :idx",nativeQuery=true)
	BoardFileEntity findBoardFile(
			@Param("boardIdx") int boardIdx,
			@Param("idx") int idx);
	
	@Modifying
	@Query(value ="update t_jpa_board set contents= :#{#board.contents}, title= :#{#board.title} where board_idx = :#{#board.boardIdx}", nativeQuery=true)
	void updateBoard(@Param("board") BoardEntity board);
}


