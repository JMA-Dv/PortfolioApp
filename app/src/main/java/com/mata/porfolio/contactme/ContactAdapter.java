package com.mata.porfolio.contactme;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mata.porfolio.R;

import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder> {

    List<ContactItem> data;

    public ContactAdapter(List<ContactItem> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contact,parent,false);
        return new ContactViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        holder.tvTitle.setText(data.get(position).getName());
        holder.tvDescription.setText(data.get(position).getDescription());
        holder.imgView.setImageResource(data.get(position).getImg());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ContactViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle;
        TextView tvDescription;
        ImageView imgView;

        public ContactViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.contact_item_title);
            tvDescription = itemView.findViewById(R.id.contact_item_description);
            imgView = itemView.findViewById(R.id.contact_item_img);
        }
    }
}
