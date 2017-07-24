package bbd_z.domain;

/**
 * Created by rex on 17-7-9.
 */
public class DisplayDomain {

    private String xm = "";
    private String sfzh = "";
    private String status = "";

    @Override
    public String toString() {
        return "DisplayDomain{" +
                "xm='" + xm + '\'' +
                ", sfzm='" + sfzh + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public String getXm() {
        return xm;
    }

    public void setXm(String xm) {
        this.xm = xm;
    }

    public String getSfzh() {
        return sfzh;
    }

    public void setSfzh(String sfzh) {
        this.sfzh = sfzh;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
