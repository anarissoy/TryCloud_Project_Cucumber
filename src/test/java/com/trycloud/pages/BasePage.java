package com.trycloud.pages;

import com.trycloud.utilities.Driver;
import com.trycloud.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    public BasePage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }

    public String returnNumberFromString(String str){ // for future
        String number = "";
        for(int i = 0; i < str.length(); i++){
            if (Character.isDigit(str.charAt(i))){
                number += str.charAt(i);
            }
        }
        return number;
    }
}
