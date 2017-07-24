package bbd_z.downloadsDomains;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

/**
 * Created by cc on 2017/7/23.
 */

public class QqAccountInfo {
    @JsonProperty("QQAccountInfoItem")
    private ArrayList<Account> QQAccountInfoItem=new ArrayList<>();

    public QqAccountInfo(){
    }
    public QqAccountInfo(ArrayList<Account> QQAccountInfoItem) {
        this.QQAccountInfoItem = QQAccountInfoItem;
    }

    public ArrayList<Account> getQqAccountInfoItem() {
        return QQAccountInfoItem;
    }

    public void setQqAccountInfoItem(ArrayList<Account> QQAccountInfoItem) {
        this.QQAccountInfoItem = QQAccountInfoItem;
    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        for(Account account:QQAccountInfoItem){
            sb.append(account.toString()+"\n");
        }
        return sb.toString();
    }
}
