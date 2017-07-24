package bbd_z.dao;

import bbd_z.domain.QueryParams;
import bbd_z.warningDomain.WarningInout;
import bbd_z.warningDomain.WarningReportTrans;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by rex on 17-7-7.
 */
public interface WarningReportMapper {
    @Insert("INSERT INTO `warning_inout` (`account`,`accountName`,`accountType`,`latitude`,`longitude`,`resultDesc`,`time`) " +
            "VALUE" +
            " (#{account},#{accountName},#{accountType},#{latitude},#{longitude},#{resultDesc},#{time})")
    public void insertReport(WarningInout warningInout);

    @Select("SELECT * FROM `warning_inout` WHERE sfzh=(SELECT `sfzh` FROM (SELECT `sfzh`,SUBSTRING(`sfzh`,4,2) as area_code FROM `warning_inout` HAVING area_code=#{code}) as total)")
    public List<WarningInout> query(String code);

    @Select("SELECT count(*) FROM `warning_inout` WHERE sfzh=(SELECT `sfzh` FROM (SELECT `sfzh`,SUBSTRING(`sfzh`,4,2) as area_code FROM `warning_inout` HAVING area_code=#{code}) as total)")
    public int getPage(String code);
}
