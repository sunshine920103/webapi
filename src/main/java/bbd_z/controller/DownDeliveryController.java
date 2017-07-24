package bbd_z.controller;

import bbd_z.excel.ExcelUtil;
import bbd_z.excelModel.DeliveryHistoryModel;
import bbd_z.service.DownDeliveryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.inject.Inject;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by cc on 2017/7/22.
 */
@Controller
@RequestMapping("/down")
public class DownDeliveryController {
    private static Logger logger = LoggerFactory.getLogger(DownloadCommunicateController.class);
    @Inject
    private DownDeliveryService downDeliveryService;
    @RequestMapping(method = RequestMethod.GET,value = "/delivery")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    String getHomePage(String id) {
        String file = null;
        Map<String, String> map = new LinkedHashMap<>();
        try {
            map.put("id","序号");
            map.put("name","主体姓名");
            map.put("idCard","主体身份证号");
            map.put("relation","关系");
            map.put("ecOrderID","订单号");
            map.put("goodsName","物品名称");
            map.put("senderName","发货方姓名");
            map.put("senderMobile","发货方移动电话");
            map.put("senderAddress","发货方地址");
            map.put("sendTime","发货时间");
            map.put("receiverName","收货方姓名");
            map.put("receiverMobile","收货方移动电话");
            map.put("receiverAddress","收货方地址");
            map.put("receiveTime","收货时间");

            Collection<Object> dataset = new ArrayList<Object>();
            for(DeliveryHistoryModel model:downDeliveryService.get(id)) {
                dataset.add(model);
            }
            file="/var/www/html/export/Delivery"+System.currentTimeMillis()+".xls";
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
