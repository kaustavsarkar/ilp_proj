package com.tcs.ilp.POJO.User;

public class UserContactDetails {

    private String[] personalNumber;
    private String[] homeNumber;
    private String[] workNumber;
    private String email;

    public String[] getPersonalNumber() {
        return personalNumber;
    }
    public void setPersonalNumber(String[] personalNumber) {
        this.personalNumber = personalNumber;
    }
    public String[] getHomeNumber() {
        return homeNumber;
    }
    public void setHomeNumber(String[] homeNumber) {
        this.homeNumber = homeNumber;
    }
    public String[] getWorkNumber() {
        return workNumber;
    }
    public void setWorkNumber(String[] workNumber) {
        this.workNumber = workNumber;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

}
