package bbd_z.NeoDomain;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by cc on 2017/7/18.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NeoDomain {
    private int code = 200;
    private Boolean success=true;
    private Object data;

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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
