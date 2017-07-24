package bbd_z.service;

import bbd_z.NeoDomain.NeoDomain;
import org.springframework.stereotype.Service;

/**
 * Created by cc on 2017/7/18.
 */
@Service
public class NeoService {

    public Object get(String str){
        NeoDomain neoDomain = new NeoDomain();
        try {
            neoDomain.setData(str);
            return neoDomain;
        }catch (Exception e){
            neoDomain.setCode(500);
            neoDomain.setSuccess(false);
            return neoDomain;
        }
    }


}
