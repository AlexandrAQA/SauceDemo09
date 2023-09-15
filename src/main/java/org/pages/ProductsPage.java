package org.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsPage extends BasePage{

    private final By TITLE_PRODUCTS = By.xpath(".//span[@class = 'title']");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getTitle(){
        return driver.findElement(TITLE_PRODUCTS);
    }

}
