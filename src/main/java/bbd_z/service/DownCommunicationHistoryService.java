package bbd_z.service;

import bbd_z.dao.DownCommunicationMapper;
import bbd_z.downloadsDomains.ArchiveOne;
import bbd_z.downloadsDomains.SubCommunicateTwo;
import bbd_z.excelModel.CommunicateHistoryModel;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.ArrayList;

/**
 * Created by cc on 2017/7/20.
 */
@Service
public class DownCommunicationHistoryService {
    @Inject
    private DownCommunicationMapper communicationMapper;

    public ArrayList<CommunicateHistoryModel> get(String para){
        ArrayList<CommunicateHistoryModel> result=new ArrayList<>();
        ArrayList<SubCommunicateTwo> twos=new ArrayList<>();
        ArchiveOne one=communicationMapper.getOne(para);
        String[] phones=one.getSj().replaceAll("\\[|\\]|\"","").split(",");
        for(String phone:phones){
            twos.addAll(communicationMapper.getTwo(phone));
        }
        int i=1;
        for(SubCommunicateTwo two:twos){
            result.add(new CommunicateHistoryModel(i++,one,two));
        }
        return result;
    }
}
