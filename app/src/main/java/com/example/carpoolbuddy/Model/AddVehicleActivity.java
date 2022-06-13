package com.example.carpoolbuddy.Model;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.example.carpoolbuddy.R;
import com.example.carpoolbuddy.Utils.Constants;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class AddVehicleActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private FirebaseFirestore firestore;
    private LinearLayout layout;
    private EditText ownerField;
    private EditText modelField;
    private EditText capacityField;
    private EditText basePriceField;
    private EditText rangeField;
    private EditText maxAltitudeField;
    private EditText maxAirspeedField;
    private EditText bicycleTypeField;
    private EditText weightField;
    private EditText weightCapacityField;
    private Spinner vehicleTypeSpinner;
    private String typeSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_vehicle);
        mAuth = FirebaseAuth.getInstance();
        firestore = FirebaseFirestore.getInstance();
        layout = findViewById(R.id.createVehicleLayout);
        vehicleTypeSpinner = findViewById(R.id.vehicleSpinner);
        setupSpinner();
    }

    private void setupSpinner() {
        String[] vehicleTypes = {Constants.CAR, Constants.HELICOPTER, Constants.BICYCLE, Constants.SEGWAY};
        // add user types to spinner
        ArrayAdapter<String> langArrAdapter = new ArrayAdapter<String>(AddVehicleActivity.this,
                android.R.layout.simple_spinner_item, vehicleTypes);
        langArrAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        vehicleTypeSpinner.setAdapter(langArrAdapter);

        //triggered whenever user selects something different
        vehicleTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                typeSelected = parent.getItemAtPosition(position).toString();
                addFields();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    public void addFields() {
        commonFields();
        if(typeSelected.equals(Constants.CAR)) {
            rangeField = new EditText(this);
            rangeField.setHint(Constants.RANGE_HINT);
            layout.addView(rangeField);
        }

        if(typeSelected.equals(Constants.HELICOPTER)){
            maxAltitudeField = new EditText(this);
            maxAltitudeField.setHint(Constants.MAX_ALTITUDE_HINT);
            layout.addView(maxAltitudeField);
            maxAirspeedField = new EditText(this);
            maxAirspeedField.setHint(Constants.MAX_AIRSPEED_HINT);
            layout.addView(maxAirspeedField);
        }

        if(typeSelected.equals(Constants.BICYCLE)){
            bicycleTypeField = new EditText(this);
            bicycleTypeField.setHint(Constants.BICYCLE_TYPE_HINT);
            layout.addView(bicycleTypeField);
            weightField = new EditText(this);
            weightField.setHint(Constants.WEIGHT_HINT);
            layout.addView(weightField);
            weightCapacityField = new EditText(this);
            weightCapacityField.setHint(Constants.WEIGHT_CAPACITY_HINT);
            layout.addView(weightCapacityField);
        }

        if(typeSelected.equals(Constants.SEGWAY)){
            rangeField = new EditText(this);
            rangeField.setHint(Constants.RANGE_HINT);
            layout.addView(rangeField);
            weightCapacityField =  new EditText(this);
            weightCapacityField.setHint(Constants.WEIGHT_CAPACITY_HINT);
            layout.addView(weightCapacityField);
        }
    }

    public void commonFields() {
        layout.removeAllViewsInLayout();
        ownerField = new EditText(this);
        ownerField.setHint(Constants.OWNER_HINT);
        layout.addView(ownerField);
        modelField = new EditText(this);
        modelField.setHint(Constants.MODEL_HINT);
        layout.addView(modelField);
        capacityField = new EditText(this);
        capacityField.setHint(Constants.CAPACITY_HINT);
        layout.addView(capacityField);
        basePriceField = new EditText(this);
        basePriceField.setHint(Constants.BASE_PRICE_HINT);
        layout.addView(basePriceField);
    }

    public void createVehicle(View v) {
        DocumentReference newRideRef = firestore.collection(Constants.VEHICLE_COLLECTION).document();
        String vehicleId = newRideRef.getId();

        Vehicle newVehicle = null;

        String ownerString = ownerField.getText().toString();
        String modelString = modelField.getText().toString();
        int capacityInt = Integer.parseInt(capacityField.getText().toString());
        double basePriceDouble = Double.parseDouble(basePriceField.getText().toString());

        //check which type of vehicle was created
        if(typeSelected.equals(Constants.CAR)) {
            int rangeInt = Integer.parseInt(rangeField.getText().toString());
            newVehicle = new Car(ownerString, modelString, capacityInt, capacityInt, vehicleId, basePriceDouble, rangeInt);

            //add the new vehicle to the database
            newRideRef.set(newVehicle);
        }else if(typeSelected.equals(Constants.HELICOPTER)) {
            int maxAltitudeInt = Integer.parseInt(maxAltitudeField.getText().toString());
            int maxAirspeedInt = Integer.parseInt(maxAirspeedField.getText().toString());
            newVehicle = new Helicopter(ownerString, modelString, capacityInt, capacityInt, vehicleId, basePriceDouble, maxAltitudeInt, maxAirspeedInt);

            newRideRef.set(newVehicle);
        }else if(typeSelected.equals(Constants.BICYCLE)){
            int weightCapacityInt = Integer.parseInt(weightCapacityField.getText().toString());
            String bicycleTypeString = bicycleTypeField.getText().toString();
            int weightInt = Integer.parseInt(weightField.getText().toString());
            newVehicle = new Bicycle(ownerString, modelString, capacityInt, capacityInt, vehicleId, basePriceDouble, bicycleTypeString, weightInt, weightCapacityInt);

            newRideRef.set(newVehicle);
        }else if(typeSelected.equals(Constants.SEGWAY)){
            int rangeInt = Integer.parseInt(rangeField.getText().toString());
            int weightCapacityInt = Integer.parseInt(weightCapacityField.getText().toString());
            newVehicle = new Segway(ownerString, modelString, capacityInt, capacityInt, vehicleId, basePriceDouble, rangeInt, weightCapacityInt);

            newRideRef.set(newVehicle);
        }

        Intent intent = new Intent(this, VehiclesInfoActivity.class);
        startActivity(intent);
    }
}