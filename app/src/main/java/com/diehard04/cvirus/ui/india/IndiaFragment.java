package com.diehard04.cvirus.ui.india;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.diehard04.cvirus.R;
import com.diehard04.cvirus.adapters.CitiesAdapter;
import com.diehard04.cvirus.model.CitiesModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class IndiaFragment extends Fragment {

    private IndiaViewModel indiaViewModel;
    private RecyclerView fIndiaRvCities;
    private List<CitiesModel> citiesModelList = new ArrayList<>();
    private CitiesAdapter mCitiesAdapter;
    private FirebaseDatabase mDatabase;
    private DatabaseReference mReferenceCountriesModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        indiaViewModel =
                ViewModelProviders.of(this).get(IndiaViewModel.class);
        View root = inflater.inflate(R.layout.fragment_india, container, false);
        initViews(root);
        initData();
        return root;
    }

    private void initData() {
        citiesModelList.clear();
        mDatabase = FirebaseDatabase.getInstance();
        mReferenceCountriesModel = mDatabase.getReference("India");
        mReferenceCountriesModel.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                System.out.println("onDataChange= " + dataSnapshot.getValue());
                List<String> keys = new ArrayList<>();
                for (DataSnapshot keyMode : dataSnapshot.getChildren()) {
                    keys.add(keyMode.getKey());
                    CitiesModel citiesModel = keyMode.getValue(CitiesModel.class);
                    citiesModelList.add(citiesModel);
                }
                mCitiesAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                System.out.println("databaseError= " + databaseError.getDetails());
            }
        });
    }

    private void initViews(View root) {
        fIndiaRvCities = root.findViewById(R.id.f_india_rv_cities);
        fIndiaRvCities.setLayoutManager(new LinearLayoutManager(getContext()));
        fIndiaRvCities.setItemAnimator(new DefaultItemAnimator());
        mCitiesAdapter = new CitiesAdapter(getContext(), citiesModelList);
        fIndiaRvCities.setAdapter(mCitiesAdapter);
    }
}