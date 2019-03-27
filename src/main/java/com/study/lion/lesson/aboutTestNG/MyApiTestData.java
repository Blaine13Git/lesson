package com.study.lion.lesson.aboutTestNG;

import org.testng.annotations.DataProvider;

import java.io.IOException;

public class MyApiTestData {
    MyExcel myExcel = new MyExcel();

    @DataProvider(name = "loginData")
    public Object[][] getLoginData() throws IOException {
        return myExcel.readExcel("src/test/java/testFile/TestData.xlsx", "login");
    }
}
