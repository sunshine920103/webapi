package bbd_z.downloadsDomains;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by cc on 2017/7/24.
 */
public class JMFive {
    @JsonProperty("usernum")
    private String usernum;
    @JsonProperty("idCard")
    private String idCard;
    @JsonProperty("name")
    private String name;

    public JMFive() {
    }

    public JMFive(String usernum, String idCard, String name) {
        this.usernum = usernum;
        this.idCard = idCard;
        this.name = name;
    }

    public String getUsernum() {
        return usernum;
    }

    public void setUsernum(String usernum) {
        this.usernum = usernum;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name+","+usernum+","+idCard+"\n";
    }
}
