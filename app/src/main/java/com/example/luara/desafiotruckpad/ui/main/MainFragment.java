package com.example.luara.desafiotruckpad.ui.main;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.luara.desafiotruckpad.R;

public class MainFragment extends Fragment {

    private MainViewModel mViewModel;
    public TextView temperature, city, description;
    private View v;
    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.main_fragment, container, false);
        temperature = (TextView) v.findViewById(R.id.temperature);
        city = (TextView) v.findViewById(R.id.city);
        description = (TextView) v.findViewById(R.id.description);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        city.setText(getActivity().getIntent().getExtras().getString("city"));
        description.setText(getActivity().getIntent().getExtras().getString("description"));
        temperature.setText(getActivity().getIntent().getExtras().getString("temperature"));
        // TODO: Use the ViewModel
    }

}
