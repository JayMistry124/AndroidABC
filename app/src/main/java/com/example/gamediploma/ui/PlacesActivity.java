package com.example.gamediploma.ui;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gamediploma.R;
import com.example.gamediploma.adapter.RVAdaper;

import java.util.ArrayList;
import java.util.Objects;

public class PlacesActivity extends AppCompatActivity {
    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places);

        Objects.requireNonNull(getSupportActionBar()).setTitle("Places");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        getSupportActionBar().setTitle("Places");

        rv = findViewById(R.id.RecyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rv.setLayoutManager(linearLayoutManager);

        ArrayList<String> state = new ArrayList<>();
        state.add("Andhra Pradesh");
        state.add("Arunachal Pradesh");
        state.add("Assam");
        state.add("Bihar");
        state.add("Chhattisgarh");
        state.add("Goa");
        state.add("Gujarat");
        state.add("Haryana");
        state.add("Himachal Pradesh");
        state.add("Jharkhand");
        state.add("Karnataka");
        state.add("Kerala");
        state.add("Madhya Pradesh");
        state.add("Maharashtra");
        state.add("Manipur");
        state.add("Meghalaya");
        state.add("Mizoram");
        state.add("Nagaland");
        state.add("Odisha");
        state.add("Punjab");
        state.add("Rajasthan");
        state.add("Sikkim");
        state.add("Tamil Nadu");
        state.add("Telangana");
        state.add("Tripura");
        state.add("Uttar Pradesh");
        state.add("Uttarakhand");
        state.add("West Bengal");

        ArrayList<String> capital = new ArrayList<>();
        capital.add("Amaravati");
        capital.add("Itanagar");
        capital.add("Dispur");
        capital.add("Patna");
        capital.add("Raipur");
        capital.add("Panaji");
        capital.add("Gandhinagar");
        capital.add("Chandigarh");
        capital.add("Shimla");
        capital.add("Ranchi");
        capital.add("Bengaluru");
        capital.add("Thiruvananthapuram");
        capital.add("Bhopal");
        capital.add("Mumbai");
        capital.add("Imphal");
        capital.add("Shillong");
        capital.add("Aizawl");
        capital.add("Kohima");
        capital.add("Bhubaneswar");
        capital.add("Chandigarh");
        capital.add("Jaipur");
        capital.add("Gangtok");
        capital.add("Chennai");
        capital.add("Hyderabad");
        capital.add("Agartala");
        capital.add("Lucknow");
        capital.add("Dehradun");
        capital.add("Kolkata");

        ArrayList<Integer> image = new ArrayList();
        image.add(R.drawable.andhra_pradesh);
        image.add(R.drawable.arunachal_pradesh);
        image.add(R.drawable.assam);
        image.add(R.drawable.bihar);
        image.add(R.drawable.chhattisgarh);
        image.add(R.drawable.goa);
        image.add(R.drawable.gujarat);
        image.add(R.drawable.haryana);
        image.add(R.drawable.himachal_pradesh);
        image.add(R.drawable.jharkhand);
        image.add(R.drawable.karnataka);
        image.add(R.drawable.kerala);
        image.add(R.drawable.madhya_pradesh);
        image.add(R.drawable.maharashtra);
        image.add(R.drawable.manipur);
        image.add(R.drawable.meghalaya);
        image.add(R.drawable.mizoram);
        image.add(R.drawable.nagaland);
        image.add(R.drawable.odisha);
        image.add(R.drawable.punjab);
        image.add(R.drawable.rajasthan);
        image.add(R.drawable.sikkim);
        image.add(R.drawable.tamil_nadu);
        image.add(R.drawable.telangana);
        image.add(R.drawable.tripura);
        image.add(R.drawable.uttar_pradesh);
        image.add(R.drawable.uttarakhand);
        image.add(R.drawable.west_bengal);


        RVAdaper rvAdaper = new RVAdaper(PlacesActivity.this, state, capital, image);
        rv.setAdapter(rvAdaper);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}