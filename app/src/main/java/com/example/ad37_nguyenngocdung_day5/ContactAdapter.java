package com.example.ad37_nguyenngocdung_day5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder> {

    List<Contact> contacts;
    IonClickContact ionClickContact;

    public void setIonClickContact(IonClickContact ionClickContact) {
        this.ionClickContact = ionClickContact;
    }

    public ContactAdapter(List<Contact> contacts) {
        this.contacts = contacts;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_contact, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ContactAdapter.ViewHolder holder, int position) {
        final Contact contact = contacts.get(position);

        if(contact.getName().equals("")){
            holder.tvPhone.setText(contact.getPhone());
        } else if (!contact.getName().equals("")){
            holder.tvPhone.setText(contact.getName());
        }

        holder.tvPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ionClickContact.onClickPhone(contact.getPhone());
            }
        });

        holder.imgMoreInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ionClickContact.onClickInformation();
            }
        });

    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvPhone;
        ImageView imgMoreInfo;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvPhone = itemView.findViewById(R.id.tvPhone);
            imgMoreInfo = itemView.findViewById(R.id.imgMoreInfo);
        }
    }
}
