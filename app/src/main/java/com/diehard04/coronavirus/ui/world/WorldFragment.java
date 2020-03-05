package com.diehard04.coronavirus.ui.world;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.diehard04.coronavirus.R;
import com.diehard04.coronavirus.adapters.CountriesAdapter;
import com.diehard04.coronavirus.model.CountriesModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class WorldFragment extends Fragment {

    private WorldViewModel worldViewModel;
    private WebView webView;
    private RecyclerView rvCountries;
    private CountriesAdapter mCountriesAdapter;
    private FirebaseDatabase mDatabase;
    private DatabaseReference mReferenceCountriesModel;
    private List<CountriesModel> countriesModelList = new ArrayList<>();
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        worldViewModel =
                ViewModelProviders.of(this).get(WorldViewModel.class);
        View root = inflater.inflate(R.layout.fragment_world, container, false);
        initView(root);
        firebaseDatabaseHelper();
        return root;
    }

    private void firebaseDatabaseHelper() {
        countriesModelList.clear();
        mDatabase = FirebaseDatabase.getInstance();
        mReferenceCountriesModel = mDatabase.getReference("world");
        mReferenceCountriesModel.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                System.out.println("onDataChange= " + dataSnapshot.getValue());
//                List<String> keys = new ArrayList<>();
//                for (DataSnapshot keyMode : dataSnapshot.getChildren()) {
//                    keys.add(keyMode.getKey());
//                    CountriesModel countriesModel = keyMode.getValue(CountriesModel.class);
//                    countriesModelList.add(countriesModel);
//                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                System.out.println("databaseError= " + databaseError.getDetails());
            }
        });
    }

    private void initView(View root) {
        countriesModelList.clear();
        rvCountries = root.findViewById(R.id.rv_countries);
        rvCountries.setLayoutManager(new LinearLayoutManager(getContext()));
        rvCountries.setItemAnimator(new DefaultItemAnimator());
        mCountriesAdapter = new CountriesAdapter(getContext(), countriesModelList);
        rvCountries.setAdapter(mCountriesAdapter);
    }
}