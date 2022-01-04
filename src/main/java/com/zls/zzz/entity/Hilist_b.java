package com.zls.zzz.entity;

public class Hilist_b {
    private Integer id;
    private String hilistCode;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHilistCode() {
        return hilistCode;
    }

    public void setHilistCode(String hilistCode) {
        this.hilistCode = hilistCode;
    }

    @Override
    public String toString() {
        return "Hilist_b{" +
                "id=" + id +
                ", hilistCode='" + hilistCode + '\'' +
                '}';
    }

    public Hilist_b() {
    }
}
