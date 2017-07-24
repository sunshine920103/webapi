package bbd_z.dao;

import bbd_z.domain.PoliceDomain;
import org.apache.ibatis.annotations.*;

/**
 * Created by rex on 17-7-6.
 */
public interface LoginMapper {

    /**
     * 查询 警号
     */
    @Select("SELECT username,password,name,sfzh,sjh,zjh,department,province,city,county,village,up_username,info_list,auth_level,lasttime FROM `police_user` WHERE `username` = #{username}")
	public PoliceDomain selectPoliceId(String username);

    //查找 密码
    @Select("SELECT username,password,name,sfzh,sjh,zjh,department,province,city,county,village,up_username,info_list,auth_level,lasttime FROM `police_user` WHERE `username` = #{username} AND `password` = #{password}")
    public PoliceDomain selectPassword(@Param("username") String username, @Param("password") String password);

    //查找警员资料
    @Select("SELECT * FROM `police_user` WHERE `username` = #{username} AND `password` = #{password}")
    public PoliceDomain selectPolice(@Param("username") String username, @Param("password") String password);

    //添加警员
    @Insert("insert into `police_user`(username,password,name,sfzh,sjh,zjh,department,province,city,county,village,up_username,info_list"
            + ",auth_level,lasttime) values(#{username},#{password},#{name},#{sfzh},#{sjh},#{zjh},#{department},#{province}"
            + ",#{city},#{county},#{village},#{up_username},#{info_list},#{auth_level},NOW())")
    public void insertUser(PoliceDomain pd);
    //删除警员信息
    @Delete("delete from `police_user` where username=#{username}")
    public void deleteUser(String username);
    //更新
    @Update("update `police_user` set `password`=#{password},`name`=#{name},`sjh`=#{sjh},`zjh`=#{zjh},`department`=#{department},"
            + "`province`=#{province},`city`=#{city},`county`=#{county},`village`=#{village},"
            + "`up_username`=#{up_username},`info_list`=#{info_list},`auth_level`=#{auth_level},`lasttime`=NOW() where username=#{username}")
    public void updateUser(PoliceDomain pd);
    //根据username或者身份证号查询
    @Select("select count(*) from `police_user` where username=#{username} or sfzh=#{sfzh}")
    public int isExist(PoliceDomain pd);

}
