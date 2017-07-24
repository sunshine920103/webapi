package bbd_z.dao;

import bbd_z.domain.PicDomain;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * Created by rex on 17-7-12.
 */
public interface PicMapper {

    @Select("SELECT * FROM `pic` WHERE `uid` = #{uid}")
    public PicDomain queryByUid(String uid);

    @Insert("INSERT INTO `pic` (`uid`,`pre_pic`,`last_pic`,`lasttime`) " +
            "VALUE (#{uid},#{pre_pic},#{last_pic},NOW())")
    public void insert(PicDomain picDomain);

    @Update("update `pic` set `pre_pic`=#{pre_pic},`last_pic`=#{last_pic},`lasttime`=NOW() where `uid`=#{uid}")
    public void update(PicDomain picDomain);
}
