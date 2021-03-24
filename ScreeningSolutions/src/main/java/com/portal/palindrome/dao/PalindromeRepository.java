package com.portal.palindrome.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface PalindromeRepository {

	@Insert("insert into palindrome(key, value) " + " values (#{key}, #{value})")
	public int insert(int palId, String key, String value);

	@Select("select value from palindrome where key=#{key}")
	public String findByKey(String key);

}
