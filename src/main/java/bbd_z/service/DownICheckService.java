package bbd_z.service;

import bbd_z.dao.DownICheckMapper;
import bbd_z.downloadsDomains.*;
import bbd_z.excelModel.ICheckModel;
import info.bbd.utils.json.JsonUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cc on 2017/7/22.
 */
@Service
public class DownICheckService {
    private static Logger logger = LoggerFactory.getLogger(DownICheckService.class);
    @Inject
    private DownICheckMapper downICheckMapper;
    private ICheckStringOne icheckOne;

    public List<SameFamily> getSameFamily(String id) {
        icheckOne = downICheckMapper.getOne(id);
        String jtcy = icheckOne.getJtcy_list();
        ArrayList<SameFamily> result = new ArrayList<>();
        String name = "";
        String gender = "";
        String idCard = "";
        String relation = "";
        if (jtcy.length() == 0 || jtcy == null) {
            result.add(new SameFamily(name, gender, idCard, relation));
            return result;
        }
        JSONObject jtcyObj = new JSONObject(jtcy);
        JSONArray jtcyArr = jtcyObj.getJSONArray("jtcy_list");
        for (Object obj : jtcyArr) {
            JSONObject o = (JSONObject) obj;
            try {
                name = o.getString("xm");
                gender = o.getString("xb");
                idCard = o.getString("sfzh");
                relation = o.getString("gx");
                result.add(new SameFamily(name, gender, idCard, relation));
            } catch (Exception e) {
                logger.error("家庭成员信息不全!");
            }
        }
        return result;
    }

