package com.example.test.core.datadriven;

import org.testng.annotations.DataProvider;

import com.example.test.core.helper.JsonHelper;

public class phpAccount {
    @DataProvider(name = "accountLogin")
    public static Object accountLoginPhp () {
        return JsonHelper.ReadJsonFromFile("src\\test\\java\\com\\example\\test\\resources\\datas\\phpaccountdata.json");       
    };
}
