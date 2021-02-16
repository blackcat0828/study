package org.fintech.day01;

import org.springframework.stereotype.Component;

import lombok.Data;

//@Component : Bean 등록
//개발자가 직접 개발한 Class를 Bean등록시 사용
//@Bean : 스프링 개발당시 이미 개발되어진 직접 제어가 불가능한
//외부 라이브러리를 bean등록하려고 할때 사용
//@Data => Getter + Setter + toString()  
@Component
@Data
public class Chef {

}




