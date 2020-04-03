package com.example.serviceforcebd.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.serviceforcebd.activity.LocationActivity;
import com.example.serviceforcebd.databinding.RvServiceItemBinding;

public class ServiceAdapter extends RecyclerView.Adapter<ServiceAdapter.ViewHolder> {

    private Context context;
    private String[] serviceList;

    public ServiceAdapter(Context context, String[] serviceList) {
        this.context = context;
        this.serviceList = serviceList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RvServiceItemBinding binding = RvServiceItemBinding.inflate(LayoutInflater.from(context), parent,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.binding.itemTV.setText(serviceList[position]);

        holder.itemView.setOnClickListener(view -> {
            Intent intent = new Intent(context, LocationActivity.class);
            intent.putExtra("category",serviceList[position]);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return serviceList.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private RvServiceItemBinding binding;
        public ViewHolder(@NonNull RvServiceItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
