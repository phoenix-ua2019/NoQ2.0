package ua.lviv.iot.phoenix.noq;

import java.util.Date;

public class Order {

    private Date mDate;
    private String mTime;
    private Cafe mCafe;
    private int mSum;

    public Order(String time, int sum, Date date, Cafe cafe){
        mTime = time;
        mCafe = cafe;
        mSum = sum;
        mDate = date;
    }

    public int getSum() {
        return mSum;
    }
    public Date getDate() {
        return mDate;
    }
    public Cafe getCafe() {
        return mCafe;
    }
    public String getTime() {
        return mTime;
    }
}
