package bbd_z.dao;

import bbd_z.domain.KeyUserDataDomain;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by rex on 17-7-6.
 */

public interface QueryMapper {

	@Select("select * from ${para}")
	public List<KeyUserDataDomain> query(@Param("para") String para, @Param("page")int page);

	@Select("select count(*) from ${para}")
	public int getPage(@Param("para") String para);


	@Select("select * from `keyuserlist` where `username`=#{username} limit #{page},10")
	public List<KeyUserDataDomain> getKeyUser(@Param("username") String username,@Param("page") int page);

	@Select("select count(*) from `keyuserlist` where `username`=#{username}")
	public int getKeyUserPage(@Param("username") String username);
}
