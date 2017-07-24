package bbd_z.controller;

import bbd_z.domain.ArchivesDomain;
import bbd_z.domain.BigScreenDataDomain;
import bbd_z.domain.BigScreenDomain;
import bbd_z.domain.ErrorResponse;
import bbd_z.service.ArchivesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rex on 17-7-16.
 */

@Controller
@RequestMapping("/archives")
public class ArchivesController {
    private static Logger logger = LoggerFactory.getLogger(AbnormalController.class);

    @Inject
    private ArchivesService archivesService;

	@RequestMapping(value = "/query", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody Object query(String sfzh) {
        BigScreenDomain bigScreenDomain = new BigScreenDomain();
        BigScreenDataDomain bigScreenDataDomain = new BigScreenDataDomain();
        bigScreenDataDomain.setDataset(archivesService.get(sfzh));
        bigScreenDomain.setData(bigScreenDataDomain);
		return bigScreenDomain;
	}

    @RequestMapping(value = "/post", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody Object post(@RequestBody ArchivesDomain archivesDomain) {
        try {
            archivesService.insertOrUpdate(archivesDomain);
            return new ErrorResponse.Builder(0,"success").build();
        }catch (Exception e){
            return new ErrorResponse.Builder(-1,"error").build();
        }
    }
}
