package bbd_z.downloadsDomains;

import java.util.ArrayList;

/**
 * Created by cc on 2017/7/23.
 */
public class EmailAccountInfo {
    private ArrayList<Account> emailAccountInfoItem=new ArrayList<>();

    public EmailAccountInfo() {
    }

    public EmailAccountInfo(ArrayList<Account> emailAccountInfoItem) {
        this.emailAccountInfoItem = emailAccountInfoItem;
    }

    public ArrayList<Account> getEmailAccountInfoItem() {
        return emailAccountInfoItem;
    }

    public void setEmailAccountInfoItem(ArrayList<Account> emailAccountInfoItem) {
        this.emailAccountInfoItem = emailAccountInfoItem;
    }
    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        for(Account account:emailAccountInfoItem){
            sb.append(account.toString()+"\n");
        }
        return sb.toString();
    }
}
