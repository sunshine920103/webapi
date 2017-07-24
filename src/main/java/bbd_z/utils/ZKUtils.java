package bbd_z.utils;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.LinkedHashMap;
import java.util.Map;

public class ZKUtils {

    public Map getParms(String fieldtype, String json){
        Map<String, Object> map = new LinkedHashMap<>();
        ObjectMapper mapper = new ObjectMapper();
        try{
            map = mapper.readValue(json, new TypeReference<LinkedHashMap<String,Object>>(){});
        }catch(Exception e){
            e.printStackTrace();
        }

        if (fieldtype.equals("GAW_HKDZ")){
            return getHKDZ(map);
        }
        if (fieldtype.equals("GAW_CD_WB_SWRY")){
            return getSWRY(map);
        }
        if (fieldtype.equals("GAW_CD_ZA_GNLKXX")){
            return getGNLKXX(map);
        }
        if (fieldtype.equals("GAW_CD_ZA_BPCRYXX")){
            return getBPCRYXX(map);
        }
        if (fieldtype.equals("GAW_CD_TL_LKSMDP")){
            return getLKSMDP(map);
        }
        if (fieldtype.equals("GAW_CD_TL_JZRYHCSJ")){
            return getJZRYHCSJ(map);
        }
        if (fieldtype.equals("GAW_CD_XJ_GJ_TL")){
            return getTL(map);
        }
        if (fieldtype.equals("GAW_CD_XJ_GJ_KY")){
            return getKY(map);
        }
        if (fieldtype.equals("GAW_CD_XJ_GJ_LG")){
            return getLG(map);
        }
        if (fieldtype.equals("GAW_CD_XJ_GJ_MH")){
            return getMH(map);
        }
        return map;
    }

    private Map getHKDZ(Map<String,Object> map) {
        map.put("经度",map.remove("field1"));
        map.put("纬度",map.remove("field2"));
        map.put("ICSpnr记录编号",map.remove("field3"));
        map.put("pnr创建日期",map.remove("field4"));
        map.put("承运航空公司代码",map.remove("field5"));
        map.put("航班号后缀",map.remove("field6"));
        map.put("航班号",map.remove("field7"));
        map.put("当地出发日期",map.remove("field8"));
        map.put("当地出发时间",map.remove("field9"));
        map.put("当地到达时间",map.remove("field10"));
        map.put("当地到达日期",map.remove("field11"));
        map.put("登机机场代码",map.remove("field12"));
        map.put("到达机场代码",map.remove("field13"));
        map.put("子舱位",map.remove("field14"));
        map.put("代理人代号",map.remove("field15"));
        map.put("行动代码",map.remove("field16"));
        map.put("责任航空公司",map.remove("field17"));
        map.put("责任代理人",map.remove("field18"));
        map.put("PNR旅客编号",map.remove("field19"));
        map.put("旅客姓",map.remove("field20"));
        map.put("旅客名",map.remove("field21"));
        map.put("常旅客编号",map.remove("field22"));
        map.put("团队标识",map.remove("field23"));
        map.put("团队名称",map.remove("field24"));
        map.put("vip标识",map.remove("field25"));
        map.put("PNR总人数",map.remove("field26"));
        map.put("操作日期",map.remove("field27"));
        map.put("操作时间",map.remove("field28"));
        map.put("原始数据包的文件名",map.remove("field29"));
        map.put("导入数据的时间",map.remove("field30"));
        return map;
    }

    private Map getSWRY(Map<String, Object> map) {
        map.put( "唯一标识",map.remove("field1"));
        map.put("营业场所代码",map.remove("field2"));
        map.put("营业场所名称",map.remove("field3"));
        map.put("地址区划",map.remove("field4"));
        map.put("地址",map.remove("field5"));
        map.put("发证机关名称",map.remove("field6"));
        map.put("国籍",map.remove("field7"));
        map.put("上网开始时间",map.remove("field8"));
        map.put("下网时间",map.remove("field9"));
        map.put("上网终端号",map.remove("field10"));
        return map;
    }

