package bbd_z.service;

import bbd_z.dao.FeedBackMapper;
import bbd_z.domain.FeedBackDomain;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

/**
 * Created by rex on 17-7-17.
 */
@Service
public class FeedBackService {

    @Inject
    private FeedBackMapper feedBackMapper;

    public Object inert(FeedBackDomain feedBackDomain){
        feedBackMapper.insert(feedBackDomain);
        return "";
    }

}
