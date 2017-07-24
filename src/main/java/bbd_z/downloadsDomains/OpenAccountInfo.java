package bbd_z.downloadsDomains;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by cc on 2017/7/23.
 */
public class OpenAccountInfo {
    @JsonProperty("usernum")
    private String usernum;
    @JsonProperty("useStatus")
    private String useStatus;
    @JsonProperty("address")
    private String address;
    @JsonProperty("name")
    private String name;

    public OpenAccountInfo() {
    }

    public OpenAccountInfo(String usernum, String useStatus, String address) {
        this.usernum = usernum;
        this.useStatus = useStatus;
        this.address = address;
    }

    public String getUsernum() {
        return usernum;
    }

    public void setUsernum(String usernum) {
        this.usernum = usernum;
    }

    public String getUseStatus() {
        return useStatus;
    }

    public void setUseStatus(String useStatus) {
        this.useStatus = useStatus;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return usernum+","+useStatus+","+address+"\n";
    }
}
