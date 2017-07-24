package bbd_z.service;

import bbd_z.dao.PicMapper;
import bbd_z.domain.ErrorResponse;
import bbd_z.domain.PicDomain;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

/**
 * Created by rex on 17-7-11.
 */
@Service
public class PicService {

    @Inject
    private PicMapper picMapper;

    public Object getPic(String uid){
        try {
            return picMapper.queryByUid(uid);
        }catch (Exception e){
            return new ErrorResponse.Builder(-1,"error").build();
        }
    }

    public Object insertPic(PicDomain picDomain){
        try {
            if (picMapper.queryByUid(picDomain.getUid())==null){
                picMapper.insert(picDomain);
                return new ErrorResponse.Builder(0,"success").build();
           }else {
                PicDomain picDomain1 = picMapper.queryByUid(picDomain.getUid());
                picDomain.setPre_pic(picDomain1.getLast_pic());
                return new ErrorResponse.Builder(0,"success").build();
            }
        }catch (Exception e){
            return new ErrorResponse.Builder(-1,"error").build();
        }
    }
}
