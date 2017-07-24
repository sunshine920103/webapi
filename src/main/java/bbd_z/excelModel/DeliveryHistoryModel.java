package bbd_z.excelModel;

import bbd_z.downloadsDomains.ArchiveOne;
import bbd_z.downloadsDomains.SubSendTwo;
import bbd_z.excel.ExcelCell;

/**
 * Created by cc on 2017/7/22.
 */
public class DeliveryHistoryModel {
    @ExcelCell(index = 0)
    private int id;
    @ExcelCell(index = 1)
    private String name;
    @ExcelCell(index = 2)
    private String idCard;
    @ExcelCell(index = 3)
    private final String relation="寄递关系";
    @ExcelCell(index = 4)
    private String ecOrderID;
    @ExcelCell(index = 5)
    private String goodsName;
    @ExcelCell(index = 6)
    private String senderName;
    @ExcelCell(index = 7)
    private String senderMobile;
    @ExcelCell(index = 8)
    private String senderAddress;
    @ExcelCell(index = 9)
    private final String sendTime="无";
    @ExcelCell(index = 10)
    private String receiverName;
    @ExcelCell(index = 11)
    private String receiverMobile;
    @ExcelCell(index = 12)
    private String receiverAddress;
    @ExcelCell(index = 13)
    private final String receiveTime="无";

    public DeliveryHistoryModel(int id, String name, String idCard, String ecOrderID, String goodsName, String senderName, String senderMobile, String senderAddress, String receiverName, String receiverMobile, String receiverAddress) {
        this.id = id;
        this.name = name;
        this.idCard = idCard;
        this.ecOrderID = ecOrderID;
        this.goodsName = goodsName;
        this.senderName = senderName;
        this.senderMobile = senderMobile;
        this.senderAddress = senderAddress;
        this.receiverName = receiverName;
        this.receiverMobile = receiverMobile;
        this.receiverAddress = receiverAddress;
    }

    public DeliveryHistoryModel(int id, ArchiveOne one, SubSendTwo two){
        this.id = id;
        this.name = one.getXm();
        this.idCard = one.getSfzh();
        this.ecOrderID = two.getEcOrderID();
        this.goodsName = two.getGoodsName();
        this.senderName = two.getSenderName();
        this.senderMobile = two.getSenderMobile();
        this.senderAddress = two.getSenderAddress();
        this.receiverName = two.getReceiverName();
        this.receiverMobile = two.getReceiverMobile();
        this.receiverAddress = two.getReceiverAddress();
    }

    public String getRelation(){
        return relation;
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

    public String getEcOrderID() {
        return ecOrderID;
    }

    public void setEcOrderID(String ecOrderID) {
        this.ecOrderID = ecOrderID;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getSenderMobile() {
        return senderMobile;
    }

    public void setSenderMobile(String senderMobile) {
        this.senderMobile = senderMobile;
    }

    public String getSenderAddress() {
        return senderAddress;
    }

    public void setSenderAddress(String senderAddress) {
        this.senderAddress = senderAddress;
    }

    public String getSendTime() {
        return sendTime;
    }


    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getReceiverMobile() {
        return receiverMobile;
    }

    public void setReceiverMobile(String receiverMobile) {
        this.receiverMobile = receiverMobile;
    }

    public String getReceiverAddress() {
        return receiverAddress;
    }

    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress;
    }

    public String getReceiveTime() {
        return receiveTime;
    }

}
