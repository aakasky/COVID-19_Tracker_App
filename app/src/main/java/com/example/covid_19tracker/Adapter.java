package com.example.covid_19tracker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private Context mContext;
    private List<Model> data;

    public Adapter(Context mContext, List<Model> data) {
        this.mContext = mContext;
        this.data = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        v = inflater.inflate(R.layout.data_layout, parent, false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.district.setText(data.get(position).getDistrictName());
        holder.active.setText(data.get(position).getActive());
        holder.recovered.setText(data.get(position).getRecovered());
        holder.deceased.setText(data.get(position).getDeceased());
        holder.total.setText(data.get(position).getConfirmed());
        holder.nActive.setText(data.get(position).getnActive());
        holder.nRecovered.setText(data.get(position).getnDead());
        holder.nDeceased.setText(data.get(position).getnRecovered());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView district,active,recovered,deceased,total,nActive,nRecovered,nDeceased;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            district = itemView.findViewById(R.id.textDistrictName);
            active = itemView.findViewById(R.id.activeCaseNumber);
            recovered = itemView.findViewById(R.id.curedCaseNumber);
            deceased = itemView.findViewById(R.id.deathCaseNumber);
            total = itemView.findViewById(R.id.totalCaseNumber);
            nActive = itemView.findViewById(R.id.activeIncreased);
            nRecovered = itemView.findViewById(R.id.curedIncreased);
            nDeceased = itemView.findViewById(R.id.deathIncreased);

        }
    }

}
