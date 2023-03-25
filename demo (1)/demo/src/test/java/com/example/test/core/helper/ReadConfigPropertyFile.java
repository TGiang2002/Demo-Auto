package com.example.test.core.helper;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfigPropertyFile {

    public static String propertiesFilePath ="src\\test\\java\\com\\example\\test\\core\\configs.properties";
    static String projectPath = System.getProperty("user.dir") + "\\";

    public static String getPropertyValue(String atrName){
        String value = null;
        try(FileInputStream input = new FileInputStream(propertiesFilePath)){
            Properties properties = new Properties();
            properties.load(input);
            value = properties.getProperty(atrName);

        }catch(Exception ex)
        {
            System.out.println(ex);
            System.out.println(ex.getMessage());
        }
        return value;
    }
}
