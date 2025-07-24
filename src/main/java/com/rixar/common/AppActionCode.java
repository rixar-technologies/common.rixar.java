package com.rixar.common;


public enum AppActionCode {

    NAVIGATE_TO_SUBSCRIPTION("Subscribe","Renew your subscription",false),
    NAVIGATE_TO_PHONE_VERIFICATION("Verification Required", "Verify your login details NOW", false),
    NAVIGATE_TO_BUSINESS_CREATION("Create Business", "Create business", true),
    NAVIGATE_TO_APP_UPDATE("Update Application", "Fetch Shipping Methods", false),

    NAVIGATE_TO_OTP_CHALLENGE("You have not set a password", "Use OTP for login", false),
    NAVIGATE_TO_PASSWORD_SET("Set a Password", "Set a password for faster access", false),

    NAVIGATE_TO_HOME("Not Now ", "Go Home", false),

    NAVIGATE_TO_SALES_PREFERENCES("Manage Sales Preferences", "Click here to change sales preferences", false),
    NAVIGATE_TO_CUSTOMERS_PREFERENCES("Manage Customers Preferences", "Click here to change customers preferences", false),
    NAVIGATE_TO_PRODUCTS_PREFERENCES("Manage Products Preferences", "Click here to change products preferences", false),

    VIEW_ORDER_DETAILS("View Order", "View Order", false),

    VIEW_PRODUCT_DETAILS("View Product", "View Product", false),
    VIEW_STOCK_REQUEST("View Stock Request", "View Stock Request", false),
    VIEW_STOCK_TRANSFER("View Stock Transfer", "View Stock Transfer", false),
    MANAGE_PRODUCT_STOCK("Manage Stock", "View and manage product stock", false),

    VIEW_EXPENSES("View Expenses", "View Expenses", false);

    public final String title;
    public final String narration;
    public final boolean automatic;

    AppActionCode(String title, String narration, boolean automatic) {
        this.title = title;
        this.narration = narration;
        this.automatic = automatic;
    }

}
