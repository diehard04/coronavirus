package com.diehard04.cvirus.ui.home;

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

import com.diehard04.cvirus.R;
import com.diehard04.cvirus.model.CoronaHomeModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private TextView tvTotalCases, tvTotalCritical, tvTotalNewCases, tvTotalRecovered;
    private DatabaseReference mDatabaseReference;
    private FirebaseDatabase mFirebaseInstance;


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
        tvTotalNewCases = root.findViewById(R.id.tv_new_cases_numbers);
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
        mDatabaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                System.out.println(" data= " + dataSnapshot.getValue());
                CoronaHomeModel coronaHomeModel = dataSnapshot.getValue(CoronaHomeModel.class);
                tvTotalCases.setText(coronaHomeModel.getTotal_cases());
                tvTotalCritical.setText(coronaHomeModel.getTotal_critical());
                tvTotalNewCases.setText(coronaHomeModel.getTotal_death());
                tvTotalRecovered.setText(coronaHomeModel.getTotal_recovered());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}