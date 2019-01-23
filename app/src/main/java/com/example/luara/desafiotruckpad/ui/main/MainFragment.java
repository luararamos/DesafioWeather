package com.example.luara.desafiotruckpad.ui.main;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.luara.desafiotruckpad.R;

public class MainFragment extends Fragment {

    private MainViewModel mViewModel;
    public TextView temperature, city, description;
    private Button buttonTest;
    private View v;
    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.main_fragment, container, false);
        temperature =  v.findViewById(R.id.temp);
        city =  v.findViewById(R.id.city);
        buttonTest = v.findViewById(R.id.button);

        buttonTest.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                Toast.makeText(getContext(), "Just Unit Teste", Toast.LENGTH_SHORT).show();
            }
        });


        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        String txtCity = getActivity().getIntent().getExtras().getString("city");
        String txtDescriotion = getActivity().getIntent().getExtras().getString("description");
        String txtTemperature = getActivity().getIntent().getExtras().getString("temperature");
        temperature.setText(txtTemperature);
        city.setText(" " + txtCity + " "+ txtDescriotion);
    }

}
