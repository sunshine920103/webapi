package bbd_z.service;

import bbd_z.dao.ArchivesMapper;
import bbd_z.domain.ArchivesDomain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/**
 * Created by rex on 17-7-16.
 */
@Service
public class ArchivesService {

    private static Logger logger = LoggerFactory.getLogger(ArchivesService.class);

    @Inject
    private ArchivesMapper archivesMapper;

    public List<ArchivesDomain> get(String sfzh) {
        return archivesMapper.select(sfzh);
    }

    public void insertOrUpdate(ArchivesDomain archivesDomain) {
        String para;
        try {
            if (isExists(archivesDomain.getSfzh())){
                para=reflectToUpdate(archivesDomain);
                archivesMapper.updata(para,archivesDomain.getSfzh());
            }else {
                para=reflectToInsert(archivesDomain);
                archivesMapper.insert(para);
            }
        }catch (Exception e){
                logger.error(e.getMessage());
        }
    }


    public boolean isExists(String sfzh) {
        Boolean a = true;
        if (archivesMapper.isExists(sfzh) == 0) {
            a = false;
        }
        return a;
    }

    private String reflectToInsert(Object model) throws NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

        StringBuilder ziduan = new StringBuilder();
        StringBuilder ziduan_value = new StringBuilder();

        ziduan.append("(");

        // 获取实体类的所有属性，返回Field数组
        Field[] field = model.getClass().getDeclaredFields();
        // 遍历所有属性
        for (int j = 0; j < field.length; j++) {
            String ziduan_name = "" ;
            // 获取属性的名字
            String name = field[j].getName();
            ziduan_name = name;
            // 将属性的首字符大写，方便构造get，set方法
            name = name.substring(0, 1).toUpperCase() + name.substring(1);
            // 获取属性的类型
            String type = field[j].getGenericType().toString();
            // 如果type是类类型，则前面包含"class "，后面跟类名
            if (type.equals("class java.lang.String")) {
                Method m = model.getClass().getMethod("get" + name);
                // 调用getter方法获取属性值
                String value = (String) m.invoke(model);
                if (value != null) {
                    ziduan.append("`"+ziduan_name+"`,");
                    ziduan_value.append("\""+value+"\",");
                }
            }
            if (type.equals("class java.lang.Integer")) {
                Method m = model.getClass().getMethod("get" + name);
                Integer value = (Integer) m.invoke(model);
                if (value != null) {
                    ziduan.append("`"+ziduan_name+"`,");
                    ziduan_value.append(value+",");
                }
            }
            if (type.equals("class java.lang.Boolean")) {
                Method m = model.getClass().getMethod("get" + name);
                Boolean value = (Boolean) m.invoke(model);
                if (value != null) {
                    ziduan.append("`"+ziduan_name+"`,");
                    ziduan_value.append(value+",");
                }
            }
        }
        ziduan.append("`lasttime`) values(");
        ziduan_value.append("NOW())");
        ziduan.append(ziduan_value);

        return ziduan.toString();
    }

    private String reflectToUpdate(Object model) throws NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

        StringBuilder ziduan = new StringBuilder();

        // 获取实体类的所有属性，返回Field数组
        Field[] field = model.getClass().getDeclaredFields();
        // 遍历所有属性
        for (int j = 0; j < field.length; j++) {
            String ziduan_name = "" ;
            // 获取属性的名字
            String name = field[j].getName();
            ziduan_name = name;
            // 将属性的首字符大写，方便构造get，set方法
            name = name.substring(0, 1).toUpperCase() + name.substring(1);
            // 获取属性的类型
            String type = field[j].getGenericType().toString();
            // 如果type是类类型，则前面包含"class "，后面跟类名
            if (type.equals("class java.lang.String")) {
                Method m = model.getClass().getMethod("get" + name);
                // 调用getter方法获取属性值
                String value = (String) m.invoke(model);
                if (value != null) {
                    ziduan.append("`"+ziduan_name+"`="+"\""+value+"\",");
                }
            }
            if (type.equals("class java.lang.Integer")) {
                Method m = model.getClass().getMethod("get" + name);
                Integer value = (Integer) m.invoke(model);
                if (value != null) {
                    ziduan.append("`"+ziduan_name+"`="+value+",");
                }
            }
            if (type.equals("class java.lang.Boolean")) {
                Method m = model.getClass().getMethod("get" + name);
                Boolean value = (Boolean) m.invoke(model);
                if (value != null) {
                    ziduan.append("`"+ziduan_name+"`="+value+",");
                }
            }
        }
        ziduan.append("`lasttime`=NOW()");

        return ziduan.toString();
    }
}