package bbd_z.downloadsDomains;

import java.util.ArrayList;

/**
 * Created by cc on 2017/7/23.
 */
public class WXAccountInfo{
    private ArrayList<Account> wxAccountInfoItem=new ArrayList<>();

    public WXAccountInfo(ArrayList<Account> wxAccountInfoItem) {
        this.wxAccountInfoItem = wxAccountInfoItem;
    }

    public WXAccountInfo() {
    }

    public ArrayList<Account> getWxAccountInfoItem() {
        return wxAccountInfoItem;
    }

    public void setWxAccountInfoItem(ArrayList<Account> wxAccountInfoItem) {
        this.wxAccountInfoItem = wxAccountInfoItem;
    }
    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        for(Account account:wxAccountInfoItem){
            sb.append(account.toString()+"\n");
        }
        return sb.toString();
    }
}
