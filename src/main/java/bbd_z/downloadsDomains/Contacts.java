package bbd_z.downloadsDomains;

/**
 * Created by cc on 2017/7/22.
 */
public class Contacts {
    private String name;
    private String userNum;
    private String idCard;

    public Contacts(String name, String userNum, String idCard) {
        this.name = name;
        this.userNum = userNum;
        this.idCard = idCard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserNum() {
        return userNum;
    }

    public void setUserNum(String userNum) {
        this.userNum = userNum;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    @Override
    public String toString() {
        return name+","+userNum+","+idCard;
    }
}
