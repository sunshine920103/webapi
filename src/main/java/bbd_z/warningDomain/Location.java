package bbd_z.warningDomain;

/**
 * 预警报告中位置信息
 * Created by rex on 17-7-7.
 */
public class Location {

    private String address;

    private String ci;

    private String communicator;

    private String lac;

    private Double latitude;

    private Double longitude;

    @Override
    public String toString() {
        return "Location{" +
                "address='" + address + '\'' +
                ", ci='" + ci + '\'' +
                ", communicator='" + communicator + '\'' +
                ", lac='" + lac + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public String getCommunicator() {
        return communicator;
    }

    public void setCommunicator(String communicator) {
        this.communicator = communicator;
    }

    public String getLac() {
        return lac;
    }

    public void setLac(String lac) {
        this.lac = lac;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
}
