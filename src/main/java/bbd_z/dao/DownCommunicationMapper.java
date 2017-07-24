package bbd_z.dao;

import bbd_z.downloadsDomains.ArchiveOne;
import bbd_z.downloadsDomains.SubCommunicateTwo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by cc on 2017/7/20.
 */
public interface DownCommunicationMapper {
    @Select("select `xm`,`sfzh`,`sj` from `archives` where `sfzh`=#{para}")
    public ArchiveOne getOne(@Param("para") String para);
    @Select("select `customerNumber`,`userAttAreaCode`,`oppositeNumber`,`toAttAreaCode`,`beginTime`,`timeLen` from `dccx` where `customerNumber`=#{para} or `oppositeNumber`=#{para}")
    public List<SubCommunicateTwo> getTwo(@Param("para") String para);
}
