package bbd_z.dao;

import bbd_z.downloadsDomains.ArchiveOne;
import bbd_z.downloadsDomains.SubSendTwo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by cc on 2017/7/22.
 */
public interface DownDeliveryMapper {
    @Select("select `xm`,`sfzh`,`sj` from `archives` where `sfzh`=#{para}")
    public ArchiveOne getOne(@Param("para") String para);
    @Select("select `ecOrderID`,`goodsName`,`senderName`,`senderMobile`,`senderAddress`,`receiverName`,`receiverMobile`,`receiverAddress` from `jdcx` where `receiverMobile`=#{para} or `senderMobile`=#{para}")
    public List<SubSendTwo> getTwo(@Param("para") String para);
}
