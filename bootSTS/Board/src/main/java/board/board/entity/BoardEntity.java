package board.board.entity;

import java.time.LocalDateTime;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

//JPA를 이용해서 테이블과 매핑할 경우 사용하며
//@Entity가 붙은 클래스는 JPA가 관리한다.
//@Entity 사용시 주의사항
//기본 생성자는 반드시 필요(매개변수가 없는 public 또는 protected 생성자)
//final 클래스, enum, interface, inner 클래스에는 사용불가
@Entity
@Table(name="t_jpa_board")
@NoArgsConstructor
@Data
public class BoardEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int boardIdx;
	
	@Column(nullable=false)
	private String title;
	
	@Column(nullable=false)
	private String contents;
	
	@Column(nullable=false)
	private int hitCnt = 0;
	
	@Column(nullable=false)
	private String creatorId;
	
	@Column(nullable=false)
	private LocalDateTime createdDatetime = LocalDateTime.now();
	
	private String updaterId;
	
	private LocalDateTime updateDatetime;
	
	/*
	 * 1. fetch=FetchType.EAGER : 즉시 로딩이라는 의미이며 엔티티(테이블) 조회시 연관된 테이블도 함께 조회처리를 한다.
	 * t_jpa_board 테이블의 데이터 조회시 t_jpa_file도 함께 조회처리한다. 2. fetch=FetchType.LAZY : 지연
	 * 로딩이라는 의미이며 엔티티(테이블) 조회시 연관된 테이블이 실제 사용할 때만 조회한다.
	 * 
	 *주테이블과 연관테이블의 변경사항을 적용시켜주는 방법을 선언
	 * Cascade=CasecadeType.옵션
	 * 1. cascade=CascadeType.PERSIST
	 * 엔티티를 생성하고 연관 엔티티를 추가했을때 persist()를 수행하면 연관 엔티티도 함께 persist()가 수행된다.
	 * 만약 연관 엔티티에 DB에 등록된 키값을 가지고 있다면 datached entity passed to persist Exception 발생
	 * 
	 * 2.cascade=CascadeType.MERGE
	 * 트랜잭션이 종료되고 detach상태에서 연관 엔티티를 추가하거나 변경된 이후에 부모 엔티티가 merge()를 
	 * 수행하면 연관 엔티티도 추가 혹은 변경이 모두 적용된다.
	 * 
	 * 
	 * 3. cascade=CascadeType.REFRESH
	 * 엔티티를 새로 변경할 경우 연관된 엔티티도 새로 변경된 부분을 적용
	 * 
	 * 4. cascade=CascadeType.REMOVE
	 * 부모 엔티티와 연관된 자식 엔티티도 함께 삭제처리 된다.
	 * 
	 * 5.cascade=CascadeType.DETACH
	 * 부모 엔티티가 detach()를 수행하면 연관된 엔티티도 detach() 상태가 되어 변경사항이 반영되지 않는다.
	 */
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="board_idx")
	private Collection<BoardFileEntity> fileList;
	
}
