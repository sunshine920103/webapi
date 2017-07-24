package bbd_z.service;

import bbd_z.dao.WarningMapper;
import bbd_z.domain.*;
import bbd_z.warningDomain.Warning;
import bbd_z.warningDomain.WarningDomain;
import bbd_z.warningDomain.WarningTrans;
import info.bbd.utils.json.JsonUtils;
import info.bbd.utils.log.LogbackUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by rex on 17-7-11.
 */
@Service
public class WarningService {

    private static Logger logger = LoggerFactory.getLogger(WarningService.class);

    @Inject
    private WarningMapper warningMapper;

    public ErrorResponse insert(Warning warning){
        try {
            String json ="{\"field1" +JsonUtils.toJsonWithoutPretty(warning).split("field1")[1];
            json=json.substring(0,json.length()-1);
            WarningDomain warningDomain = warning.getDataset();
            warningDomain.setFields(json);
            warningMapper.insertReport(warningDomain);
            return new ErrorResponse.Builder(0,"Success").build();
        }catch (Exception e){
            logger.error("Exception:{}", LogbackUtil.expection2Str(e));
            return new ErrorResponse.Builder(-1,"error").build();
        }
    }

    public Object query(String id){
        try {
            WarningTrans warningTrans = new WarningTrans();
            List<WarningDomain> warningDomains = warningMapper.query(id);
            for(WarningDomain warningDomain : warningDomains){
                String fields = warningTrans.getParms(warningDomain.getFieldtype().toString(),warningDomain.getFields());
                warningDomain.setFields(fields);
            }
            return warningDomains;
        }catch (Exception e){
            logger.error("Exception:{}", LogbackUtil.expection2Str(e));
            return new ErrorResponse.Builder(-1,"error").build();
        }
    }
}
