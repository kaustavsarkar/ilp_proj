package com.tcs.ilp.POJO.User;

public abstract class User {

    private int user_Id;
    private String password;
    private String category;

    public int getUser_Id() {
        return user_Id;
    }

    public void setUser_Id(final int user_Id) {
        this.user_Id = user_Id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

}
