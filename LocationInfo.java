package com.gtech.hotel.extra;

import static com.google.android.gms.location.Priority.PRIORITY_HIGH_ACCURACY;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.CancellationTokenSource;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.io.IOException;
import java.util.Locale;

public class LocationInfo {
    //implementation 'com.google.android.gms:play-services-location:21.0.1' jcentral()

    private static final String TAG = "LocationInfo";
    boolean gps_enabled = false;
    String latitudeStr, longitudeStr, addressStr;
    private final CancellationTokenSource cancellationTokenSource = new CancellationTokenSource();
    public void requestCurrentLocation(Activity activity){
        FusedLocationProviderClient fusedLocationClient= LocationServices.getFusedLocationProviderClient(activity);
        if (ActivityCompat.checkSelfPermission(activity, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(activity,
                Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION}, 100);

        }
        else{
            if(!isGpsEnabled(activity)){
                AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                builder.setTitle("Enable Your Location");
                builder.setMessage("Enable Gps");
                builder.setCancelable(false);
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                AlertDialog alertDialog = builder.create();

                alertDialog.show();
            }
            else{
                Task<Location> currentLocationTask=fusedLocationClient.getCurrentLocation(PRIORITY_HIGH_ACCURACY,cancellationTokenSource.getToken());
                Geocoder gcd=new Geocoder(activity, Locale.getDefault());
                currentLocationTask.addOnCompleteListener(new OnCompleteListener<Location>() {
                    @Override
                    public void onComplete(@NonNull Task<Location> task) {
                        if(task.isSuccessful()){
                            try {
                                Location location=task.getResult();
                                latitudeStr= String.valueOf(location.getLatitude());
                                longitudeStr=String.valueOf(location.getLongitude());
                                addressStr=String.valueOf(gcd.getFromLocation(location.getLatitude(),location.getLongitude(),1).get(0).getAddressLine(0));
                                String dd=String.valueOf(gcd.getFromLocation(location.getLatitude(),location.getLongitude(),1).get(0).getPostalCode());
                                String dd1=String.valueOf(gcd.getFromLocation(location.getLatitude(),location.getLongitude(),1).get(0).getLocality());
                                String dd2=String.valueOf(gcd.getFromLocation(location.getLatitude(),location.getLongitude(),1).get(0).getCountryCode());
                                String dd3=String.valueOf(gcd.getFromLocation(location.getLatitude(),location.getLongitude(),1).get(0).getSubLocality());
                                String dd4=String.valueOf(gcd.getFromLocation(location.getLatitude(),location.getLongitude(),1).get(0).getAdminArea());
                                Log.d(TAG,"Address-> "+addressStr);
                                Log.d(TAG,"Postal-> "+dd);
                                Log.d(TAG,"Locality-> "+dd1);
                                Log.d(TAG,"Country->"+dd2);
                                Log.d(TAG,"Sub Locality->"+dd3);
                                Log.d(TAG,"Admin Area->"+dd4);
                            }
                            catch(IOException err){
                                err.printStackTrace();
                            }
                        }
                    }
                });
            }
        }
    }

    private boolean isGpsEnabled(Activity activity) {
        LocationManager lm = (LocationManager) activity.getSystemService(Context.LOCATION_SERVICE);
        gps_enabled=lm.isProviderEnabled(LocationManager.GPS_PROVIDER);
        //Log.d("")
        if(gps_enabled){
            return gps_enabled;
        }
        else{
            return gps_enabled;
        }
    }
}
