package bbd_z.domain;

/**
 * Created by rex on 17-7-12.
 */
public class PicDomain {
    private String uid;
    private String pre_pic = "";
    private String last_pic = "";
    private String lasttime;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPre_pic() {
        return pre_pic;
    }

    public void setPre_pic(String pre_pic) {
        this.pre_pic = pre_pic;
    }

    public String getLast_pic() {
        return last_pic;
    }

    public void setLast_pic(String last_pic) {
        this.last_pic = last_pic;
    }

    public String getLasttime() {
        return lasttime;
    }

    public void setLasttime(String lasttime) {
        this.lasttime = lasttime;
    }
}
