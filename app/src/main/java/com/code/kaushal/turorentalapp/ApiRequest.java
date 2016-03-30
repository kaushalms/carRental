package com.code.kaushal.turorentalapp;

import java.io.Serializable;

/**
 * Created by Kaushal on 3/29/2016.
 */
public class ApiRequest implements Serializable {
    public static final String REQUEST_EXTRA = "request_extra";

    private String destination;
    private String startDate;
    private String endDate;
    private String pickUpTime;
    private String dropOffTime;

    public ApiRequest() {}
    public ApiRequest(String destination, String startDate, String endDate, String pickUpTime, String dropOffTime) {
        this.destination = destination;
        this.startDate = startDate;
        this.endDate = endDate;
        this.pickUpTime = pickUpTime;
        this.dropOffTime = dropOffTime;
    }

    public String createStringRequest() {
        StringBuilder sb = new StringBuilder();
        sb.append(CarRentalRequest.SERVER_URL);
        sb.append(CarRentalRequest.SEARCH_CAR_API);
        sb.append("?");
        sb.append(CarRentalRequest.DEFAULT_KEY_VALUES);
        sb.append("&").append(CarRentalRequest.DEST_PARAM).append("=").append(destination);
        sb.append("&").append(CarRentalRequest.STARTDATE_PARAM).append("=").append(startDate);
        sb.append("&").append(CarRentalRequest.ENDDATE_PARAM).append("=").append(endDate);
        sb.append("&").append(CarRentalRequest.PICKUPTIME_PARAM).append("=").append(pickUpTime);
        sb.append("&").append(CarRentalRequest.DROPOFFTIME_PARAM).append("=").append(dropOffTime);
        return sb.toString().replace(" ", "+");
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getPickUpTime() {
        return pickUpTime;
    }

    public void setPickUpTime(String pickUpTime) {
        this.pickUpTime = pickUpTime;
    }

    public String getDropOffTime() {
        return dropOffTime;
    }

    public void setDropOffTime(String dropOffTime) {
        this.dropOffTime = dropOffTime;
    }

    @Override
    public String toString() {
        return "ApiRequest{" +
                "destination='" + destination + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", pickUpTime='" + pickUpTime + '\'' +
                ", dropOffTime='" + dropOffTime + '\'' +
                '}';
    }
}
