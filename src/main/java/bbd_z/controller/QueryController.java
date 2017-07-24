package bbd_z.controller;

import bbd_z.domain.*;
import bbd_z.service.QueryService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;

@Controller
@RequestMapping("/query")
public class QueryController {

	@Inject
	private QueryService queryService;

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody Object query(@RequestBody QueryDomain queryDomain){
		StringBuilder para = new StringBuilder();
		String tou = "`keyuserlist` where ";

		BigScreenDomain bigScreenDomain = new BigScreenDomain();
		BigScreenDataDomain bigScreenDataDomain = new BigScreenDataDomain();

		if (queryDomain.getSfzh()!=null){

		}
		if (queryDomain.getXm()!=null && queryDomain.getXm()!=""){
			para.append("`zdrxm`=\""+ queryDomain.getXm()+"\"");
			if (queryDomain.getProvince()!=null){
				para.append(" and `sf`="+ queryDomain.getProvince());
			}
			if (queryDomain.getCity()!=null){
				para.append(" and `sz`="+ queryDomain.getCity());
			}
			if (queryDomain.getCounty()!=null){
				para.append(" and `qx`="+ queryDomain.getCounty());
			}
			if (queryDomain.getLabels()!="" && queryDomain.getLabels()!=null){
				for (String label: queryDomain.getLabels().split(",")){
					para.append(" and `labels` like '%"+label+"%'");
				}
			}
			if (queryDomain.getXb()!=null && queryDomain.getXb()!=""){
				para.append(" and `xb`=\""+ queryDomain.getXb()+"\"");
			}
			if (queryDomain.getAgeStart()!=0){
				tou="(SELECT *,(year(curdate())-if(length(zdrsfzh)=18,substring(zdrsfzh,7,4),if(length(zdrsfzh)=15,concat('19',substring(zdrsfzh,7,2)),null))) as age FROM `keyuserlist`) as toltal where ";
				para.append(" and age>"+ queryDomain.getAgeStart());
			}
			if (queryDomain.getAgeEnd()!=0){
				tou="(SELECT *,(year(curdate())-if(length(zdrsfzh)=18,substring(zdrsfzh,7,4),if(length(zdrsfzh)=15,concat('19',substring(zdrsfzh,7,2)),null))) as age FROM `keyuserlist`) as toltal where ";
				para.append(" and age<"+ queryDomain.getAgeEnd());
			}
			bigScreenDataDomain.setPageInfo(queryService.getPage(tou+para.toString()));
			bigScreenDataDomain.setDataset(queryService.query(tou+para.toString(), queryDomain.getPage()));
			bigScreenDomain.setData(bigScreenDataDomain);
			return bigScreenDomain;
		}
		if (queryDomain.getProvince()!=null){
			para.append("`sf`="+ queryDomain.getProvince());
			if (queryDomain.getCity()!=null){
				para.append(" and `sz`="+ queryDomain.getCity());
			}
			if (queryDomain.getCounty()!=null){
				para.append(" and `qx`="+ queryDomain.getCounty());
			}
			if (queryDomain.getLabels()!=null && queryDomain.getLabels()!=""){
				for (String label: queryDomain.getLabels().split(",")){
					para.append(" and `labels` like '%"+label+"%'");
				}
			}
			if (queryDomain.getXb()!=null && queryDomain.getXb()!=""){
				para.append(" and `xb`=\""+ queryDomain.getXb()+"\"");
			}
			if (queryDomain.getAgeStart()!=0){
				tou="(SELECT *,(year(curdate())-if(length(zdrsfzh)=18,substring(zdrsfzh,7,4),if(length(zdrsfzh)=15,concat('19',substring(zdrsfzh,7,2)),null))) as age FROM `keyuserlist`) as toltal where ";
				para.append(" and age>"+ queryDomain.getAgeStart());
			}
			if (queryDomain.getAgeEnd()!=0){
				tou="(SELECT *,(year(curdate())-if(length(zdrsfzh)=18,substring(zdrsfzh,7,4),if(length(zdrsfzh)=15,concat('19',substring(zdrsfzh,7,2)),null))) as age FROM `keyuserlist`) as toltal where ";
				para.append(" and age<"+ queryDomain.getAgeEnd());
			}
			bigScreenDataDomain.setPageInfo(queryService.getPage(tou+para.toString()));
			bigScreenDataDomain.setDataset(queryService.query(tou+para.toString(), queryDomain.getPage()));
			bigScreenDomain.setData(bigScreenDataDomain);
			return bigScreenDomain;
		}
		if (queryDomain.getLabels()!=null && queryDomain.getLabels()!=""){
			for (String label: queryDomain.getLabels().split(",")){
				para.append("`labels` like '%"+label+"%' and ");
			}
			para.delete(para.lastIndexOf("and"),para.length()-1);
			if (queryDomain.getProvince()!=null){
				para.append(" and `sf`="+ queryDomain.getProvince());
			}
			if (queryDomain.getCity()!=null){
				para.append(" and `sz`="+ queryDomain.getCity());
			}
			if (queryDomain.getCounty()!=null){
				para.append(" and `qx`="+ queryDomain.getCounty());
			}
			if (queryDomain.getXb()!=null && queryDomain.getXb()!=""){
				para.append(" and `xb`=\""+ queryDomain.getXb()+"\"");
			}
			if (queryDomain.getAgeStart()!=0){
				tou="(SELECT *,(year(curdate())-if(length(zdrsfzh)=18,substring(zdrsfzh,7,4),if(length(zdrsfzh)=15,concat('19',substring(zdrsfzh,7,2)),null))) as age FROM `keyuserlist`) as toltal where ";
				para.append(" and age>"+ queryDomain.getAgeStart());
			}
			if (queryDomain.getAgeEnd()!=0){
				tou="(SELECT *,(year(curdate())-if(length(zdrsfzh)=18,substring(zdrsfzh,7,4),if(length(zdrsfzh)=15,concat('19',substring(zdrsfzh,7,2)),null))) as age FROM `keyuserlist`) as toltal where ";
				para.append(" and age<"+ queryDomain.getAgeEnd());
			}
			bigScreenDataDomain.setPageInfo(queryService.getPage(tou+para.toString()));
			bigScreenDataDomain.setDataset(queryService.query(tou+para.toString(), queryDomain.getPage()));
			bigScreenDomain.setData(bigScreenDataDomain);
			return bigScreenDomain;
		}
		return new ErrorResponse.Builder(-1,"error").build();
	}

	@RequestMapping(method = RequestMethod.GET,value = "/keyuser")
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody Object getKeyUserList(String username,int page){
		try{
			return queryService.getKeyUser(username,page);
		}catch (Exception e){
			return new ErrorResponse.Builder(-1,"error").build();
		}
	}

	@RequestMapping(method = RequestMethod.GET,value = "/key")
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody Object getKeyUserList(String para){



		return "";
	}
}
