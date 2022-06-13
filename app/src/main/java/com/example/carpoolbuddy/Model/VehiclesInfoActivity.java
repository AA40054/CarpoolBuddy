package com.example.carpoolbuddy.Model;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.carpoolbuddy.R;
import com.example.carpoolbuddy.Utils.Constants;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.FirebaseAuth;

import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class VehiclesInfoActivity extends AppCompatActivity implements VehiclesInfoViewHolder.OnVehicleListener{

    private FirebaseAuth mAuth;
    private FirebaseFirestore firestore;
    private RecyclerView recView;
    private VehiclesInfoAdapter mAdapter;

    //added for testing
    private ArrayList<Vehicle> vehiclesList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicles_info);
        mAuth = FirebaseAuth.getInstance();
        firestore = FirebaseFirestore.getInstance();
        recView = findViewById(R.id.recView);
        vehiclesList = new ArrayList<>();
        getVehicles();
    }

    public void getVehicles() {
        TaskCompletionSource<String> getAllRidesTask = new TaskCompletionSource<>();
        firestore.collection(Constants.VEHICLE_COLLECTION).whereEqualTo("open", true)
                .get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful() && task.getResult() != null) {
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        vehiclesList.add(document.toObject(Vehicle.class));
                    }
                    getAllRidesTask.setResult(null);
                }
                else {
                    Log.d("VehiclesInfoActivity", "Error getting documents from db: ", task.getException());
                }
            }
        });
        getAllRidesTask.getTask().addOnCompleteListener(new OnCompleteListener<String>() {
            @Override
            public void onComplete(@NonNull Task<String> task) {
                mAdapter = new VehiclesInfoAdapter(vehiclesList,VehiclesInfoActivity.this);
                recView.setAdapter(mAdapter);
                recView.setLayoutManager(new LinearLayoutManager(VehiclesInfoActivity.this));
            }
        });
    }


    public void goToAddVehicleActivity(View V){
        Intent intent = new Intent(this, AddVehicleActivity.class);
        startActivity(intent);
    }

    @Override
    public void onVehicleClick(int position) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    public void goToUserProfileActivity(View V){
        Intent intent = new Intent(this, UserProfileActivity.class);
        startActivity(intent);
    }
}