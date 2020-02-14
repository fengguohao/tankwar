package com.fguohao;
import java.io.IOException;
import java.util.Properties;
public class PropertyMgr {
    static Properties prop=new Properties();
    static {
        try {
            prop.load(PropertyMgr.class.getClassLoader().getResourceAsStream("config"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object get(String key){
        if(prop.get(key)==null){
            return null;
        }
        else {
            return prop.get(key);
        }
    }

    public static int getInt(String key){
        if(prop==null){
            return 0;
        }
        else {
            return Integer.parseInt((String) PropertyMgr.get(key));
        }

    }
}
