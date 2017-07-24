package bbd_z.service;

import bbd_z.dao.QueryMapper;
import bbd_z.domain.BigScreenDataDomain;
import bbd_z.domain.BigScreenDomain;
import bbd_z.domain.KeyUserDataDomain;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class QueryService {

	@Inject
	private QueryMapper queryMapper;

	public List<KeyUserDataDomain> query(String para, int page) {
		page= (page-1) * 10;
		List<KeyUserDataDomain> keyUserDataDomains = queryMapper.query(para, 0);
		return keyUserDataDomains;
	}

	public int getPage(String para){
		int pageInfo=queryMapper.getPage(para);
		return pageInfo;
	}

	public Object getKeyUser(String username,int page){
		int page1 = (page-1)*10;
		BigScreenDomain bigScreenDomain = new BigScreenDomain();
		BigScreenDataDomain bigScreenDataDomain = new BigScreenDataDomain();
		bigScreenDataDomain.setDataset(queryMapper.getKeyUser(username,page1));
		bigScreenDataDomain.setPageInfo(queryMapper.getKeyUserPage(username));
		bigScreenDomain.setData(bigScreenDataDomain);
		return bigScreenDomain;
	}

	public Object getKeyUserList(){


		return "";
	}
}
