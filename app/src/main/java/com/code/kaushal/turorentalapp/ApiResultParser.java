package com.code.kaushal.turorentalapp;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kaushal on 3/29/2016.
 */
public class ApiResultParser {
    public static ApiResult parseJson (String json) {
        if (json == null || json.isEmpty()) {
            return null;
        }

        ApiResult hotWireResult = null;

        try {
            JSONObject jsonObj = new JSONObject(json);
            String status = jsonObj.getString("StatusCode");

            if (status == null || status.isEmpty() || !status.equals("0")) {
                return null;
            }

            hotWireResult = new ApiResult();
            hotWireResult.setResult(getResultList(jsonObj));

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return hotWireResult;
    }

    public static List<RentalNodeResult> getResultList (JSONObject jsonObj) throws JSONException{
        if (jsonObj == null) {
            return null;
        }

        JSONArray array = jsonObj.getJSONArray("Result");
        List<RentalNodeResult> list = new ArrayList<>();
        for(int i = 0; i < array.length(); i++) {
            RentalNodeResult r = getResult(array.getJSONObject(i));
            if (r != null) {
                list.add(r);
            }
        }
        return list;
    }

    public static RentalNodeResult getResult(JSONObject json) throws JSONException {
        if (json == null) {
            return null;
        }

        String currencyCode = json.getString("CurrencyCode");
        String deepLink = json.getString("DeepLink");
        String ResultId = json.getString("ResultId");
        String HWRefNumber = json.getString("HWRefNumber");
        String SubTotal = json.getString("SubTotal");
        String TaxesAndFees = json.getString("TaxesAndFees");
        String TotalPrice = json.getString("TotalPrice");
        String CarTypeCode = json.getString("CarTypeCode");
        String DailyRate = json.getString("DailyRate");
        String DropoffDay = json.getString("DropoffDay");
        String DropoffTime = json.getString("DropoffTime");
        String PickupDay = json.getString("PickupDay");
        String PickupTime = json.getString("PickupTime");
        String LocationDescription = json.getString("LocationDescription");
        String MileageDescription = json.getString("MileageDescription");
        String PickupAirport = json.getString("PickupAirport");
        String RentalDays = json.getString("RentalDays");

        RentalNodeResult r = new RentalNodeResult();
        r.setCurrencyCode(currencyCode);
        r.setDeepLink(deepLink);
        r.setResultId(ResultId);
        r.setHWRefNumber(HWRefNumber);
        r.setSubTotal(Float.parseFloat(SubTotal));
        r.setTaxesAndFees(Float.parseFloat(TaxesAndFees));
        r.setTotalPrice(Float.parseFloat(TotalPrice));
        r.setCarTypeCode(CarTypeCode);
        r.setDailyRate(Float.parseFloat(DailyRate));
        r.setDropoffDay(DropoffDay);
        r.setDropoffTime(DropoffTime);
        r.setPickupDay(PickupDay);
        r.setPickupTime(PickupTime);
        r.setLocationDescription(LocationDescription);
        r.setMileageDescription(MileageDescription);
        r.setPickupAirport(PickupAirport);
        r.setRentalDays(Integer.parseInt(RentalDays));

        return r;
    }
}
