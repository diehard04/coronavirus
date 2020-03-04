package com.diehard04.coronavirus.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.diehard04.coronavirus.R;
import com.diehard04.coronavirus.model.CountriesModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DIPAK on 3/4/2020.
 */
public class CountriesAdapter extends RecyclerView.Adapter<CountriesAdapter.MyViewHolder> {
    private List<CountriesModel> countriesModelList = new ArrayList<>();
    private Context context;
    public CountriesAdapter(Context context, List<CountriesModel> countriesModelList) {
        this.context = context;
        this.countriesModelList = countriesModelList;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_countries, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return countriesModelList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
