package com.gupiao.entity;

import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class GupiaoEntity {
    private String name;
    private String code;
    private BigDecimal openedPrice;
    private BigDecimal yesterdayPrice;
    private BigDecimal currentPrice;
    private BigDecimal topPrice;
    private BigDecimal floorPrice;
    private Long tradeNumber;
    private BigDecimal tradeAmount;
    private String tradeDate;

    public GupiaoEntity(){}

    public GupiaoEntity(String code, String detail) throws ParseException {
        if(StringUtils.isBlank(detail)) return;
        detail = detail.replace("var hq_str_" + code + "=", "").replaceAll("\"","").replace(";","");
        String[] gupiao = detail.split(",");
        this.name = gupiao[0];
        this.code = code;
        this.openedPrice = new BigDecimal(gupiao[1]).setScale(2);
        this.yesterdayPrice = new BigDecimal(gupiao[2]).setScale(2);
        this.currentPrice = new BigDecimal(gupiao[3]).setScale(2);
        this.topPrice = new BigDecimal(gupiao[4]).setScale(2);
        this.floorPrice = new BigDecimal(gupiao[5]).setScale(2);
        this.tradeNumber = Long.parseLong(gupiao[8]);
        this.tradeAmount = new BigDecimal(gupiao[9]).setScale(2);
        this.tradeDate = gupiao[30];
    }

    public GupiaoEntity(String code, String[] gupiao){
        this.tradeDate = gupiao[0];
        this.openedPrice = new BigDecimal(gupiao[1]).setScale(2);
        this.currentPrice = new BigDecimal(gupiao[2]).setScale(2);
        this.floorPrice = new BigDecimal(gupiao[5]).setScale(2);
        this.topPrice = new BigDecimal(gupiao[6]).setScale(2);
        this.tradeNumber = Long.parseLong(gupiao[7]);
        this.tradeAmount = new BigDecimal(gupiao[8]).setScale(2);
        this.code = code;
    }

    @Override
    public String toString() {
        return "GupiaoEntity{" +
                "name='" + name + '\'' +
                ", openedPrice=" + openedPrice +
                ", yesterdayPrice=" + yesterdayPrice +
                ", currentPrice=" + currentPrice +
                ", topPrice=" + topPrice +
                ", floorPrice=" + floorPrice +
                ", tradeNumber=" + tradeNumber +
                ", tradeAmount=" + tradeAmount +
                ", tradeDate=" + tradeDate +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public BigDecimal getOpenedPrice() {
        return openedPrice;
    }

    public void setOpenedPrice(BigDecimal openedPrice) {
        this.openedPrice = openedPrice;
    }

    public BigDecimal getYesterdayPrice() {
        return yesterdayPrice;
    }

    public void setYesterdayPrice(BigDecimal yesterdayPrice) {
        this.yesterdayPrice = yesterdayPrice;
    }

    public BigDecimal getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(BigDecimal currentPrice) {
        this.currentPrice = currentPrice;
    }

    public BigDecimal getTopPrice() {
        return topPrice;
    }

    public void setTopPrice(BigDecimal topPrice) {
        this.topPrice = topPrice;
    }

    public BigDecimal getFloorPrice() {
        return floorPrice;
    }

    public void setFloorPrice(BigDecimal floorPrice) {
        this.floorPrice = floorPrice;
    }

    public Long getTradeNumber() {
        return tradeNumber;
    }

    public void setTradeNumber(Long tradeNumber) {
        this.tradeNumber = tradeNumber;
    }

    public BigDecimal getTradeAmount() {
        return tradeAmount;
    }

    public void setTradeAmount(BigDecimal tradeAmount) {
        this.tradeAmount = tradeAmount;
    }

    public String getTradeDate() {
        return tradeDate;
    }

    public void setTradeDate(String tradeDate) {
        this.tradeDate = tradeDate;
    }
}
