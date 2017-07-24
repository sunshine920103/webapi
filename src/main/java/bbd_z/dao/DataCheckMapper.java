package bbd_z.dao;

import bbd_z.domain.AbnormalCheckDomain;
import bbd_z.domain.DataCheckDomain;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface DataCheckMapper {

	@Select("SELECT * FROM `data_check` WHERE `police_id`=#{police_id}")
	public List<DataCheckDomain> dataCheck(@Param("police_id") String police_id);

	@Select("SELECT * FROM `data_check` WHERE `police_id`=#{police_id} AND `status`=#{status}")
	public List<DataCheckDomain> dataCheck1(@Param("police_id") String police_id, @Param("status") String status);

	@Select("SELECT * FROM `data_check` WHERE `sfzh`=#{sfzh}")
	public DataCheckDomain dataCheckAlter(@Param("sfzh") String sfzh);

	@Update("UPDATE `data_check` SET `cym`=#{cym},`csrq`=#{csrq},`hjdz`=#{hjdz},`whcd`=#{whcd},`fwcsmc`=#{fwcsmc},`jszzqk`=#{jszzqk} WHERE `sfzh`=#{sfzh}")
	public void updataData(DataCheckDomain dataCheckDomain);
	
	@Select("SELECT * FROM `data_check` WHERE `sfzh`=#{sfzh} AND `status`=#{status}")
	public List<DataCheckDomain> dataCheckView(@Param("sfzh") String sfzh, @Param("status") String status);

	@Select("SELECT * FROM `abnormal_check` WHERE `sfzh`=#{sfzh}")
	public AbnormalCheckDomain abnormalCheckAlter(@Param("sfzh") String sfzh);


	// @Update("UPDATE `task_keywords_type` SET `first_type_name` =
	// #{first_type_name},`second_type_name` = "
	// + "#{second_type_name},`third_type_name` = #{third_type_name},`lasttime`
	// = NOW() WHERE "
	// + "`first_type` = #{first_type} AND `second_type` = #{second_type} AND
	// `third_type`=#{third_type}")
	// public void updateKeywordType(KeywordType keywordType);
}
