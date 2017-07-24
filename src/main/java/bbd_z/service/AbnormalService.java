package bbd_z.service;

import bbd_z.dao.AbnormalMapper;

import bbd_z.domain.BigScreenDataDomain;
import bbd_z.domain.BigScreenDomain;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

/**
 * Created by rex on 17-7-15.
 */
@Service
public class AbnormalService {

    @Inject
    private AbnormalMapper abnormalMapper;

    public BigScreenDomain get(String para,String page){
        int page1 = (Integer.parseInt(page)-1)*10;
        BigScreenDomain bigScreenDomain = new BigScreenDomain();
        BigScreenDataDomain bigScreenDataDomain = new BigScreenDataDomain();
        bigScreenDataDomain.setDataset(abnormalMapper.get(para,page1));
        bigScreenDataDomain.setPageInfo(abnormalMapper.getPage(para));
        bigScreenDomain.setData(bigScreenDataDomain);

        return  bigScreenDomain;
    }

    public BigScreenDomain getall(String page){
        int page1 = (Integer.parseInt(page)-1)*10;
        BigScreenDomain bigScreenDomain = new BigScreenDomain();
        BigScreenDataDomain bigScreenDataDomain = new BigScreenDataDomain();
        bigScreenDataDomain.setDataset(abnormalMapper.getall(page1));
        bigScreenDataDomain.setPageInfo(abnormalMapper.getPage1());
        bigScreenDomain.setData(bigScreenDataDomain);
        return  bigScreenDomain;
    }

}