    public List<ICheckModel> getModel(String id) {
        ArrayList<SameFamily> sameFamilies= (ArrayList<SameFamily>) getSameFamily(id);
        ArrayList<ICheckStringTwo> icheckTwo = (ArrayList<ICheckStringTwo>) downICheckMapper.getTwo(id);
        ArrayList<ICheckModel> result = new ArrayList<>();
        ArrayList<Account> accounts = new ArrayList<>();

        for (ICheckStringTwo iCheckStringTwo : icheckTwo) {
            JSONObject root = new JSONObject(iCheckStringTwo.getContent());
            ICheckModel iCheckModel = new ICheckModel();
            Object qqArr = null, wxArr = null, emailArr = null, otherArr = null, accountOpen = null, upNames = null;
            Object baseArr = null,jmFive=null,recent3=null,hotelLog=null;
            Boolean baseValied = false;
            try {
                qqArr = root.getJSONObject("personInfo").getJSONObject("otherNumber").getJSONObject("QQAccountInfo").get("QQAccountInfoItem");
            } catch (Exception e) {
                System.out.println("qqInfo");
            }
            try {
                wxArr = root.getJSONObject("personInfo").getJSONObject("otherNumber").getJSONObject("wxAccountInfo").get("wxAccountInfoItem");
            } catch (Exception e) {
                System.out.println("wxInfoWrong");
            }
            try {
                emailArr = root.getJSONObject("personInfo").getJSONObject("otherNumber").getJSONObject("emailAccountInfo").get("emailAccountInfoItem");
            } catch (Exception e) {
                System.out.println("emailInfoWrong");
            }
            try {
                otherArr = root.getJSONObject("personInfo").getJSONObject("otherNumber").getJSONObject("otherKhNumber").get("number");
            } catch (Exception e) {
                System.out.println("otherInfoWrong");
            }
            try {
                accountOpen = root.getJSONObject("personInfo").getJSONObject("CJRInfo").get("khzl");
            } catch (Exception e) {
                System.out.println("accountOpenInfoWrong");
            }

            try {
                upNames = root.getJSONObject("personInfo").getJSONObject("CJRInfo").getJSONObject("txl").getJSONObject("upChInfo").get("upChInfoItem");
            } catch (Exception e) {
                System.out.println("upNameInfoWrong");
            }

            try {
                baseArr = root.getJSONObject("personInfo").getJSONObject("baseSyrkInfo").get("baseInfo");
                baseValied = true;
            } catch (Exception e) {
                System.out.println("baseInfoWrong");
                baseValied = false;
            }

            try {
                jmFive = root.getJSONObject("personInfo").getJSONObject("relatePersonInfo").getJSONObject("JMFiveRelatePersonInfo").get("JMFiveRelatePersonInfoItem");
            } catch (Exception e) {
                System.out.println("JMFiveRelateInfoWrong");
            }

            try {
                recent3 = root.getJSONObject("personInfo").getJSONObject("activityInfo").get("recent3MonthActivityAddress");
            } catch (Exception e) {
                System.out.println("recent3MonthInfoWrong");
            }
            try {
                hotelLog = root.getJSONObject("personInfo").getJSONObject("activityInfo").getJSONObject("ZSInfo").get("ZSInfoItem");
            } catch (Exception e) {
                System.out.println("hotelLogInfoWrong");
            }
            accounts.clear();
            //qq
            if (qqArr != null)
                if (qqArr.toString().contains("[")) {
                    JSONArray arr = (JSONArray) qqArr;
                    for (Object obj : arr) {
                        Account account = JsonUtils.getObject(obj.toString(), Account.class);
                        accounts.add(account);
                    }
                    QqAccountInfo qqInstance = new QqAccountInfo(accounts);
                    iCheckModel.setQqAccountInfo(qqInstance.toString());
                } else {
                    JSONObject arr = (JSONObject) qqArr;
                    Account account = JsonUtils.getObject(arr.toString(), Account.class);
                    accounts.add(account);
                    QqAccountInfo qqInstance = new QqAccountInfo(accounts);
                    iCheckModel.setQqAccountInfo(qqInstance.toString());
                }
            accounts.clear();
            //wx
            if (wxArr != null)
                if (wxArr.toString().contains("[")) {
                    JSONArray arr = (JSONArray) wxArr;
                    for (Object obj : arr) {
                        Account account = JsonUtils.getObject(obj.toString(), Account.class);
                        accounts.add(account);
                    }
                    WXAccountInfo wxInstance = new WXAccountInfo(accounts);
                    iCheckModel.setWxAccountInfo(wxInstance.toString());
                } else {
                    JSONObject arr = (JSONObject) wxArr;
                    Account account = JsonUtils.getObject(arr.toString(), Account.class);
                    accounts.add(account);
                    WXAccountInfo wxInstance = new WXAccountInfo(accounts);
                    iCheckModel.setWxAccountInfo(wxInstance.toString());
                }

            accounts.clear();
            //email
            if (emailArr != null)
                if (emailArr.toString().contains("[")) {
                    JSONArray arr = (JSONArray) emailArr;
                    for (Object obj : arr) {
                        Account account = JsonUtils.getObject(obj.toString(), Account.class);
                        accounts.add(account);
                    }
                    EmailAccountInfo emInstance = new EmailAccountInfo(accounts);
                    iCheckModel.setEmailAccountInfo(emInstance.toString());
                } else {
                    JSONObject arr = (JSONObject) emailArr;
                    Account account = JsonUtils.getObject(arr.toString(), Account.class);
                    accounts.add(account);
                    EmailAccountInfo emInstance = new EmailAccountInfo(accounts);
                    iCheckModel.setEmailAccountInfo(emInstance.toString());
                }


            //other
            if (otherArr != null) {
                String otherKh = otherArr.toString().replaceAll("\\[", "").replaceAll("\\]", "");
                iCheckModel.setOtherKhNumber(otherKh);
            }


            StringBuilder sb = new StringBuilder();
            //accountOpen
            if (accountOpen != null)
                if (accountOpen.toString().contains("[")) {
                    JSONArray arr = (JSONArray) accountOpen;
                    for (Object obj : arr) {
                        OpenAccountInfo openAccountInfo = JsonUtils.getObject(obj.toString(), OpenAccountInfo.class);
                        sb.append(openAccountInfo.toString());
                    }
                    iCheckModel.setPhone(sb.toString());
                    System.out.println("ao:" + sb.toString());

                } else {
                    JSONObject arr = (JSONObject) accountOpen;
                    OpenAccountInfo openAccountInfo = JsonUtils.getObject(accountOpen.toString(), OpenAccountInfo.class);
                    iCheckModel.setPhone(openAccountInfo.toString());
                    System.out.println("ao:" + openAccountInfo.toString());

                }
            StringBuilder sb1 = new StringBuilder();
            //upnames
            if (upNames != null) {
                if (upNames.toString().contains("[")) {
                    JSONArray arr = (JSONArray) upNames;
                    for (Object obj : arr) {
                        if (obj != null) {
                            JSONObject object = (JSONObject) obj;
                            sb1.append(object.getString("upName") + ",");
                        }
                    }
                    String s = sb1.toString();
                    System.out.println("upname:" + s.toString());

                    iCheckModel.setUpnames(s.substring(0, s.length()-1));
                } else {
                    JSONObject arr = (JSONObject) upNames;
                    System.out.println("upname:" + arr.toString());

                    iCheckModel.setUpnames(arr.getString("upName"));
                }
            }


                StringBuilder sb2 = new StringBuilder();
                //baseInfo
                if (upNames != null) {
                    if (upNames.toString().contains("[")) {
                        JSONArray arr = (JSONArray) upNames;
                        for (Object obj : arr) {
                            if (obj != null) {
                                JSONObject object = (JSONObject) obj;
                                sb1.append(object.getString("upName") + ",");
                            }
                        }
                        String s = sb1.toString();
                        System.out.println("upname:" + s.toString());

                        iCheckModel.setUpnames(s.substring(0, s.length()-1));
                    } else {
                        JSONObject arr = (JSONObject) upNames;
                        System.out.println("upname:" + arr.toString());

                        iCheckModel.setUpnames(arr.getString("upName"));
                    }
                }




                    if (baseValied) {
                        if (baseArr.toString().contains("[")) {
                            JSONArray arr = (JSONArray) baseArr;
                            for (Object obj : arr) {
                                if (obj != null) {
                                    JSONObject object = (JSONObject) obj;
                                    iCheckModel.setIdCard(object.get("zjhm")+"");
                                    iCheckModel.setName(object.getString("name"));
                                    iCheckModel.setGender(object.getString("xb"));
                                    iCheckModel.setNationl(object.getString("mz"));
                                    iCheckModel.setOrginal(object.getString("jg"));
                                    iCheckModel.setNowAddress(object.getString("nowAddress"));
                                    iCheckModel.setOriginDetail(object.getString("hjAddress"));
                                    iCheckModel.setWork(object.getString("zy"));
                                    iCheckModel.setBirthdate(object.getString("csrq"));
                                    iCheckModel.setIsMarry(object.getString("hyzk"));
                                    iCheckModel.setIsEducated(object.getString("whcd"));
                                    break;
                                }
                            }
                            System.out.println("baseInfo:" + baseArr.toString());

                        } else {
                            JSONObject object = (JSONObject) baseArr;
                            iCheckModel.setIdCard(object.get("zjhm")+"");
                            iCheckModel.setName(object.getString("name"));
                            iCheckModel.setGender(object.getString("xb"));
                            iCheckModel.setNationl(object.getString("mz"));
                            iCheckModel.setOrginal(object.getString("jg"));
                            iCheckModel.setNowAddress(object.getString("nowAddress"));
                            iCheckModel.setOriginDetail(object.getString("hjAddress"));
                            iCheckModel.setWork(object.getString("zy"));
                            iCheckModel.setBirthdate(object.getString("csrq"));
                            iCheckModel.setIsMarry(object.getString("hyzk"));
                            iCheckModel.setIsEducated(object.getString("whcd"));
                            System.out.println("baseInfo:" + object.toString());
                        }
                    } else {
                        iCheckModel.setIdCard(icheckOne.getSfzh());
                        iCheckModel.setName(icheckOne.getXm());
                        iCheckModel.setGender(icheckOne.getXb());
                        iCheckModel.setNationl(icheckOne.getMz());
                        iCheckModel.setOrginal(icheckOne.getHjszd());
                        iCheckModel.setNowAddress(icheckOne.getSjjzd());
                        iCheckModel.setOriginDetail(icheckOne.getXzpcs());
                        iCheckModel.setWork(icheckOne.getSfzy());
                        iCheckModel.setBirthdate(icheckOne.getCsrq());
                        iCheckModel.setIsMarry("未知");
                        iCheckModel.setIsEducated(icheckOne.getWhcd());
                        System.out.println("Base");
                    }
                    StringBuilder sb3=new StringBuilder();
                    for(SameFamily sameFamily:sameFamilies) {
                        sb3.append(sameFamily.toString());
                    }
                    iCheckModel.setSameFamily(sb3.toString());
                    System.out.println("family"+sb3.toString());

            //jmfive
            if (jmFive != null)
                if (jmFive.toString().contains("[")) {
                    StringBuilder sb4=new StringBuilder();
                    JSONArray arr = (JSONArray) jmFive;
                    for (Object obj : arr) {
                        JMFive jmFive1 = JsonUtils.getObject(obj.toString(), JMFive.class);
                        sb4.append(jmFive1.toString());
                    }
                    iCheckModel.setContacts(sb4.toString());
                    System.out.println(sb4.toString());
                } else {
                    JSONObject arr = (JSONObject) jmFive;
                    JMFive jmFive1 = JsonUtils.getObject(arr.toString(), JMFive.class);
                    iCheckModel.setContacts(jmFive1.toString());
                    System.out.println(jmFive1.toString());

                }

            //recent3
            if (recent3 != null){
                    iCheckModel.setActivityAddress(recent3.toString().replaceAll("\\[","").replaceAll("\\]",""));
                    System.out.println(recent3.toString());
            }


            //hotelLog
            if (hotelLog != null) {
                StringBuilder sb6=new StringBuilder();
                if (hotelLog.toString().contains("[")) {
                    JSONArray arr = (JSONArray) hotelLog;
                    for (Object obj : arr) {
                        if (obj != null) {
                            JSONObject object = (JSONObject) obj;
                            HotelLogs hotelLogs = JsonUtils.getObject(obj.toString(), HotelLogs.class);
                            sb6.append(hotelLogs.toString() + ",");
                        }
                    }
                    String s = sb6.toString();
                    System.out.println("HOTEL1:"+s.toString());
                    iCheckModel.setHotelLogs(s.substring(0, s.length() - 1));
                } else {
                    HotelLogs hotelLogs = JsonUtils.getObject(hotelLog.toString(), HotelLogs.class);
                    iCheckModel.setHotelLogs(hotelLogs.toString());
                    System.out.println("HOTEL2:"+hotelLogs.toString());
                }
            }



            result.add(iCheckModel);
            }
        return result;
}
}



