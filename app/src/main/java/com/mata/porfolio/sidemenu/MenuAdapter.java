package com.mata.porfolio.sidemenu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mata.porfolio.R;

import java.util.List;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuViewHolder> {

    List<MenuItem> options;

    Callback listener;


    public MenuAdapter(List<MenuItem> options, Callback  listener) {
        this.options = options;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_menu,parent,false);

        return new MenuViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuViewHolder holder, int position) {
        holder.icon.setImageResource(options.get(position).getIcon());
        if (options.get(position).isSelected())
            holder.isSelected.setVisibility(View.VISIBLE);
        else
            holder.isSelected.setVisibility(View.GONE);



    }

    @Override
    public int getItemCount() {
        return options.size();
    }

    public class MenuViewHolder extends RecyclerView.ViewHolder {
        ImageView icon;
        ImageView isSelected;

        public MenuViewHolder(@NonNull View itemView) {
            super(itemView);
            icon = itemView.findViewById(R.id.item_menu_icon);
            isSelected = itemView.findViewById(R.id.item_menu_selected);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onSideMenuClick(getAdapterPosition());
                }
            });
        }
    }
}
