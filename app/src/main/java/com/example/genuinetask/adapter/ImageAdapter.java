package com.example.genuinetask.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.genuinetask.R;
import com.example.genuinetask.model.ImageModel;

import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHolder> {

    private List<ImageModel> mImageList;

    public ImageAdapter(List<ImageModel> imageList) {
        mImageList = imageList;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.image_item_layout, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        ImageModel model = mImageList.get(position);

        holder.imageView.setImageResource(model.getImageResource());
        holder.category_title.setText(model.getCategoryName());
        holder.category_description.setText(model.getDescription());
    }

    @Override
    public int getItemCount() {
        return mImageList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView category_title, category_description;

        public ViewHolder(View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.image_view);
            category_title = itemView.findViewById(R.id.category_title);
            category_description = itemView.findViewById(R.id.category_description);
        }
    }
}

