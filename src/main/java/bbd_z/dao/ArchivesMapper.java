package bbd_z.dao;

import bbd_z.domain.ArchivesDomain;
import bbd_z.domain.PoliceDomain;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created by rex on 17-7-16.
 */
public interface ArchivesMapper {

    @Select("SELECT * FROM `archives` WHERE `sfzh`=#{sfzh}")
    public List<ArchivesDomain> select(String sfzh);

    @Insert("insert into `archives`${para}")
    public void insert(@Param("para") String para);

    @Update("UPDATE `archives` SET ${para} WHERE sfzh=#{sfzh}")
    public void updata(@Param("para") String para,@Param("sfzh") String sfzh);

    @Select("SELECT count(*) FROM `archives` WHERE `sfzh`=#{sfzh}")
    public int isExists(String sfzh);
}
