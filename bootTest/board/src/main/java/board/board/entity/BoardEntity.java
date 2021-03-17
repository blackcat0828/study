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
//final 클래스,enum,interface,inner 클래스에는 사용불가
@Entity
//엔터티와 매핑할 테이블을 지정
@Table(name="t_jpa_board")
//기본 생성자를 생성
//@AllArgsConstructor -> 모든 멤버변수를 매개변수로 하는 생성자 생성
@NoArgsConstructor
@Data
public class BoardEntity {

	//테이블의 PK(Primary Key = 기본키 = 주키)임을 선언
	@Id
	//기본키(PK)를 생성하는 방법을 선언
	/*
 		1.IDENTIFY : 기본키 생성을 전적으로 데이터베이스에 위임하는 방법
 		2.SEQUENCE : 데이터베이스 기능중 sequence를 사용하여 기본키를 생성
 		             하는 방법으로 주로 sequence를 제공하는 오라클,
 		             PostgresSQL,DB2,H2 데이터베이스에서 사용한다.
 		  
 		  @SequenceGenerator(
 		     name="user_seq_ger",//sequence generator 이름
 		     sequenceName = "user_seq",//sequence 이름
 		     initialValue=1,//sequence 시작값
             allocationSize=1 //메모리를 통해 할당할 사이즈 		     
 		  )       
 		  
 		 3. TABLE : 키 생성 테이블을 사용하는 방법
 		    - 키 생성 전용 테이블을 하나 만들고 여기에 이름과 값으로 사용할
 		      컬럼을 만드는 방법
 		      
 		 4. AUTO : 데이터베이스에 따라서 IDENTIFY,SEQUENCE,TABLE 방법중
 		           하나를 자동으로 선택하는 방법으로 오라클의 경우 SEQUENCE
 		           를 자동으로 선택하여 사용한다. 즉 데이터베이스를 변경해도
 		           코드를 수정할 필요가 없다.         
 		             
	 */
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int boardIdx;
	
	//테이블의 컬럼 선언 (Not Null)
	@Column(nullable=false)
	private String title;
	
	@Column(nullable=false)
	private String contents;
	
	@Column(nullable=false)
	private int hitCnt = 0;
	
	@Column(nullable=false)
	private String creatorId;
	
	//JSR-310 표준 명세에서 제공해주는 날짜 시간 객체
	@Column(nullable=false)
	//현재 일자와 시간을 리턴
	private LocalDateTime createdDatetime = LocalDateTime.now();
	
	private String updaterId;
	
	private LocalDateTime updatedDatetime;
	
	//게시판테이블(t_jpa_board)과 첨부파일 테이블(t_jpa_file) 의
	//연관관계를 표시하는 것으로 한개의 게시판에 대해 여러개의 첨부파일이 연관되므로
	//1:N의 관계가 성립하는데 이를 어노테이션으로 선언함.
	/*
 		1. fetch=FetchType.EAGER : 즉시 로딩이라는 의미이며
 		   엔터티(테이블) 조회시 연관된 테이블도 함께 조회처리를 한다. 
 		   t_jpa_board 테이블의 데이터를 조회시 t_jpa_file도 함께 조회처리한다.
 		
 		2. fetch=FetchType.LAZY : 지연 로딩이라는 의미이며
 		   엔터티(테이블) 조회시 연관된 테이블이 실제 사용할 때만 조회한다.
 		
 		//주테이블과 연관테이블의 변경사항을 적용시켜주는 방법을 선언
 		  cascade=CascadeType.옵션
 		  
 		  1.cascade=CascadeType.PERSIST
 		    엔터티를 생성하고 연관 엔터티를 추가했을때 persist()를 수행하면
 		    연관 엔터티도 함께 persist()가 수행된다.
 		    만약 연관 엔터티에 DB에 등록된 키값을 가지고 있다면
 		    detached entity passed to persist Exception 발생
 		  
 		  2.cascade=CascadeType.MERGE
 		    트랜잭션이 종료되고 detach상태에서 연관 엔터티를 추가하거나
 		    변경된 이후에 부모 엔터티가 merge()를 수행하면 연관 엔터티도
 		    추가 혹은 변경이 모두 적용된다.
 		    
 		  3.cascade=CascadeType.REFRESH
 		    엔터티를 새로 변경할 경우 연관된 엔터티도 새로 변경된 부분을 적용
 		    
 		  4.cascade=CascadeType.REMOVE
 		    부모 엔터티와 연관된 자식 엔터티도 함께 삭제처리 된다.
 		    
 		  5.cascade=CascadeType.DETACH
 		    부모 엔터티가 detach()를 수행하면 연관된 엔터티도 detach()
 		    상태가 되어 변경사항이 반영되지 않는다.
 		    
 		  6.cascade=CascadeType.ALL
 		    모든 변경사항을 적용             
 			
	 */
	@OneToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	//외래키(Foreign Key)를 매핑할때 사용 
	@JoinColumn(name="board_idx")
	private Collection<BoardFileEntity> fileList;
	
}


