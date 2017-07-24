package bbd_z.dao;

import bbd_z.domain.FeedBackDomain;
import bbd_z.domain.PoliceDomain;
import org.apache.ibatis.annotations.Insert;

/**
 * Created by rex on 17-7-17.
 */
public interface FeedBackMapper {
    @Insert("insert into `feed_back` (yj,tp1,tp2,tp3,tp4,lasttime) values(#{yj},#{tp1},#{tp2},#{tp3},#{tp4},NOW())")
    public void insert(FeedBackDomain feedBackDomain);
}
