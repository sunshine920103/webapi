
package bbd_z.dao;

import bbd_z.domain.HomePageDomain;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by rex on 17-7-9.
 */
public interface HomePageMapper {
    @Select("select * from data_check where username=#{username} AND create_at>#{starttime} AND create_at<#{endtime};")
    public List<HomePageDomain> selectHomePage(@Param("username") String username, @Param("starttime") String time, @Param("endtime") String endtime);
}
