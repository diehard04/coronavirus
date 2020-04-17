package com.diehard04.cvirus.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.diehard04.cvirus.R;
import com.diehard04.cvirus.model.CountriesModel;

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
        holder.tvCountriesName.setText(countriesModelList.get(position).getCountryName());
        holder.tvTotalCases.setText(countriesModelList.get(position).getTotalCases());
        holder.tvTotalNewCases.setText(countriesModelList.get(position).getNewCases());
        holder.tvTotalDeath.setText(countriesModelList.get(position).getTotalDeath());
        holder.tvTotalRecoveredCases.setText(countriesModelList.get(position).getRecoveredCases());
    }

    @Override
    public int getItemCount() {
        return countriesModelList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView tvCountriesName, tvTotalCases, tvTotalNewCases, tvTotalDeath, tvTotalRecoveredCases;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvCountriesName = itemView.findViewById(R.id.ad_tv_countries_name);
            tvTotalCases = itemView.findViewById(R.id.ad_tv_total_cases);
            tvTotalNewCases = itemView.findViewById(R.id.ad_tv_new_cases);
            tvTotalDeath = itemView.findViewById(R.id.ad_tv_total_death);
            tvTotalRecoveredCases = itemView.findViewById(R.id.ad_tv_recovered_cases);
        }
    }
}
