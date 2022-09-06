package com.automation.utils;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.interactions.Actions;

public class Util extends PageObject {

//Function para Firefox por que no reconoce la funcion de serenity
    public boolean scrollToElement(WebElementFacade element){
        try{
            evaluateJavascript("arguments[0].scrollIntoView(true)",element);
            return true;
        } catch (Exception e){
            return false;
              }
    }
    public boolean getReadOnly(WebElementFacade element){

        try{
          evaluateJavascript("arguments[0].removeAttribute('readonly','readonly')",element);
            System.out.println("Cambio Reandonly True");
            return true;
        }catch (Exception e){
            System.out.println("Cambio Reandonly False");
            return false;

        }
    }
    public void clickOutside(){
        Actions actions=new Actions(getDriver());
        actions.moveByOffset(0,0).click().build().perform();
    }









}
