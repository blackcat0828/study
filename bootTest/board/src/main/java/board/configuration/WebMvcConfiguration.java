package board.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import board.interceptor.LoggerInterceptor;

@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new LoggerInterceptor());
	}
	
	//파일 업로드 처리(Aapche Common FileUpload) 03.12
	@Bean
	public CommonsMultipartResolver multipartResolver() {
		
		//commonsMultipartResolver : 참조변수
		//CommonsMultipartResolver 객체의 인스턴스(instance)를 Heap메모리에
		//생성한다.
		//JVM(Java Virtual Machine)의 GC(Gabbage Collector)에 의해 
		//Heap 메모리에 사용하지 않는 객체의 인스턴스를 주기적으로 소멸시킨다.
		CommonsMultipartResolver commonsMultipartResolver =
				new CommonsMultipartResolver();
		
		//업로드하는 파일의 인코딩 처리
		commonsMultipartResolver.setDefaultEncoding("UTF-8");
		//업로드하는 파일 한개당 최대크기(5M)
		commonsMultipartResolver.setMaxUploadSizePerFile(5*1024*1024);
		
		return commonsMultipartResolver;
		
		
	}
	
	

	
}




