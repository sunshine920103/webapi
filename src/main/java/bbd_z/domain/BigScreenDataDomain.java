package bbd_z.domain;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
import java.util.Map;

/**
 * Created by rex on 17-7-15.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BigScreenDataDomain {
    private int pageInfo=0;
    private List dataset;
    private Map lktj;
    private Map sftj;
    private Map bqfb;


    public int getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(int pageInfo) {
        this.pageInfo = pageInfo;
    }

    public List getDataset() {
        return dataset;
    }

    public void setDataset(List dataset) {
        this.dataset = dataset;
    }
}
