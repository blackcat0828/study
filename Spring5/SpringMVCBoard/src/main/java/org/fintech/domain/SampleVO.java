package org.fintech.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Getter + Setter + toString()
@Data
//모든 멤버변수를 매개변수로 하는 생성자를 생성해준다.
@AllArgsConstructor
//매개변수가 없는 기본생성자를 생성해준다.
@NoArgsConstructor
public class SampleVO {
	private Integer mno;
	private String firstName;
	private String lastName;
	
}








