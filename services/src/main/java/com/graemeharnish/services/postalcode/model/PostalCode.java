
package com.graemeharnish.services.postalcode.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PostalCode {

    @SerializedName("adminCode2")
    @Expose
    private String adminCode2;
    @SerializedName("adminCode1")
    @Expose
    private String adminCode1;
    @SerializedName("adminName2")
    @Expose
    private String adminName2;
    @SerializedName("lng")
    @Expose
    private Double lng;
    @SerializedName("countryCode")
    @Expose
    private String countryCode;
    @SerializedName("postalCode")
    @Expose
    private String postalCode;
    @SerializedName("adminName1")
    @Expose
    private String adminName1;
    @SerializedName("ISO3166-2")
    @Expose
    private String iSO31662;
    @SerializedName("placeName")
    @Expose
    private String placeName;
    @SerializedName("lat")
    @Expose
    private Double lat;

    public String getAdminCode2() {
        return adminCode2;
    }

    public void setAdminCode2(String adminCode2) {
        this.adminCode2 = adminCode2;
    }

    public String getAdminCode1() {
        return adminCode1;
    }

    public void setAdminCode1(String adminCode1) {
        this.adminCode1 = adminCode1;
    }

    public String getAdminName2() {
        return adminName2;
    }

    public void setAdminName2(String adminName2) {
        this.adminName2 = adminName2;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getAdminName1() {
        return adminName1;
    }

    public void setAdminName1(String adminName1) {
        this.adminName1 = adminName1;
    }

    public String getISO31662() {
        return iSO31662;
    }

    public void setISO31662(String iSO31662) {
        this.iSO31662 = iSO31662;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

}
