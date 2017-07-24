package bbd_z.dao;

import bbd_z.downloadsDomains.ICheckStringOne;
import bbd_z.downloadsDomains.ICheckStringTwo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by cc on 2017/7/22.
 */
public interface DownICheckMapper {
    @Select("select `xm`,`xb`,`mz`,`sfzh`,`hjszd`,`sjjzd`,`xzpcs`,`sfzy`,`csrq`,`whcd`,`jtcy_list` from `archives` where `sfzh`=#{para}")
    public ICheckStringOne getOne(@Param("para") String para);
    @Select("select `content` from `idxml` where `cardId`=#{para}")
    public List<ICheckStringTwo> getTwo(@Param("para") String para);

}
