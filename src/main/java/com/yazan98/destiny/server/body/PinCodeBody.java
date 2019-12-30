package com.yazan98.destiny.server.body;

/**
 * Created By : Yazan Tarifi
 * Date : 12/30/2019
 * Time : 4:31 PM
 */
public class PinCodeBody {

    private String pinCode;
    private Long userId;

    public PinCodeBody() {

    }

    public PinCodeBody(String pinCode, Long userId) {
        this.pinCode = pinCode;
        this.userId = userId;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
