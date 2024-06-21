package com.toshakbhat.agribot;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class duniya extends AppCompatActivity {

    Spinner crop_type;
    Button ok;
    TextView harvest;
    TextView soil;
    TextView season;
    TextView crop_head;
    TextView temperature;
    TextView crop_types_name;
    String selectedCropType;
    HashMap<String,ArrayList<String>> crop_data = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_duniya);
        harvest = findViewById(R.id.harvest);
        soil = findViewById(R.id.soil);
        crop_head = findViewById(R.id.crop_head);
        season = findViewById(R.id.season);
        temperature = findViewById(R.id.temperature);
        crop_types_name = findViewById(R.id.crop_type);
        ok = findViewById(R.id.submit_crop);
        crop_type = findViewById(R.id.spinner);

        ArrayList<String> rice = new ArrayList<>();
        rice.add("November-December");
        rice.add("Clayey soil");
        rice.add("Summer");
        rice.add("21 to 37 C");
        rice.add("Kharif");

        crop_data.put("RICE",rice);

        ArrayList<String> wheat = new ArrayList<>();
        wheat.add("February-May");
        wheat.add("Clay loam");
        wheat.add("Winter");
        wheat.add("14 to 18 C");
        wheat.add("Rabi");

        crop_data.put("WHEAT",wheat);

        ArrayList<String> millets = new ArrayList<>();
        millets.add("December-January");
        millets.add("Sandy soil");
        millets.add("Monsoon");
        millets.add("8 to 10 C");
        millets.add("Kharif");

        crop_data.put("MILLETS",millets);

        ArrayList<String> pulses = new ArrayList<>();
        pulses.add("February-April");
        pulses.add("Black soil");
        pulses.add("All");
        pulses.add("25 to 30 C");
        pulses.add("Rabi");

        crop_data.put("PULSES",pulses);

        ArrayList<String> tea = new ArrayList<>();
        tea.add("March-December");
        tea.add("Laterite soil");
        tea.add("Spring");
        tea.add("16 to 32 C");
        tea.add("Kharif");

        crop_data.put("TEA",tea);

        ArrayList<String> coffee = new ArrayList<>();
        coffee.add("November-December");
        coffee.add("Laterite soil");
        coffee.add("Winter");
        coffee.add("15 to 28 C");
        coffee.add("Kharif");

        crop_data.put("COFFEE",coffee);

        ArrayList<String> sugarcane = new ArrayList<>();
        sugarcane.add("October-May");
        sugarcane.add("Loamy Soil");
        sugarcane.add("Autumn-Spring");
        sugarcane.add("21 to 27 C");
        sugarcane.add("Kharif");

        crop_data.put("SUGARCANE",sugarcane);

        ArrayList<String> jute = new ArrayList<>();
        jute.add("June-September");
        jute.add("Clay loams");
        jute.add("Rainy");
        jute.add("More than 25C");
        jute.add("Kharif");

        crop_data.put("JUTE",jute);

        ArrayList<String> maize = new ArrayList<>();
        maize.add("December");
        maize.add("Clay loam");
        maize.add("Monsoon");
        maize.add("18 to 27 C");
        maize.add("Kharif");

        crop_data.put("MAIZE",maize);

        ArrayList<String> cotton = new ArrayList<>();
        cotton.add("December-January");
        cotton.add("Laterite soil");
        cotton.add("Monsoon");
        cotton.add("21 to 30 C");
        cotton.add("Kharif");

        crop_data.put("COTTON",cotton);

        ArrayList<String> bajra = new ArrayList<>();
        bajra.add("October-November");
        bajra.add("Black soil");
        bajra.add("Rainy");
        bajra.add("20 to 30 C");
        bajra.add("Kharif");

        crop_data.put("BAJRA",bajra);






        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.crops,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        crop_type.setAdapter(adapter);

        crop_type.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // Handle the selected item (e.g., save it to a variable or perform an action)
                selectedCropType = parentView.getItemAtPosition(position).toString();
                //job_description.setText(selectedWorkType);
                // You can do something with the selected work type here
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Do nothing here
            }
        });

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crop_head.setText(selectedCropType);
                harvest.setText(Objects.requireNonNull(crop_data.get(selectedCropType)).get(0));
                soil.setText(Objects.requireNonNull(crop_data.get(selectedCropType)).get(1));
                season.setText(Objects.requireNonNull(crop_data.get(selectedCropType)).get(2));
                temperature.setText(Objects.requireNonNull(crop_data.get(selectedCropType)).get(3));
                crop_types_name.setText(Objects.requireNonNull(crop_data.get(selectedCropType)).get(4));
            }
        });




    }
}