package com.seleniumassignment.tests;

import com.seleniumassignment.common.BaseTest;
import com.seleniumassignment.pages.HomePage;
import com.seleniumassignment.pages.ReactExamplePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EditTodoTest extends BaseTest {

    // test edit item functionality

    @Test(groups = {"sanity"})
    public void editItemTest() throws InterruptedException {

        int todoItemsToAdd = 3;
        String text = "changed";

        HomePage homePage = new HomePage(driver);

        System.out.println("opening home page");
        homePage.goTo();


        System.out.println("go to react page");
        ReactExamplePage reactExamplePage = homePage.clickOnReact();

        for (int i = 0; i < todoItemsToAdd; i++) {
            reactExamplePage.addTodoItem("to do " + i);
        }

        //change text of item
        reactExamplePage.editItem(2, text);

        //get item text after change
        String itemText = reactExamplePage.getItemText(2);

        //validate change
        Assert.assertEquals(itemText, text, "item text not matching");

        reactExamplePage.markTodoItem(0);

        Thread.sleep(3000);

    }


}