    private Map getGNLKXX(Map<String, Object> map) {
        map.put("性别",map.remove("field1"));
        map.put("出生日期",map.remove("field2"));
        map.put("前台传输时间",map.remove("field3"));
        map.put("国内旅客ID",map.remove("field4"));
        map.put("旅店编码",map.remove("field5"));
        map.put("旅店名称",map.remove("field6"));
        map.put("旅客编号",map.remove("field7"));
        map.put("民族",map.remove("field8"));
        map.put("入住房号",map.remove("field9"));
        map.put("入住时间",map.remove("field10"));
        map.put("退房时间",map.remove("field11"));
        map.put("信用卡号码",map.remove("field12"));
        map.put("信用卡类型",map.remove("field13"));
        map.put("行业类型",map.remove("field14"));
        map.put("住址省市县区",map.remove("field15"));
        map.put("住址详址",map.remove("field16"));
        map.put("最后修改时间",map.remove("field17"));
        map.put("管辖单位编码",map.remove("field18"));
        map.put("管辖单位名称",map.remove("field19"));
        map.put("发音",map.remove("field20"));
        return map;
    }

    private Map getBPCRYXX(Map<String, Object> map) {
        map.put("性别代码",map.remove("field1"));
        map.put("出生日期",map.remove("field2"));
        map.put("民族",map.remove("field3"));
        map.put("文化程度",map.remove("field4"));
        map.put("籍贯",map.remove("field5"));
        map.put("住址详址",map.remove("field6"));
        map.put("联系电话",map.remove("field7"));
        map.put("盘查时间",map.remove("field8"));
        map.put("盘查输入类型",map.remove("field9"));
        map.put("经度",map.remove("field10"));
        map.put("纬度",map.remove("field11"));
        map.put("盘查车辆编号",map.remove("field12"));
        map.put("人员标签名称",map.remove("field13"));
        map.put("标签详细数据",map.remove("field14"));
        map.put("盘查处理结果",map.remove("field15"));
        map.put("盘查处理结果名称",map.remove("field16"));
        map.put("盘查处理移交单位",map.remove("field17"));
        map.put("盘查处理移交原因",map.remove("field18"));
        map.put("盘查民警所属单位代码",map.remove("field19"));
        map.put("盘查民警所属单位名称",map.remove("field20"));
        map.put("盘查民警所属分市县代码",map.remove("field21"));
        map.put("盘查民警所属分市县名称",map.remove("field22"));
        map.put("盘查民警所属市州代码",map.remove("field23"));
        map.put("盘查民警所属市州名称",map.remove("field24"));
        map.put("卡口编号",map.remove("field25"));
        map.put("卡口名称",map.remove("field26"));
        map.put("卡口所属单位代码",map.remove("field27"));
        map.put("卡口所属单位名称",map.remove("field28"));
        map.put("卡口所属分市县代码",map.remove("field29"));
        map.put("卡口所属分市县名称",map.remove("field30"));
        map.put("卡口所属市州代码",map.remove("field31"));
        map.put("卡口所属市州名称",map.remove("field32"));
        map.put("卡口行政划",map.remove("field33"));
        map.put("卡口市州名称",map.remove("field34"));
        map.put("备注",map.remove("field35"));
        map.put("录入时间",map.remove("field36"));
        map.put("最后修改时间",map.remove("field37"));
        map.put("最后修改人姓名",map.remove("field38"));
        map.put("最后修改人ID",map.remove("field39"));
        map.put("最后修改人单位",map.remove("field40"));
        map.put("最后修改人单位代码",map.remove("field41"));
        map.put("注销标记",map.remove("field42"));
        return map;
    }

    private Map getLKSMDP(Map<String, Object> map) {
        map.put("乘车日期",map.remove("field1"));
        map.put("车次",map.remove("field2"));
        map.put("乘车车站",map.remove("field3"));
        map.put("到站",map.remove("field4"));
        map.put("车厢号",map.remove("field5"));
        map.put("座位号",map.remove("field6"));
        map.put("售票时间",map.remove("field7"));
        map.put("入库时间",map.remove("field8"));
        return map;
    }

    private Map getJZRYHCSJ(Map<String, Object> map) {
        map.put("通过卡口名称",map.remove("field1"));
        map.put("通过卡口代码",map.remove("field2"));
        map.put("通过时间",map.remove("field3"));
        map.put("民族",map.remove("field4"));
        map.put("原ID",map.remove("field5"));
        map.put("新增时间",map.remove("field6"));
        return map;
    }

