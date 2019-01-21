package com.example.luara.desafiotruckpad.ui.splash;

import android.Manifest;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.luara.desafiotruckpad.MainActivity;
import com.example.luara.desafiotruckpad.R;
import com.example.luara.desafiotruckpad.SplashActivity;
import com.example.luara.desafiotruckpad.model.WeatherData;
import com.example.luara.desafiotruckpad.ui.main.MainFragment;

public class SplashFragment extends Fragment {

    private SplashViewModel mViewModel;
    LocationManager locationManager;
    String provider;
    int MY_PERMISSION = 0;

    public static SplashFragment newInstance() {
        return new SplashFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.splash_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(SplashViewModel.class);
        // TODO: Use the ViewModel



/*


        //Get Coordinates
        locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);
        provider = locationManager.getBestProvider(new Criteria(), false);

        if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(getActivity(), new String[]{

                    Manifest.permission.INTERNET,
                    Manifest.permission.ACCESS_COARSE_LOCATION,
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_NETWORK_STATE,
                    Manifest.permission.SYSTEM_ALERT_WINDOW,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE


            }, MY_PERMISSION);


        }
        Location location = locationManager.getLastKnownLocation(provider);

        if (location == null) {
            Log.d("TAG", "No location");
        }


            double longitude,latitude;
            if(location!=null){
                longitude = location.getLongitude();
                latitude = location.getLatitude();
            }else{
                longitude = -46.7238848;
                latitude = -23.5564794;
            }




            // TODO: Use the ViewModel
            mViewModel.getWeather(longitude, latitude).observe(this, new Observer<WeatherData>() {
                @Override
                public void onChanged(@Nullable WeatherData weatherResponse) {
                    ////adapter = new HeroesAdapter(MainActivity.this, heroList);
                    ///recyclerView.setAdapter(adapter);
                    Log.d("--->", "entrou");
                    if (weatherResponse.getDescription() != null) {
                        Log.d("--->", weatherResponse.getName());
                        Log.d("--->", weatherResponse.getDescription());
                        Intent i = new Intent(getActivity(), MainActivity.class);
                        i.putExtra("city", weatherResponse.getName());
                        i.putExtra("decription", weatherResponse.getDescription());
                        i.putExtra("temperature", weatherResponse.getTemperatureInCelsius());
                        startActivity(i);
                        //getActivity().finish();
                    } else
                        Log.d("--->", "entrou else");
                }

            });
*/


        if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {


            return;

        }else{

            LocationManager lm = (LocationManager)getActivity().getSystemService(Context.LOCATION_SERVICE);
            Location location = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            double latitude, longitude;
            if(location!=null){
                longitude = location.getLongitude();
                latitude = location.getLatitude();
            }else{
                longitude = -46.7238848;
                latitude = -23.5564794;
            }
            Log.d("lat--->",String.valueOf(latitude));
            Log.d("lon--->",String.valueOf(longitude));

            // TODO: Use the ViewModel
            mViewModel.getWeather(longitude, latitude).observe(this, new Observer<WeatherData>() {
                @Override
                public void onChanged(@Nullable WeatherData weatherResponse) {

                    if(weatherResponse.getDescription()!=null) {
                        Log.d("City--->", weatherResponse.getName());
                        Log.d("Desc--->", weatherResponse.getDescription());
                        Intent i = new Intent(getActivity(), MainActivity.class);
                        i.putExtra("city", weatherResponse.getName());
                        i.putExtra("description", weatherResponse.getDescription());
                        i.putExtra("temperature", weatherResponse.getTemperatureInCelsius());
                        startActivity(i);
                        //getActivity().finish();
                    }
                    else
                        Log.d("--->", "entrou else");
                }

            });
        }
    }
}
