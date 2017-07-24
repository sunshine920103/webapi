package bbd_z.dao;

import bbd_z.domain.AbnormalCheckDomain;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface AbnormalCheckMapper {

	@Select("SELECT * FROM `abnormal_check` WHERE `police_id`=#{police_id}")
	List<AbnormalCheckDomain> abnormalCheck(@Param("police_id") String police_id);
	
	@Select("SELECT * FROM `abnormal_check` WHERE `police_id`=#{police_id} AND `status`=#{status}")
	List<AbnormalCheckDomain> abnormalCheck1(@Param("police_id") String police_id, @Param("status") String status);

	@Select("SELECT * FROM `abnormal_check` WHERE `police_id`=#{police_id} AND `urgency`=#{urgency}")
	List<AbnormalCheckDomain> abnormalCheck2(@Param("police_id") String police_id, @Param("urgency") String urgency);

	@Select("SELECT * FROM `abnormal_check` WHERE `police_id`=#{police_id} AND `status`=#{status} AND `urgency`=#{urgency}")
	List<AbnormalCheckDomain> abnormalCheck3(@Param("police_id") String police_id, @Param("status") String status, @Param("urgency") String urgency);

	@Update("UPDATE `abnormal_check` SET `dcqk`=#{dcqk} , `status`=#{status} WHERE `sfzh`=#{sfzh}")
	public void updataData(@Param("sfzh") String sfzh, @Param("dcqk") String dcqk, @Param("status") String status);
}
