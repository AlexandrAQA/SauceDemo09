package com.aqa;

import org.apache.commons.collections4.CollectionUtils;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ProductsTest extends BaseTest {

    @Test
    public void productsShouldBeAddedToCart() {
        loginSteps.loginAsStandardUser();

        final String SAUCE_LABS_BACKPACK = "Sauce Labs Backpack";
        final String SAUCE_LABS_ONESIE = "Sauce Labs Onesie";

        productsPage.addToCart(SAUCE_LABS_BACKPACK);
        productsPage.addToCart(SAUCE_LABS_ONESIE);
        headerPage.openCart();
        cartPage.removeProductFromCart(SAUCE_LABS_ONESIE);
        List<WebElement> allProductsInCartAfterRemove = cartPage.getAllProductsInCart();
        //CollectionUtils.size(allProductsInCartAfterRemove);
        Assert.assertEquals(allProductsInCartAfterRemove.size(), 1,
                "only 1 product should be in the cart");
        Assert.assertEquals(allProductsInCartAfterRemove.get(0).getText(),
                SAUCE_LABS_BACKPACK,
                "\"Sauce Labs Backpack\" product should be in the cart");
    }
}
