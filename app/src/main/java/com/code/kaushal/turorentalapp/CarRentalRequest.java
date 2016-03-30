package com.code.kaushal.turorentalapp;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Kaushal on 3/29/2016.
 */
public interface CarRentalRequest {
    public static final String APIKEY_PARAM = "apikey";
    public static final String DEST_PARAM = "dest";
    public static final String STARTDATE_PARAM = "startdate";
    public static final String ENDDATE_PARAM = "enddate";
    public static final String PICKUPTIME_PARAM = "pickuptime";
    public static final String DROPOFFTIME_PARAM = "dropofftime";
    public static final String FORMAT_PARAM = "format";

    public static final int TIMEOUT_VALUE = 15000;
    public static final String APIKEY_VALUE = "vywmxsh9fcx2j8w3zfb35tw2";
    public static final String FORMAT_JSON_VALUE = "JSON";

    public static final String SERVER_URL = "http://api.hotwire.com/";
    public static final String SEARCH_CAR_API = "v1/search/car";
    public static final String DEFAULT_KEY_VALUES = APIKEY_PARAM + "=" + APIKEY_VALUE + "&" + FORMAT_PARAM + "=" + FORMAT_JSON_VALUE;


    @GET(SEARCH_CAR_API + "?" + DEFAULT_KEY_VALUES)
    public abstract Call<ApiResult> findCars (@Query(DEST_PARAM) String dest, @Query(STARTDATE_PARAM) String startDate,
                                              @Query(ENDDATE_PARAM) String endDate, @Query(PICKUPTIME_PARAM) String pickUpTime,
                                              @Query(DROPOFFTIME_PARAM) String dropOffTime);
}
