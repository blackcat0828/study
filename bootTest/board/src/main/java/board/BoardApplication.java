package board;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.web.servlet.MultipartAutoConfiguration;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@EnableJpaAuditing
@EntityScan(
		 basePackageClasses ={Jsr310JpaConverters.class},
		 basePackages = {"board"})
//파일 업로드를 하기 위해 WebMvcConfiguration.java에서
//CommonsMultipartResolver 객체를 Bean으로 등록처리를 코딩하였으므로
//애플리케이션 수행시 자동으로 Bean등록되는 MultipartAutoConfiguration 클래스
//를 제외시켜야 한다.
@SpringBootApplication(exclude={MultipartAutoConfiguration.class})

//애플리케이션이 실행될 때 basePackages로 선언된 패키지 포함 하위패키지에서
//JPA Entity 즉 @Entity가 있는 클래스들을 검색한다.
public class BoardApplication {

	public static void main(String[] args) {
		SpringApplication.run(BoardApplication.class, args);
	}

}
