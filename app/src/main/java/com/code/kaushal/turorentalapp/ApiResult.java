package com.code.kaushal.turorentalapp;

import java.util.List;

/**
 * Created by Kaushal on 3/29/2016.
 */
public class ApiResult {
    private List<ErrorHandler> error;
    private int statusCode;
    private String statusDesc;
    private CarMetaData metaData;
    private List<RentalNodeResult> result;

    public List<ErrorHandler> getError() {
        return error;
    }

    public void setError(List<ErrorHandler> error) {
        this.error = error;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusDesc() {
        return statusDesc;
    }

    public void setStatusDesc(String statusDesc) {
        this.statusDesc = statusDesc;
    }

    public CarMetaData getMetaData() {
        return metaData;
    }

    public void setMetaData(CarMetaData metaData) {
        this.metaData = metaData;
    }

    public List<RentalNodeResult> getResult() {
        return result;
    }

    public void setResult(List<RentalNodeResult> result) {
        this.result = result;
    }

    class CarMetaData {
        private List<CarTypeNodeResult> carTypes;
        public CarMetaData() {}

        public List<CarTypeNodeResult> getCarTypes() {
            return carTypes;
        }

        public void setCarTypes(List<CarTypeNodeResult> carTypes) {
            this.carTypes = carTypes;
        }
    }
}
