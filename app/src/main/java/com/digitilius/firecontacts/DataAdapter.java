package com.digitilius.firecontacts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Objects;

public class DataAdapter extends RecyclerView.Adapter<ViewHolder> {
    ArrayList<ContactRecord> contacts;

    LayoutInflater inflater;

    public DataAdapter(Context context, ArrayList<ContactRecord> contacts) {
        this.contacts = contacts;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.contact_item, parent);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        ContactRecord currentRec = contacts.get(position);
        Objects.requireNonNull(holder).phone.setText(currentRec.getPhone().toString());
        Objects.requireNonNull(holder).name.setText(currentRec.getContName().toString());
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }
}
