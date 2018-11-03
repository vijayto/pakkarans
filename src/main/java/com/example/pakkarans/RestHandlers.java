package com.example.pakkarans;

import io.restassured.RestAssured;

import java.net.MalformedURLException;
import java.net.URL;

public class RestHandlers<T> {


    public T postRequest(String url) throws MalformedURLException {
        return (T) RestAssured.given().post(new URL(url)).andReturn().getBody().asString();

    }


}
