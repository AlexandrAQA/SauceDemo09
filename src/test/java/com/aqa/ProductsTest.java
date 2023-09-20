package com.aqa;

import org.testng.annotations.Test;

public class ProductsTest extends BaseTest {

    @Test
    public void productsShouldBeAddedToCart() {
        loginPage.open();
        loginPage.loginAsValidUser();
        productsPage.open();

        final String SAUCE_LABS_BACKPACK = "Sauce Labs Backpack";
        final String LABS_BOLT_T_SHIRT = "Sauce Labs Bolt T-Shirt";

        productsPage.addToCart(SAUCE_LABS_BACKPACK);
        productsPage.addToCart(LABS_BOLT_T_SHIRT);
        cartPage.removeProductFromCart(LABS_BOLT_T_SHIRT);

    }
}
