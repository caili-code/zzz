package com.zls.zzz.entity;

public class Haocai {
    private Integer id;
    private String hcdm;
    private String sfxmlb;

    public Haocai(Integer id, String hcdm, String sfxmlb) {
        this.id = id;
        this.hcdm = hcdm;
        this.sfxmlb = sfxmlb;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHcdm() {
        return hcdm;
    }

    public void setHcdm(String hcdm) {
        this.hcdm = hcdm;
    }

    public String getSfxmlb() {
        return sfxmlb;
    }

    public void setSfxmlb(String sfxmlb) {
        this.sfxmlb = sfxmlb;
    }

    @Override
    public String toString() {
        return "Haocai{" +
                "id=" + id +
                ", hcdm='" + hcdm + '\'' +
                ", sfxmlb='" + sfxmlb + '\'' +
                '}';
    }
}
