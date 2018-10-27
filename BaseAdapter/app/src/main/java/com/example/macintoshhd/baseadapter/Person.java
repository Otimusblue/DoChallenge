package com.example.macintoshhd.baseadapter;

public class Person {

    private String mAvatar;
    private String mName;
    private String mRole;

    public Person(String avatar, String name, String role) {
        mAvatar = avatar;
        mName = name;
        mRole = role;
    }

    public String getAvatar() {
        return mAvatar;
    }

    public void setAvatar(String avatar) {
        mAvatar = avatar;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getRole() {
        return mRole;
    }

    public void setRole(String role) {
        mRole = role;
    }
}
