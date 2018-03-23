package org.client.com.bonus.model;

import java.util.Date;

public class BonusModel {
    //领取人
    private String account;
    //领取时间
    private Date starttime;
    //失效时间
    private Date endtime;
    //金额
    private Double money;
    //需满足金额
    private Double condition;

    public BonusModel() {
        super();
    }

    public BonusModel(String account, Date starttime, Date endtime, Double money, Double condition) {
        this.account = account;
        if (starttime != null)
            this.starttime = (Date) starttime.clone();
        if (endtime != null)
            this.endtime = (Date) endtime.clone();
        this.money = money;
        if (condition != null)
            this.condition = condition;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Date getStarttime() {
        return (Date) starttime.clone();
    }

    public void setStarttime(Date starttime) {
        if (starttime != null)
            this.starttime = (Date) starttime.clone();
    }

    public Date getEndtime() {
        return (Date) endtime.clone();
    }

    public void setEndtime(Date endtime) {
        if (endtime != null)
            this.endtime = (Date) endtime.clone();
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Double getCondition() {
        return condition;
    }

    public void setCondition(Double condition) {
        if (condition != null)
            this.condition = condition;
    }

    @Override
    public String toString() {
        return "BonusModel{" +
                "account='" + account + '\'' +
                ", starttime=" + starttime +
                ", endtime=" + endtime +
                ", money=" + money +
                ", condition=" + condition +
                '}';
    }
}
