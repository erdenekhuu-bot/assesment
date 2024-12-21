package com.dulguun.assesmen;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<DataList> data;
    private FragmentManager fragmentManager;

    public MyAdapter(List<DataList> propertyList, FragmentManager fragmentManager) {
        this.data = propertyList;
        this.fragmentManager = fragmentManager;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_list_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DataList currentItem = data.get(position);
        holder.addressTextView.setText(currentItem.getAddress());
        holder.suburbTextView.setText(currentItem.getSuburb());
        holder.stateTextView.setText(currentItem.getState());
        holder.postcodeTextView.setText(currentItem.getPostcode());
        holder.priceTextView.setText(currentItem.getPrice());

        // Click event for editing the property
        holder.itemView.setOnClickListener(v -> {
            NewProperty newPropertyFragment = new NewProperty();
            Bundle bundle = new Bundle();
            bundle.putString("address", currentItem.getAddress());
            bundle.putString("suburb", currentItem.getSuburb());
            bundle.putString("state", currentItem.getState());
            bundle.putString("postcode", currentItem.getPostcode());
            bundle.putString("price", currentItem.getPrice());
            newPropertyFragment.setArguments(bundle);

            // Replace current fragment with NewProperty for editing
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.replace(R.id.fragment_container, newPropertyFragment);
            transaction.addToBackStack(null);
            transaction.commit();
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView addressTextView, suburbTextView, stateTextView, postcodeTextView, priceTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            addressTextView = itemView.findViewById(R.id.address);
            suburbTextView = itemView.findViewById(R.id.suburb);
            postcodeTextView = itemView.findViewById(R.id.postcode);
            stateTextView = itemView.findViewById(R.id.state);
            priceTextView = itemView.findViewById(R.id.price);
        }
    }
}
