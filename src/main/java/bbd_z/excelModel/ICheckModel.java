package bbd_z.excelModel;

import bbd_z.excel.ExcelCell;

/**
 * Created by cc on 2017/7/22.
 */
public class ICheckModel {
    @ExcelCell(index = 0)
    private String idCard;
    @ExcelCell(index = 1)
    private String phone;
    @ExcelCell(index = 2)
    private String name;
    @ExcelCell(index = 3)
    private String gender;
    @ExcelCell(index = 4)
    private String nationl;
    @ExcelCell(index = 5)
    private String orginal;
    @ExcelCell(index = 6)
    private String nowAddress;
    @ExcelCell(index = 7)
    private String originDetail;
    @ExcelCell(index = 8)
    private String work;
    @ExcelCell(index = 9)
    private String birthdate;
    @ExcelCell(index = 10)
    private String isMarry;
    @ExcelCell(index = 11)
    private String isEducated;
    @ExcelCell(index = 12)
    private String sameFamily;
    @ExcelCell(index = 13)
    private String contacts;
    @ExcelCell(index = 14)
    private String upnames;
    @ExcelCell(index = 15)
    private String activityAddress;
    @ExcelCell(index = 16)
    private String hotelLogs;
    @ExcelCell(index = 17)
    private String jwContacts;
    @ExcelCell(index = 18)
    private String jdAddress;
    @ExcelCell(index = 19)
    private String otherKhNumber;
    @ExcelCell(index = 20)
    private String qqAccountInfo;
    @ExcelCell(index = 21)
    private String wxAccountInfo;
    @ExcelCell(index = 22)
    private String emailAccountInfo;

    public ICheckModel() {
    }

    public ICheckModel(String idCard, String phone, String name, String gender, String nationl, String orginal, String nowAddress, String originDetail, String work, String birthdate, String isMarry, String isEducated, String sameFamily, String contacts, String upnames, String activityAddress, String hotelLogs, String jwContacts, String jdAddress, String otherKhNumber, String qqAccountInfo, String wxAccountInfo, String emailAccountInfo) {
        this.idCard = idCard;
        this.phone = phone;
        this.name = name;
        this.gender = gender;
        this.nationl = nationl;
        this.orginal = orginal;
        this.nowAddress = nowAddress;
        this.originDetail = originDetail;
        this.work = work;
        this.birthdate = birthdate;
        this.isMarry = isMarry;
        this.isEducated = isEducated;
        this.sameFamily = sameFamily;
        this.contacts = contacts;
        this.upnames = upnames;
        this.activityAddress = activityAddress;
        this.hotelLogs = hotelLogs;
        this.jwContacts = jwContacts;
        this.jdAddress = jdAddress;
        this.otherKhNumber = otherKhNumber;
        this.qqAccountInfo = qqAccountInfo;
        this.wxAccountInfo = wxAccountInfo;
        this.emailAccountInfo = emailAccountInfo;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public String getNationl() {
        return nationl;
    }

    public void setNationl(String nationl) {
        this.nationl = nationl;
    }

    public String getOrginal() {
        return orginal;
    }

    public void setOrginal(String orginal) {
        this.orginal = orginal;
    }

    public String getNowAddress() {
        return nowAddress;
    }

    public void setNowAddress(String nowAddress) {
        this.nowAddress = nowAddress;
    }

    public String getOriginDetail() {
        return originDetail;
    }

    public void setOriginDetail(String originDetail) {
        this.originDetail = originDetail;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getIsMarry() {
        return isMarry;
    }

    public void setIsMarry(String isMarry) {
        this.isMarry = isMarry;
    }

    public String getIsEducated() {
        return isEducated;
    }

    public void setIsEducated(String isEducated) {
        this.isEducated = isEducated;
    }

    public String getSameFamily() {
        return sameFamily;
    }

    public void setSameFamily(String sameFamily) {
        this.sameFamily = sameFamily;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public String getUpnames() {
        return upnames;
    }

    public void setUpnames(String upnames) {
        this.upnames = upnames;
    }

    public String getActivityAddress() {
        return activityAddress;
    }

    public void setActivityAddress(String activityAddress) {
        this.activityAddress = activityAddress;
    }

    public String getHotelLogs() {
        return hotelLogs;
    }

    public void setHotelLogs(String hotelLogs) {
        this.hotelLogs = hotelLogs;
    }

    public String getJwContacts() {
        return jwContacts;
    }

    public void setJwContacts(String jwContacts) {
        this.jwContacts = jwContacts;
    }

    public String getJdAddress() {
        return jdAddress;
    }

    public void setJdAddress(String jdAddress) {
        this.jdAddress = jdAddress;
    }

    public String getOtherKhNumber() {
        return otherKhNumber;
    }

    public void setOtherKhNumber(String otherKhNumber) {
        this.otherKhNumber = otherKhNumber;
    }

    public String getQqAccountInfo() {
        return qqAccountInfo;
    }

    public void setQqAccountInfo(String qqAccountInfo) {
        this.qqAccountInfo = qqAccountInfo;
    }

    public String getWxAccountInfo() {
        return wxAccountInfo;
    }

    public void setWxAccountInfo(String wxAccountInfo) {
        this.wxAccountInfo = wxAccountInfo;
    }

    public String getEmailAccountInfo() {
        return emailAccountInfo;
    }

    public void setEmailAccountInfo(String emailAccountInfo) {
        this.emailAccountInfo = emailAccountInfo;
    }
}
