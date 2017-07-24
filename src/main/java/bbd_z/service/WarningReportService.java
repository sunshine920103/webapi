package bbd_z.service;

import bbd_z.dao.WarningReportMapper;
import bbd_z.domain.*;
import bbd_z.warningDomain.Location;
import bbd_z.warningDomain.WarningInout;
import bbd_z.warningDomain.WarningReportTrans;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rex on 17-7-7.
 */

@Service
public class WarningReportService {

    @Inject
    private WarningReportMapper warningReportMapper;

    public ErrorResponse insert(WarningInout warningInout){
        try {
            warningReportMapper.insertReport(warningInout);
            return new ErrorResponse.Builder(0,"Success").build();
        }catch (Exception e){
            return new ErrorResponse.Builder(-1,"error").build();
        }
    }

    public Object query(String code){
        try{
            List<WarningInout> warningInouts = new ArrayList<>();
            BigScreenDomain bigScreenDomain = new BigScreenDomain();
            BigScreenDataDomain bigScreenDataDomain = new BigScreenDataDomain();
            bigScreenDataDomain.setDataset(warningReportMapper.query(code));
            bigScreenDomain.setData(bigScreenDataDomain);

            return bigScreenDomain;
        }catch (Exception e){
            return new ErrorResponse.Builder(-1,"error").build();
        }
    }
}
