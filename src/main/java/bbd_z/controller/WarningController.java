package bbd_z.controller;

import bbd_z.domain.ErrorResponse;
import bbd_z.service.WarningService;
import bbd_z.warningDomain.Warning;
import info.bbd.utils.log.LogbackUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.inject.Inject;


/**
 * Created by rex on 17-7-11.
 */

@Controller
@RequestMapping("/warning")
public class WarningController {

    private static Logger logger = LoggerFactory.getLogger(WarningController.class);

    @Inject
    private WarningService warningService;

    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody ErrorResponse insert(@RequestBody Warning warning) {
        try {
            return warningService.insert(warning);
        }catch (Exception e){
            logger.error("Exception:{}", LogbackUtil.expection2Str(e));
            return new ErrorResponse.Builder(-1,"error").build();
        }
    }

    @RequestMapping(value = "/query", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody Object query(String taskid,String cardno) {
        try {
            return warningService.query(taskid);
        }catch (Exception e){
            logger.error("Exception:{}", LogbackUtil.expection2Str(e));
            return new ErrorResponse.Builder(-1,"error").build();
        }
    }
}
