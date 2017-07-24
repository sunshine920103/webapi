package bbd_z.controller;

import bbd_z.downloadsDomains.HotelLogs;
import bbd_z.excel.ExcelUtil;
import bbd_z.excelModel.ICheckModel;
import bbd_z.service.DownICheckService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.inject.Inject;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by cc on 2017/7/23.
 */
@Controller
@RequestMapping("/down")
public class DownICheckController {
    private static Logger logger = LoggerFactory.getLogger(DownICheckController.class);
    @Inject
    private DownICheckService downICheckService;
    @RequestMapping(method = RequestMethod.GET,value = "/iCheck")
    @ResponseStatus(HttpStatus.OK)
    String getIcheck(String id) {
        ArrayList<ICheckModel>  iCheckModels= (ArrayList<ICheckModel>) downICheckService.getModel(id);
        Map<String, String> map = new LinkedHashMap<>();
        String file = null;
        try {
            map.put("idCard","身份证号码");
            map.put("phone","手机信息（手机号码，手机状态，登记地址）");
            map.put("name","姓名");
            map.put("gender","性别");
            map.put("nationl","民族");
            map.put("orginal","籍贯");
            map.put("nowAddress","现住址");
            map.put("originDetail","户籍详细地址");
            map.put("work","从事职业");
            map.put("birthdate","出生日期");
            map.put("isMarry","婚姻状况");
            map.put("isEducated","文化程度");
            map.put("sameFamily","同户人员（姓名，性别，证件号码，关系）");
            map.put("contacts","电话联系人（姓名，电话，登记身份证）");
            map.put("upnames","昵称");
            map.put("activityAddress","主要活动区域");
            map.put("hotelLogs","酒店住宿记录（酒店名，房间号，入住时间，退房时间）");
            map.put("jwContacts","境外联系人");
            map.put("jdAddress","寄递联系人");
            map.put("otherKhNumber","开户账号");
            map.put("qqAccountInfo","qq账号");
            map.put("wxAccountInfo","微信信息");
            map.put("emailAccountInfo","邮箱账号");
            Collection<Object> dataset = new ArrayList<Object>();
            for(ICheckModel model:iCheckModels) {
                dataset.add(model);
            }
            file="/var/www/html/export/ICheck"+System.currentTimeMillis()+".xls";
            File f = new File(file);
            OutputStream out = new FileOutputStream(f);

            ExcelUtil.exportExcel(map, dataset, out);
            out.close();
        } catch (Exception e) {
            logger.error("ERROR:"+e.getMessage());
        }
        return file;
    }
}
