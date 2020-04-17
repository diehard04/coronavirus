package com.diehard04.cvirus.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.diehard04.cvirus.R;
import com.diehard04.cvirus.model.CitiesModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DIPAK on 3/5/2020.
 */
public class CitiesAdapter extends RecyclerView.Adapter<CitiesAdapter.MyViewHolder> {
    private List<CitiesModel> citiesModelArrayList = new ArrayList<>();
    private Context context;
    public CitiesAdapter(Context context, List<CitiesModel> citiesModelArrayList) {
        this.context = context;
        this.citiesModelArrayList = citiesModelArrayList;
    }
    @NonNull
    @Override
    public CitiesAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_cities, parent, false);
        return new CitiesAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CitiesAdapter.MyViewHolder holder, int position) {
        holder.adCitiesTvCityName.setText(citiesModelArrayList.get(position).getCitiesName());
        holder.adCitiesTvTotalCases.setText(citiesModelArrayList.get(position).getTotalCases());
        holder.adCitiesTvTotalNewCases.setText(citiesModelArrayList.get(position).getNewCases());
        holder.adCitiesTvActiveCases.setText(citiesModelArrayList.get(position).getTotalDeath());
        holder.adCitiesTvtvTotalRecoveredCases.setText(citiesModelArrayList.get(position).getRecoveredCases());
    }

    @Override
    public int getItemCount() {
        return citiesModelArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView adCitiesTvCityName, adCitiesTvTotalCases, adCitiesTvTotalNewCases, adCitiesTvActiveCases, adCitiesTvtvTotalRecoveredCases;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            adCitiesTvCityName = itemView.findViewById(R.id.ad_cities_tv_city_name);
            adCitiesTvTotalCases = itemView.findViewById(R.id.ad_cities_tv_total_cases);
            adCitiesTvTotalNewCases = itemView.findViewById(R.id.ad_cities_tv_new_cases);
            adCitiesTvActiveCases = itemView.findViewById(R.id.ad_cities_tv_active_cases);
            adCitiesTvtvTotalRecoveredCases = itemView.findViewById(R.id.ad_cities_tv_recovered_cases);
        }
    }
}
