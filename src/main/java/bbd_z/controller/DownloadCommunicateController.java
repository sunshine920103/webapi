package bbd_z.controller;

import bbd_z.excel.ExcelUtil;
import bbd_z.excelModel.CommunicateHistoryModel;
import bbd_z.service.DownCommunicationHistoryService;
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
 * Created by cc on 2017/7/21.
 */
@Controller
@RequestMapping("/down")
public class DownloadCommunicateController {
    private static Logger logger = LoggerFactory.getLogger(DownloadCommunicateController.class);
    @Inject
    private DownCommunicationHistoryService communicationHistoryService;
    @RequestMapping(method = RequestMethod.GET,value = "/communicate")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody String getHomePage(String id) {
        String file = null;
        Map<String, String> map = new LinkedHashMap<>();
        try {
            map.put("id","序号");
            map.put("name","主体姓名");
            map.put("idCard","主体身份证号");
            map.put("phoneNum","主体联系电话");
            map.put("relation","关系");
            map.put("callNum","主叫号码");
            map.put("callArea","主叫归属地");
            map.put("listenNum","被叫号码");
            map.put("listenArea","被叫归属地");
            map.put("startTime","开始时间");
            map.put("talkLast","持续时间");
            Collection<Object> dataset = new ArrayList<Object>();
            for(CommunicateHistoryModel model:communicationHistoryService.get(id)) {
                dataset.add(model);
            }
            file="/var/www/html/export/CommunicateHistory"+System.currentTimeMillis()+".xls";
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
