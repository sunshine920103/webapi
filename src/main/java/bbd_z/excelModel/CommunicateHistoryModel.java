package bbd_z.excelModel;

import bbd_z.downloadsDomains.ArchiveOne;
import bbd_z.downloadsDomains.SubCommunicateTwo;
import bbd_z.excel.ExcelCell;

/**
 * Created by cc on 2017/7/20.
 */
public class CommunicateHistoryModel {
    @ExcelCell(index = 0)
    private int id;
    @ExcelCell(index = 1)
    private String name;
    @ExcelCell(index = 2)
    private String idCard;
    @ExcelCell(index = 3)
    private String phoneNum;
    @ExcelCell(index = 4)
    private final String relation="通话关系";
    @ExcelCell(index = 5)
    private String callNum;
    @ExcelCell(index = 6)
    private String callArea;
    @ExcelCell(index = 7)
    private String listenNum;
    @ExcelCell(index = 8)
    private String listenArea;
    @ExcelCell(index = 9)
    private String startTime;
    @ExcelCell(index = 10)
    private String talkLast;

    public CommunicateHistoryModel(int id, ArchiveOne one, SubCommunicateTwo two){
        this.id=id;
        this.name=one.getXm();
        this.idCard=one.getSfzh();
        this.phoneNum=one.getSj();
        this.callNum=two.getCustomerNumber();
        this.callArea=two.getUserAttAreaCode();
        this.listenNum=two.getOppositeNumber();
        this.listenArea=two.getToAttAreaCode();
        this.startTime=two.getBeginTime();
        this.talkLast=two.getTimeLen();
    }
    public CommunicateHistoryModel(int id, String name, String idCard, String phoneNum, String callNum, String callArea, String listenNum, String listenArea, String startTime, String talkLast) {
        this.id = id;
        this.name = name;
        this.idCard = idCard;
        this.phoneNum = phoneNum;
        this.callNum = callNum;
        this.callArea = callArea;
        this.listenNum = listenNum;
        this.listenArea = listenArea;
        this.startTime = startTime;
        this.talkLast = talkLast;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getCallNum() {
        return callNum;
    }

    public void setCallNum(String callNum) {
        this.callNum = callNum;
    }

    public String getCallArea() {
        return callArea;
    }

    public void setCallArea(String callArea) {
        this.callArea = callArea;
    }

    public String getListenNum() {
        return listenNum;
    }

    public void setListenNum(String listenNum) {
        this.listenNum = listenNum;
    }

    public String getListenArea() {
        return listenArea;
    }

    public void setListenArea(String listenArea) {
        this.listenArea = listenArea;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getTalkLast() {
        return talkLast;
    }

    public void setTalkLast(String talkLast) {
        this.talkLast = talkLast;
    }
}
