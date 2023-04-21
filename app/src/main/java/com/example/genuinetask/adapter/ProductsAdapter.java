package com.example.genuinetask.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.genuinetask.R;
import com.example.genuinetask.model.ProductModel;

import java.util.List;

public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ViewHolder> {

    Context context;
    List<ProductModel> productModelList;

    public ProductsAdapter(Context context, List<ProductModel> productModelList) {
        this.context = context;
        this.productModelList = productModelList;
    }

    @NonNull
    @Override
    public ProductsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_product_item_layout, parent, false);
        return new ProductsAdapter.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductsAdapter.ViewHolder holder, int position) {

        ProductModel model = productModelList.get(position);

        holder.productName.setText(model.getProductList().get(position).getName());
    }

    @Override
    public int getItemCount() {
        return productModelList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView productImage, favouriteImageView;
        TextView productName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            productImage = itemView.findViewById(R.id.productImage);
            favouriteImageView = itemView.findViewById(R.id.favouriteImageView);
            productName = itemView.findViewById(R.id.productName);

        }
    }
}
