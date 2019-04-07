package ua.lviv.iot.phoenix.noq;

import com.google.common.base.Splitter;
import com.google.firebase.database.IgnoreExtraProperties;

import java.util.HashMap;

@IgnoreExtraProperties
public class Meal {
    private String mMealName;
    private int mMealPrice;
    private boolean mIsChecked;
    private int mQuantity;
    public static int numberOfCheckedItems;

    Meal () {
        mIsChecked = false;
    }

    Meal (Object o) {
        this((HashMap<String, ?>) o);
    }

    Meal (String str) {
        this((HashMap<String, String>) Splitter.on(",").withKeyValueSeparator("=").split(str));
    }

    Meal (HashMap<String, ?> map) {
        this((String) map.get("name"), map.get("price"),
                (map.get("quantity") != null) ? map.get("quantity") : 0);
    }

    Meal (String mealName, Object mealPrice, Object mealQuantity) {
        this();
        mMealName = mealName;
        mMealPrice = Integer.parseInt(mealPrice.toString());
        mQuantity = Integer.parseInt(mealQuantity.toString());
    }

    Meal (String mealName, long mealPrice) {
        this(mealName, mealPrice, 0L);
    }

    public String toString() {
        return "{name=" + mMealName +
                ", price=" + mMealPrice +
                ", quantity=" + mQuantity + "}";
    }

    public int incrementQuantity() {
        mQuantity++;
        return getQuantity();
    }

    public int decrementQuantity() {
        mQuantity--;
        return getQuantity();
    }

    public int getQuantity() {
        return (int) (mQuantity <= 0 ? -1 : mQuantity);
    }

    public void setChecked(boolean isChecked){
        numberOfCheckedItems += isChecked ? 1 : -1;
        mIsChecked = isChecked;
    }

    public String getMealName(){
        return mMealName;
    }

    public int getMealPrice(){
        return (int) mMealPrice;
    }
}
