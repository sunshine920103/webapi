package bbd_z.downloadsDomains;


import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by cc on 2017/7/22.
 */
public class HotelLogs {
    @JsonProperty("hotelName")
    private String hotelName;
    @JsonProperty("rzfh")
    private String rzfh;
    @JsonProperty("rzsj")
    private String rzsj;
    @JsonProperty("tfsj")
    private String tfsj;
    @JsonProperty("gxdwbm")
    private String gxdwbm;
    @JsonProperty("gxdwmc")
    private String gxdwmc;
    public HotelLogs(){

    }

    public HotelLogs(String hotelName, String rzfh, String rzsj, String tfsj, String gxdwbm, String gxdwmc) {
        this.hotelName = hotelName;
        this.rzfh = rzfh;
        this.rzsj = rzsj;
        this.tfsj = tfsj;
        this.gxdwbm = gxdwbm;
        this.gxdwmc = gxdwmc;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getRzfh() {
        return rzfh;
    }

    public void setRzfh(String rzfh) {
        this.rzfh = rzfh;
    }

    public String getRzsj() {
        return rzsj;
    }

    public void setRzsj(String rzsj) {
        this.rzsj = rzsj;
    }

    public String getTfsj() {
        return tfsj;
    }

    public void setTfsj(String tfsj) {
        this.tfsj = tfsj;
    }

    @Override
    public String toString() {
        return hotelName+","+rzfh+","+rzsj+","+tfsj+"\n";
    }
}
