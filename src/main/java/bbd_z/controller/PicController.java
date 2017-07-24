package bbd_z.controller;

import bbd_z.domain.ErrorResponse;
import bbd_z.domain.PicDomain;
import bbd_z.service.PicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by rex on 17-7-11.
 */
@Controller
@RequestMapping("/pic")
public class PicController {

    private static Logger logger = LoggerFactory.getLogger(PicController.class);

    @Inject
    private PicService picService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody Object getPic(String uid) {
        try {
            if(uid != null && uid.length()>0) {
                logger.info("Get a uid {} and return his pic", uid);
                return picService.getPic(uid);
            }
            return new ErrorResponse.Builder(-1,"error").build();
        }catch (Exception e){
            return new ErrorResponse.Builder(-1,"error").build();
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody Object postPic(@RequestBody PicDomain picDomain) {
        try {
            if(picDomain != null) {
                logger.info("Get a uid {} and return his pic", picDomain.getUid());
                return picService.insertPic(picDomain);
            }
            return new ErrorResponse.Builder(-1,"error").build();
        }catch (Exception e){
            return new ErrorResponse.Builder(-1,"error").build();
        }
    }

}
