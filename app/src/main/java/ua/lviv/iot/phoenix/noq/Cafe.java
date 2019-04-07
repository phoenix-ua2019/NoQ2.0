package ua.lviv.iot.phoenix.noq;

import android.content.res.Resources;

import com.google.common.base.Splitter;
import com.google.firebase.database.IgnoreExtraProperties;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@IgnoreExtraProperties
public class Cafe {
    private String mCafeName;
    private String mCafeLocation;
    private String mCafeEmail;
    private String temp_mDrawableId;
    private int mDrawableId;
    private ArrayList<Meal> mCafeMeals;

    private static final int NO_IMAGE_PROVIDED = -1;

    Cafe () {
    }

    Cafe (Object o) {
        this((HashMap<String, ?>) o);
    }

    Cafe (String str) {
        this((new HashMap<>(Splitter.on("], ").withKeyValueSeparator("=[").split(str))));
    }

    Cafe (HashMap<String, ?> map) {
        mCafeName = (String) map.get("name");
        mCafeLocation = (String) map.get("location");
        mCafeEmail = (String) map.get("email");
        temp_mDrawableId = (String) map.get("icon");
        System.out.println(map);
        System.out.println(map.get("meals"));
        Object temp = map.get("meals");
        List<?> tempCafeMeals = (ArrayList<HashMap>) temp;
                //ArrayList.class.isInstance(temp);
                /*? ((ArrayList<HashMap>) temp) :
                new ArrayList(Arrays.asList(
                        ((String) temp).replace("[","")
                                .replace("]","").split(","))
                        .stream().map(Splitter.on("], ").withKeyValueSeparator("=[")::split));*/
        mCafeMeals = (ArrayList<Meal>) tempCafeMeals.stream().map(Meal::new).collect(Collectors.toList());
    }

    public Cafe setDrawable(Resources r, String name) {
        this.setDrawableId(
                r.getIdentifier(
                        this.getTempDrawableId(), "drawable", name
                ));
        return this;
    }

    @Override
    public String toString() {
        return "name=[" + mCafeName +
                "], location=[" + mCafeLocation +
                "], email=[" + mCafeEmail +
                "], icon=[" + mDrawableId +
                "], meals=[" + mCafeMeals;
    }

    public String getCafeName() {
        return mCafeName;
    }

    public String getCafeLocation() {
        return mCafeLocation;
    }

    public String getCafeEmail() {
        return mCafeEmail;
    }

    public int getDrawableId() {
        return mDrawableId;
    }

    public void setDrawableId(int id) {
        mDrawableId = id;
    }

    public String getTempDrawableId() {
        return temp_mDrawableId;
    }

    public boolean hasImage(){
        return mDrawableId != NO_IMAGE_PROVIDED;
    }

    public ArrayList<Meal> getCafeMeals() {
        return mCafeMeals;
    }

    public void setCafeMeals(ArrayList<Meal> meals) {
        mCafeMeals = meals;
    }
}
