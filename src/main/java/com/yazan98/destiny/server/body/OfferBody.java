package com.yazan98.destiny.server.body;

/**
 * Created By : Yazan Tarifi
 * Date : 1/1/2020
 * Time : 1:30 PM
 */
public class OfferBody {

    private String title;
    private String body;

    public OfferBody() {

    }

    public OfferBody(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
