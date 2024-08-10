package com.loose.coupling;

public class WebServiceDataProvider implements UserDateProvider {
    @Override
    public String getUserDetails() {
        return "Fetching data from webservice";
    }
}
