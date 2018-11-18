package com.gupiao.entity;

import java.util.List;

public class SohuGupiaoReturn {

    private int status;
    private List<String[]> hq;
    private String code;
    private String[] stat;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<String[]> getHq() {
        return hq;
    }

    public void setHq(List<String[]> hq) {
        this.hq = hq;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String[] getStat() {
        return stat;
    }

    public void setStat(String[] stat) {
        this.stat = stat;
    }
}