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
import com.diehard04.coronavirus.model.CoronaHomeModel;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private TextView tvTotalCases, tvTotalCritical, tvTotalDeath, tvTotalRecovered;
    private DatabaseReference mDatabaseReference;
    private FirebaseDatabase mFirebaseInstance;
    private MobileAds mMobileAds;
    private AdView mAdView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        mFirebaseInstance = FirebaseDatabase.getInstance();
        mDatabaseReference = mFirebaseInstance.getReference("coronahome");
        final TextView textView = root.findViewById(R.id.text_home);
        tvTotalCases = root.findViewById(R.id.tv_total_case);
        tvTotalCritical = root.findViewById(R.id.tv_critical_numbers);
        tvTotalDeath = root.findViewById(R.id.tv_death_numbers);
        tvTotalRecovered = root.findViewById(R.id.tv_recovered_numbers);
        mAdView = root.findViewById(R.id.ad_view);
        updateDataFromFirebase();
        initAdsView();
        homeViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }

    private void initAdsView() {
        mMobileAds.initialize(getContext(), new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
                System.out.println("initAdsView = " + initializationStatus);
            }
        });
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }

    private void updateDataFromFirebase() {
        mDatabaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                System.out.println(" data= " + dataSnapshot.getValue());
                CoronaHomeModel coronaHomeModel = dataSnapshot.getValue(CoronaHomeModel.class);
                tvTotalCases.setText(coronaHomeModel.getTotal_cases());
                tvTotalCritical.setText(coronaHomeModel.getTotal_critical());
                tvTotalDeath.setText(coronaHomeModel.getTotal_death());
                tvTotalRecovered.setText(coronaHomeModel.getTotal_recovered());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}