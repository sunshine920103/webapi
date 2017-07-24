package bbd_z.warningDomain;

/**
 * Created by rex on 17-7-7.
 */
public class WarningReportTrans {

    private String account;

    private String accountName;

    private String accountType;

    private String resultDesc;

    private String time;

    private String location_address;

    private String location_ci;

    private String location_communicator;

    private String location_lac;

    private Double location_latitude;

    private Double location_longitude;


    @Override
    public String toString() {
        return "WarningReportTrans{" +
                "account='" + account + '\'' +
                ", accountName='" + accountName + '\'' +
                ", accountType='" + accountType + '\'' +
                ", resultDesc='" + resultDesc + '\'' +
                ", time='" + time + '\'' +
                ", location_address='" + location_address + '\'' +
                ", location_ci='" + location_ci + '\'' +
                ", location_communicator='" + location_communicator + '\'' +
                ", location_lac='" + location_lac + '\'' +
                ", location_latitude='" + location_latitude + '\'' +
                ", location_longitude='" + location_longitude + '\'' +
                '}';
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }


    public String getResultDesc() {
        return resultDesc;
    }

    public void setResultDesc(String resultDesc) {
        this.resultDesc = resultDesc;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLocation_address() {
        return location_address;
    }

    public void setLocation_address(String location_address) {
        this.location_address = location_address;
    }

    public String getLocation_ci() {
        return location_ci;
    }

    public void setLocation_ci(String location_ci) {
        this.location_ci = location_ci;
    }

    public String getLocation_communicator() {
        return location_communicator;
    }

    public void setLocation_communicator(String location_communicator) {
        this.location_communicator = location_communicator;
    }

    public String getLocation_lac() {
        return location_lac;
    }

    public void setLocation_lac(String location_lac) {
        this.location_lac = location_lac;
    }

    public Double getLocation_latitude() {
        return location_latitude;
    }

    public void setLocation_latitude(Double location_latitude) {
        this.location_latitude = location_latitude;
    }

    public Double getLocation_longitude() {
        return location_longitude;
    }

    public void setLocation_longitude(Double location_longitude) {
        this.location_longitude = location_longitude;
    }
}
