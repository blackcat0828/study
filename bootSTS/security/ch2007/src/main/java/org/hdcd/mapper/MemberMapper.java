package org.hdcd.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.hdcd.dto.Member;

@Mapper
public interface MemberMapper {
	Member read(String email);
}
