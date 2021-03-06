package config;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DbConfig {

	@Bean(destroyMethod = "close")
	public DataSource dataSource() {
		DataSource ds = new DataSource();
		ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		ds.setUrl("jdbc:oracle:thin:@Localhost:1521:orcl");
		ds.setUsername("fintech");
		ds.setPassword("fintech1234");
		ds.setInitialSize(2);
		ds.setMaxActive(10);
		return ds;
	}
}
