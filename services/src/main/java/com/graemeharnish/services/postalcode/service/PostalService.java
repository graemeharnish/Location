package com.graemeharnish.services.postalcode.service;

import com.graemeharnish.services.postalcode.model.PostalCodes;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by graemeharnish on 10/29/17.
 */

public interface PostalService {
    @GET("postalCodeSearch")
    Observable<PostalCodes> fetchPostalCode(@Query("postalcode") int postalCode);

}
