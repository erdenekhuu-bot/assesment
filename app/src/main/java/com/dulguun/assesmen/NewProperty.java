package com.dulguun.assesmen;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class NewProperty extends Fragment {

    private EditText addressEditText, suburbEditText, stateEditText, postcodeEditText, priceEditText;
    private Button btnAddProperty, btnSave;
    private DataList propertyToEdit;

    public NewProperty() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.newproperty, container, false);

        // Initialize views
        addressEditText = view.findViewById(R.id.edit_address);
        suburbEditText = view.findViewById(R.id.edit_suburb);
        stateEditText = view.findViewById(R.id.edit_state);
        postcodeEditText = view.findViewById(R.id.edit_postcode);
        priceEditText = view.findViewById(R.id.edit_price);
        btnAddProperty = view.findViewById(R.id.btn_add_property);
        btnSave = view.findViewById(R.id.btn_save);

        // Check if arguments were passed (for editing)
        if (getArguments() != null) {
            String address = getArguments().getString("address");
            String suburb = getArguments().getString("suburb");
            String state = getArguments().getString("state");
            String postcode = getArguments().getString("postcode");
            String price = getArguments().getString("price");

            addressEditText.setText(address);
            suburbEditText.setText(suburb);
            stateEditText.setText(state);
            postcodeEditText.setText(postcode);
            priceEditText.setText(price);

            // Create a DataList object for the property to edit
            propertyToEdit = new DataList(address, suburb, state, postcode, price);
        }

        // Add new property when "Add" button is clicked
        btnAddProperty.setOnClickListener(v -> {
            addressEditText.setText("");
            suburbEditText.setText("");
            stateEditText.setText("");
            postcodeEditText.setText("");
            priceEditText.setText("");
        });

        // Save or update property
        btnSave.setOnClickListener(v -> {
            String address = addressEditText.getText().toString();
            String suburb = suburbEditText.getText().toString();
            String state = stateEditText.getText().toString();
            String postcode = postcodeEditText.getText().toString();
            String price = priceEditText.getText().toString();

            DataList newProperty = new DataList(address, suburb, state, postcode, price);

            // If editing an existing property, update it in MainActivity
            if (propertyToEdit != null) {
                if (getActivity() instanceof MainActivity) {
                    MainActivity activity = (MainActivity) getActivity();
                    activity.updateProperty(newProperty);  // Update the property in the list
                }
            } else {
                // If adding a new property, call addNewProperty
                if (getActivity() instanceof MainActivity) {
                    MainActivity activity = (MainActivity) getActivity();
                    activity.addNewProperty(newProperty); // Add the new property to the list
                }
            }

            // Return to the previous fragment
            getFragmentManager().popBackStack();
        });

        return view;
    }
}
