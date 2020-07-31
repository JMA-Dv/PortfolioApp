package com.mata.porfolio.portfolio;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mata.porfolio.R;

import java.util.List;

public class PortfolioAdapter extends RecyclerView.Adapter<PortfolioAdapter.PortfolioViewHoder> {
    private List<PortfolioItem> data;
    private PortfolioCallback listener;

    public PortfolioAdapter(List<PortfolioItem> data, PortfolioCallback listener) {
        this.data = data;
        this.listener = listener;
    }

    @NonNull
    @Override
    public PortfolioViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_portolio,parent,false);
        return new PortfolioViewHoder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PortfolioViewHoder holder, int position) {
        holder.imagePort.setImageResource(data.get(position).getImage());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class PortfolioViewHoder extends RecyclerView.ViewHolder {
        ImageView imagePort;


        public PortfolioViewHoder(@NonNull View itemView) {
            super(itemView);
            imagePort = itemView.findViewById(R.id.item_port_img);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onPortfolioItemView(getAdapterPosition());
                }
            });
        }
    }
}
