package bbd_z.controller;

import bbd_z.domain.ErrorResponse;
import bbd_z.domain.QueryParams;
import bbd_z.warningDomain.WarningInout;
import bbd_z.service.WarningReportService;
import info.bbd.utils.log.LogbackUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by rex on 17-7-7.
 */

@Controller
@RequestMapping("/warning-inout")
public class WarningInoutController {

    private static Logger logger = LoggerFactory.getLogger(WarningInoutController.class);

    @Inject
    private WarningReportService warnService;

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody ErrorResponse login(@RequestBody WarningInout warningInout) {
        try {
        logger.info("Receive a report {}", warningInout.getAccount());
        return warnService.insert(warningInout);
        }catch (Exception e){
            logger.error("Exception:{}", LogbackUtil.expection2Str(e));
            return new ErrorResponse.Builder(-1,"error").build();
        }
    }

    @RequestMapping(value = "/query", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody Object query(String code) {

        return warnService.query(code);
    }
}
