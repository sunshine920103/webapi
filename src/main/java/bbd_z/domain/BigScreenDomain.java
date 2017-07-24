package bbd_z.domain;

import java.util.List;

/**
 * Created by rex on 17-7-15.
 */
public class BigScreenDomain {
    private int code = 200;
    private Boolean success=Boolean.TRUE;
    private BigScreenDataDomain data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public BigScreenDataDomain getData() {
        return data;
    }

    public void setData(BigScreenDataDomain data) {
        this.data = data;
    }
}
