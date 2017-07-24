package bbd_z.downloadsDomains;

/**
 * Created by cc on 2017/7/22.
 */
public class SameFamily {
    private String name;
    private String gender;
    private String idCard;
    private String relation;

    public SameFamily(String name, String gender, String idCard, String relation) {
        this.name = name;
        this.gender = gender;
        this.idCard = idCard;
        this.relation = relation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    @Override
    public String toString() {
        return name+","+gender+","+idCard+","+relation+"\n";
    }
}
