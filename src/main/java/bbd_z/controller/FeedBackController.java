package bbd_z.controller;

import bbd_z.domain.FeedBackDomain;
import bbd_z.service.FeedBackService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;

/**
 * Created by rex on 17-7-17.
 */

@Controller
@RequestMapping("/feedback")
public class FeedBackController {

    private static Logger logger = LoggerFactory.getLogger(FeedBackController.class);

    @Inject
    private FeedBackService feedBackService;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody  Object insert(@RequestBody FeedBackDomain feedBackDomain){
        return feedBackService.inert(feedBackDomain);
    }
}
