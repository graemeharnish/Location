
package com.graemeharnish.services.postalcode.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PostalCodes {

    @SerializedName("postalCodes")
    @Expose
    private List<PostalCode> postalCodes = null;

    public List<PostalCode> getPostalCodes() {
        return postalCodes;
    }

    public void setPostalCodes(List<PostalCode> postalCodes) {
        this.postalCodes = postalCodes;
    }

}
