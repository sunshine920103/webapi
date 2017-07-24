package bbd_z.domain;

/**
 *  警员信息
 * Created by rex on 17-7-6.
 */
public class PoliceDomain {
    private String username;//警员帐号登录名
    private String password;//警员帐号登录密码
    private String name;//警员姓名
    private String sfzh;//警员身份证号
    private int sjh;//手机号
    private String zjh;//座机号
    private String department;//隶属部门或机构
    private int province;//省
    private int city;//市
    private int county;//区县
    private int village;//县
    private String up_username;//上级用户名
    private String info_list;//可查看得字段列表
    private int auth_level;//权限级别
    private String lasttime;//最新更新时间
    
    public String getUsername() {
    
        return username;
    }
    
    
    public int getSjh() {
    
        return sjh;
    }

    
    public void setSjh(int sjh) {
    
        this.sjh = sjh;
    }

    
    public int getProvince() {
    
        return province;
    }

    
    public void setProvince(int province) {
    
        this.province = province;
    }

    
    public int getCity() {
    
        return city;
    }

    
    public void setCity(int city) {
    
        this.city = city;
    }

    
    public int getCounty() {
    
        return county;
    }

    
    public void setCounty(int county) {
    
        this.county = county;
    }

    
    public int getVillage() {
    
        return village;
    }

    
    public void setVillage(int village) {
    
        this.village = village;
    }

    public void setUsername(String username) {
    
        this.username = username;
    }
    
    public String getPassword() {
    
        return password;
    }
    
    public void setPassword(String password) {
    
        this.password = password;
    }
    
    public String getName() {
    
        return name;
    }
    
    public void setName(String name) {
    
        this.name = name;
    }
    
    public String getSfzh() {
    
        return sfzh;
    }
    
    public void setSfzh(String sfzh) {
    
        this.sfzh = sfzh;
    }
    
   
    
    public String getZjh() {
    
        return zjh;
    }
    
    public void setZjh(String zjh) {
    
        this.zjh = zjh;
    }
    
    public String getDepartment() {
    
        return department;
    }
    
    public void setDepartment(String department) {
    
        this.department = department;
    }
 
    public String getUp_username() {
    
        return up_username;
    }
    
    public void setUp_username(String up_username) {
    
        this.up_username = up_username;
    }
    
    public String getInfo_list() {
    
        return info_list;
    }
    
    public void setInfo_list(String info_list) {
    
        this.info_list = info_list;
    }
    
    
    public int getAuth_level() {
    
        return auth_level;
    }


    
    public void setAuth_level(int auth_level) {
    
        this.auth_level = auth_level;
    }
    
    public String getLasttime() {
    
        return lasttime;
    }
    public void setLasttime(String lasttime) {
    
        this.lasttime = lasttime;
    }


    @Override
    public String toString() {

        return "PoliceDomain [username=" + username + ", password=" + password + ", name=" + name
                + ", sfzh=" + sfzh + ", sjh=" + sjh + ", zjh=" + zjh + ", department=" + department
                + ", province=" + province + ", city=" + city + ", county=" + county + ", village="
                + village + ", up_username=" + up_username + ", info_list=" + info_list
                + ", auth_level=" + auth_level +", lasttime=" + lasttime +"]";
    }
    
    
}
