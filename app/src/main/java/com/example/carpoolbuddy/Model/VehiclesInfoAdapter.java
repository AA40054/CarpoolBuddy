package com.example.carpoolbuddy.Model;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.carpoolbuddy.R;

import java.util.ArrayList;

public class VehiclesInfoAdapter extends RecyclerView.Adapter<VehiclesInfoViewHolder> {

    ArrayList<Vehicle> mData;
    private VehiclesInfoViewHolder.OnVehicleListener mOnListener;

    public VehiclesInfoAdapter(ArrayList<Vehicle> mData, VehiclesInfoViewHolder.OnVehicleListener onVehicleListener){
        this.mData = mData;
        this.mOnListener = onVehicleListener;
    }

    @NonNull
    @Override
    public VehiclesInfoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View myView = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_vehicles_row_view, parent,false);
        VehiclesInfoViewHolder holder = new VehiclesInfoViewHolder(myView, mOnListener);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull VehiclesInfoViewHolder holder, int position) {
        holder.ownerText.setText(mData.get(position).getOwner());
        holder.capacityText.setText(String.valueOf(mData.get(position).getCapacity()));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}
