package com.code.kaushal.turorentalapp;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Kaushal on 3/29/2016.
 */
public class ResourceBundle {
    private String name;
    private String imagePath;
    private int resourceId;
    private ApiRequest request;

    public ResourceBundle() {}

    public ResourceBundle(String name, String imagePath) {
        this.name = name;
        this.imagePath = imagePath;
        this.request = createDefaultRequest();
    }

    public ResourceBundle(String name, int resourceId) {
        this.resourceId = resourceId;
        this.name = name;
        this.imagePath = "android.resource://com.example.carrentalsearching/" + resourceId;
        this.request = createDefaultRequest();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public ApiRequest getRequest() {
        if (request == null) {
            request = createDefaultRequest();
        }
        return request;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    //date = 03/23/2016 time=13:30
    private ApiRequest createDefaultRequest() {
        if (name == null)
            return null;

        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date date = new Date();

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        calendar.add(Calendar.DATE, 1);
        String startDate = dateFormat.format(calendar.getTime());

        calendar.add(Calendar.DATE, 5);
        String endDate = dateFormat.format(calendar.getTime());

        ApiRequest request = new ApiRequest(name, startDate, endDate, "12:00", "12:00");

        return request;
    }

    public static List<ResourceBundle> createDefaultCategoryList() {
        List<ResourceBundle> list = new ArrayList<ResourceBundle>();
        list.add(new ResourceBundle("Boston", R.drawable.boston));
        list.add(new ResourceBundle("New York", R.drawable.newyork));
        list.add(new ResourceBundle("Cincinnati", R.drawable.cincinnati));
        list.add(new ResourceBundle("San Francisco", R.drawable.sf));
        list.add(new ResourceBundle("Los Angeles", R.drawable.la));

        return list;
    }
}
