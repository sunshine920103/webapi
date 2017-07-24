package bbd_z.dao;

import bbd_z.domain.AbnormalDomain;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by rex on 17-7-15.
 */
public interface AbnormalMapper {

    @Select("select * from `abnormal` where `xm`=#{para} or `sfzh`=#{para} order by `lasttime` desc limit #{page},10")
    public List<AbnormalDomain> get(@Param("para") String para,@Param("page") int page);

    @Select("select count(*) from `abnormal` where `xm`=#{para} or `sfzh`=#{para}")
    public int getPage(@Param("para") String para);

    @Select("select * from `abnormal` order by `lasttime` desc limit #{page},10")
    public List<AbnormalDomain> getall(@Param("page") int page);

    @Select("select count(*) from `abnormal`")
    public int getPage1();
}
