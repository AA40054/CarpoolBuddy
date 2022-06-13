package com.example.carpoolbuddy.Model;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.carpoolbuddy.R;

public class VehiclesInfoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    protected TextView ownerText;
    protected TextView seatsText;
    private OnVehicleListener onVehicleListener;

    public VehiclesInfoViewHolder(@NonNull View itemView, OnVehicleListener onVehicleListener) {
        super(itemView);

        ownerText = itemView.findViewById(R.id.ownerTextView);
        seatsText = itemView.findViewById(R.id.seatsTextView);
        this.onVehicleListener = onVehicleListener;
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        onVehicleListener.onVehicleClick(getAdapterPosition());
    }

    public interface OnVehicleListener{
        void onVehicleClick(int position);
    }
}
