package board.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

//어노테이션 기반 환경 설정을 처리
@Configuration
//properties을 주입하기 위해 위치를 지정
@PropertySource("classpath:/application.properties")
//DataSourceTransactionManager Bean을 찾아서 TransactionManager
//로 사용하는 어노테이션으로 Transaction을 활성화시킨다.
@EnableTransactionManagement
public class DatabaseConfiguration {
	
	@Autowired
	private ApplicationContext applicationContext;
	
	//Transaction 처리 03.11
	//TransactionManager 등록처리
	@Bean
	public PlatformTransactionManager transactionManager() throws Exception {
		return new DataSourceTransactionManager(dataSource());
	}

	//개발자가 작성한 클래스를 Bean등록 -> @Component
	@Bean //Bean등록을 처리
	//application.properties 파일에서 설정값 중에
	//문자열이 spring.datasource.hikari로 시작하는 설정들만 가져온다.
	@ConfigurationProperties(prefix="spring.datasource.hikari")
	public HikariConfig hikariConfig() {
		//Hikari 설정파일의 인스턴스를 생성
		return new  HikariConfig();
	}

	//데이터베이스와 연동부분 선언
	@Bean
	public DataSource dataSource() {
		
		DataSource dataSource = new HikariDataSource(hikariConfig());
		System.out.println(dataSource.toString());
		
		return dataSource;
	}
	
	//SqlSession 생성을 위해 사용
	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
		
		//MyBatis 설정파일을 바탕으로 SqlSessionFactory를 생성하는 역할
		SqlSessionFactoryBean sqlSessionFactoryBean = 
				new SqlSessionFactoryBean();
		//데이터베이스 연동하는 설정부분을 SqlSessionFactoryBean
		//의 멤버변수 dataSource에 대입한다.
		sqlSessionFactoryBean.setDataSource(dataSource);
		//매퍼파일의 위치를 지정
		//src/main/resources의 mapper 폴더포함 하위폴더 전체 파일중
		//sql-로 시작하는 xml 파일은 Mapper 파일이다 라는 선언
		sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:/mapper/**/sql-*.xml"));

		//myBatis 설정관련 추가 03.09
		sqlSessionFactoryBean.setConfiguration(mybatisConfig());
		
		return sqlSessionFactoryBean.getObject();
	}
	
	//매퍼의 핵심적인 역할을 수행하는 클래스로 SQL 실행이나 트랜잭션 관리를 한다.
	@Bean
	public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	} 
	
	//CamelCase Bean등록 03.09
	@Bean
	//application.properties 파일에서 mybatis설정만 가져온다.
	@ConfigurationProperties(prefix="mybatis.configuration")
	public org.apache.ibatis.session.Configuration mybatisConfig(){
		//가져온 mybatis 설정을 자바 클래스로 생성하여 리턴
		return new org.apache.ibatis.session.Configuration();
	}
	
	//JPA 관련 설정 Bean등록 처리 03.16
	@ConfigurationProperties(prefix="spring.jpa")
	public Properties hibernateConfig() {
		return new Properties();
	}
	
	
}




