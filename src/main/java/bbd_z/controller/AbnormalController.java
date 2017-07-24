package bbd_z.controller;

import bbd_z.domain.ErrorResponse;
import bbd_z.service.AbnormalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;

/**
 * Created by rex on 17-7-15.
 */
@Controller
@RequestMapping("/abnormal")
public class AbnormalController {

    private static Logger logger = LoggerFactory.getLogger(AbnormalController.class);

    @Inject
    private AbnormalService abnormalService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody Object getHomePage(String para,String page) {
        try {
            if (para!=null && para.length() > 0){
                return abnormalService.get(para,page);
            }
            return abnormalService.getall(page);
        } catch (Exception e) {
            return new ErrorResponse.Builder(-1, "error").build();
        }
    }
}
