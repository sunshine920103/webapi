package bbd_z.service;

import bbd_z.dao.DownCommunicationMapper;
import bbd_z.dao.DownDeliveryMapper;
import bbd_z.downloadsDomains.ArchiveOne;
import bbd_z.downloadsDomains.SubCommunicateTwo;
import bbd_z.downloadsDomains.SubSendTwo;
import bbd_z.excelModel.DeliveryHistoryModel;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.ArrayList;

/**
 * Created by cc on 2017/7/22.
 */
@Service
public class DownDeliveryService {
    @Inject
    private DownDeliveryMapper downDeliveryMapper;

    public ArrayList<DeliveryHistoryModel> get(String para){
        ArrayList<DeliveryHistoryModel> result=new ArrayList<>();
        ArrayList<SubSendTwo> twos=new ArrayList<>();
        ArchiveOne one=downDeliveryMapper.getOne(para);
        String[] phones=one.getSj().replaceAll("\\[|\\]|\"","").split(",");
        for(String phone:phones){
            twos.addAll(downDeliveryMapper.getTwo(phone));
        }
        int i=1;
        for(SubSendTwo two:twos){
            result.add(new DeliveryHistoryModel(i++,one,two));
        }
        return result;
    }
}