    private Map getTL(Map<String, Object> map) {
        map.put("票号",map.remove("field1"));
        map.put("性别",map.remove("field2"));
        map.put("民族",map.remove("field3"));
        map.put("出生日期",map.remove("field4"));
        map.put("人员详细地址",map.remove("field5"));
        map.put("发车站",map.remove("field6"));
        map.put("到车站",map.remove("field7"));
        map.put("车次",map.remove("field8"));
        map.put("车厢号",map.remove("field9"));
        map.put("席位号",map.remove("field10"));
        map.put("座席别",map.remove("field11"));
        map.put("管辖地编码",map.remove("field12"));
        map.put("管辖地名称",map.remove("field13"));
        map.put("售票处号",map.remove("field14"));
        map.put("操作员号",map.remove("field15"));
        map.put("窗口号",map.remove("field16"));
        map.put("售票时间",map.remove("field17"));
        map.put("记录入库时间",map.remove("field18"));
        return map;
    }

    private Map getKY(Map<String, Object> map) {
        map.put("票号",map.remove("field1"));
        map.put("性别",map.remove("field2"));
        map.put("民族",map.remove("field3"));
        map.put("出生日期",map.remove("field4"));
        map.put("人员详细地址",map.remove("field5"));
        map.put("客远站名称",map.remove("field6"));
        map.put("发车站",map.remove("field7"));
        map.put("到车站",map.remove("field8"));
        map.put("班次编号",map.remove("field9"));
        map.put("车牌号",map.remove("field10"));
        map.put("座位号",map.remove("field11"));
        map.put("乘车时间",map.remove("field12"));
        map.put("管辖地编码",map.remove("field13"));
        map.put("管辖地名称",map.remove("field14"));
        map.put("售票处号",map.remove("field15"));
        map.put("操作员",map.remove("field16"));
        map.put("窗口号",map.remove("field17"));
        map.put("售票时间",map.remove("field18"));
        map.put("记录入库时间",map.remove("field19"));
        return map;
    }

    private Map getLG(Map<String, Object> map) {
        map.put("性别",map.remove("field1"));
        map.put("民族",map.remove("field2"));
        map.put("国籍",map.remove("field3"));
        map.put("出生日期",map.remove("field4"));
        map.put("记录入库时间",map.remove("field5"));
        map.put("人员详细地址",map.remove("field6"));
        map.put("证件签发机关",map.remove("field7"));
        map.put("旅馆编码",map.remove("field8"));
        map.put("旅馆名称",map.remove("field9"));
        map.put("旅馆地址",map.remove("field10"));
        map.put("管辖地编码",map.remove("field11"));
        map.put("管辖地名称",map.remove("field12"));
        map.put("入住时间",map.remove("field13"));
        map.put("退房时间",map.remove("field14"));
        map.put("入住房号",map.remove("field15"));
        map.put("旅客编码",map.remove("field16"));
        return map;
    }

    private Map getMH(Map<String, Object> map) {
        map.put("旅客姓名（英文）",map.remove("field1"));
        map.put("旅客姓",map.remove("field2"));
        map.put("旅客中间名",map.remove("field3"));
        map.put("旅客名",map.remove("field4"));
        map.put("旅客国家",map.remove("field5"));
        map.put("性别",map.remove("field6"));
        map.put("出生日期",map.remove("field7"));
        map.put("出生地",map.remove("field8"));
        map.put("国籍",map.remove("field9"));
        map.put("联系电话",map.remove("field10"));
        map.put("居住地址",map.remove("field11"));
        map.put("发证国家或城市",map.remove("field12"));
        map.put("发证日期",map.remove("field13"));
        map.put("过期日期",map.remove("field14"));
        map.put("旅客出入境标识",map.remove("field15"));
        map.put("航班编号",map.remove("field16"));
        map.put("航班号后缀",map.remove("field17"));
        map.put("执行值机时间",map.remove("field18"));
        map.put("起飞航站",map.remove("field19"));
        map.put("离岗时间",map.remove("field20"));
        map.put("到达航站",map.remove("field21"));
        map.put("进港时间",map.remove("field22"));
        map.put("记录入库时间",map.remove("field23"));
        return map;
    }

}

