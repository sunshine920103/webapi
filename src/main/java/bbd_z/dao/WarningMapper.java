package bbd_z.dao;

import bbd_z.domain.QueryParams;
import bbd_z.warningDomain.Warning;
import bbd_z.warningDomain.WarningDomain;
import bbd_z.warningDomain.WarningReportTrans;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by rex on 17-7-11.
 */
public interface WarningMapper {

    @Insert("INSERT INTO `warning` (`uuid`,`taskid`,`eventtime`,`fieldtype`,`name`,`cardtype`," +
            "`cardno`,`protocolCode`,`fields`) " +
            "VALUE" +
            " (#{uuid},#{taskid},#{eventtime},#{fieldtype},#{name},#{cardtype},#{cardno}," +
            "#{protocolCode},#{fields})")
    public void insertReport(WarningDomain warningDomain);

    @Select("SELECT * FROM `warning` WHERE `taskid`=#{id}")
    public List<WarningDomain> query(String id);
}
