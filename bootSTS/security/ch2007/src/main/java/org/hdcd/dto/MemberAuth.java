package org.hdcd.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MemberAuth {

	private String email;
	private String authority;

}
