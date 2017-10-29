package com.graemeharnish.location;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.graemeharnish.services.postalcode.model.PostalCode;
import com.graemeharnish.services.postalcode.service.PostalService;
import com.graemeharnish.services.rest.RESTService;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        Disposable disposable = RESTService.createService(PostalService.class).fetchPostalCode(98101)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(postalCodes -> {
                    for (PostalCode postalCode : postalCodes.getPostalCodes()) {
                        LatLng sydney = new LatLng(postalCode.getLat(), postalCode.getLng());
                        mMap.addMarker(new MarkerOptions().position(sydney)
                                .title("Marker in " + postalCode.getPlaceName()));

                    }
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(postalCodes.getPostalCodes().get(0).getLat(), postalCodes.getPostalCodes().get(0).getLng()), 5));

                        }, (error) -> {
                        System.out.println(error.getCause());
                    }
                );

        compositeDisposable.add(disposable);

    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.getUiSettings().setZoomControlsEnabled(true);
    }
}
