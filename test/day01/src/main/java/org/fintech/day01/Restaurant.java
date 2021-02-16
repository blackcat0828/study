package org.fintech.day01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Setter;

@Component
@Data
//@Setter?
//setChef() 메서드를 컴파일시 자동으로 실행
public class Restaurant {
	@Setter(onMethod_ = @Autowired)
	private Chef chef;
	
}







