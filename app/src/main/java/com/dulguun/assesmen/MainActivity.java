package com.dulguun.assesmen;

import android.os.Bundle;
import androidx.fragment.app.FragmentTransaction;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MyAdapter adapter;
    private ArrayList<DataList> propertyList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        propertyList = new ArrayList<>();
        adapter = new MyAdapter(propertyList, getSupportFragmentManager());
        recyclerView.setAdapter(adapter);

        showPropertyListFragment();
    }

    // Add new property to the list and refresh RecyclerView
    public void addNewProperty(DataList newProperty) {
        propertyList.add(newProperty);
        adapter.notifyDataSetChanged();  // This will refresh the RecyclerView
    }

    // Update existing property in the list and refresh RecyclerView
    public void updateProperty(DataList updatedProperty) {
        for (int i = 0; i < propertyList.size(); i++) {
            if (propertyList.get(i).getAddress().equals(updatedProperty.getAddress())) {
                propertyList.set(i, updatedProperty);  // Update the property in the list
                break;
            }
        }
        adapter.notifyDataSetChanged();  // This will refresh the RecyclerView
    }

    // Show the property list fragment
    private void showPropertyListFragment() {
        NewProperty fragment = new NewProperty();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
