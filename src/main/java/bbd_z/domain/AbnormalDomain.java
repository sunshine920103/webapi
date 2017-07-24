package bbd_z.domain;

/**
 * Created by rex on 17-7-15.
 */
public class AbnormalDomain {

    private int id;
    private String sfzh;
    private String xm;
    private String tx;
    private String source;
    private String name;
    private String normal_value;
    private String abnormal_value;
    private String lasttime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSfzh() {
        return sfzh;
    }

    public void setSfzh(String sfzh) {
        this.sfzh = sfzh;
    }

    public String getXm() {
        return xm;
    }

    public void setXm(String xm) {
        this.xm = xm;
    }

    public String getTx() {
        return tx;
    }

    public void setTx(String tx) {
        this.tx = tx;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNormal_value() {
        return normal_value;
    }

    public void setNormal_value(String normal_value) {
        this.normal_value = normal_value;
    }

    public String getAbnormal_value() {
        return abnormal_value;
    }

    public void setAbnormal_value(String abnormal_value) {
        this.abnormal_value = abnormal_value;
    }

    public String getLasttime() {
        return lasttime;
    }

    public void setLasttime(String lasttime) {
        this.lasttime = lasttime;
    }
}
