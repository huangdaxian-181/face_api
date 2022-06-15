package com.example.face.domain;

/**
 * @author 搬砖的码农
 * @date 2022/05/17
 * @email
 **/


public class FaceUser {
    private int id;

    private int group_id;

    private int user_id;

    private String name;

    private String remark;

    private int phone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public int getGroup_id() {
        return group_id;
    }

    public int getPhone() {
        return phone;
    }

    public String getRemark() {
        return remark;
    }

    public void setGroup_id(int group_id) {
        this.group_id = group_id;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
