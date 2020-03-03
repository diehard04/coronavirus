package com.diehard04.coronavirus.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.diehard04.coronavirus.R;
import com.diehard04.coronavirus.model.HomeModel;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private TextView tvTotalCases, tvTotalCritical, tvTotalDeath, tvTotalRecovered;
    private DatabaseReference mDatabaseReference;
    private FirebaseDatabase mFirebaseInstance;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        mFirebaseInstance = FirebaseDatabase.getInstance();
        mDatabaseReference = mFirebaseInstance.getReference();
        final TextView textView = root.findViewById(R.id.text_home);
        tvTotalCases = root.findViewById(R.id.tv_total_case);
        tvTotalCritical = root.findViewById(R.id.tv_critical_numbers);
        tvTotalDeath = root.findViewById(R.id.tv_death_numbers);
        tvTotalRecovered = root.findViewById(R.id.tv_recovered_numbers);
        updateDataFromFirebase();
        homeViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }

    private void updateDataFromFirebase() {
        HomeModel homeModel = new HomeModel("62111", "3000","2011","6000");
    }
}