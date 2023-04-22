package com.example.genuinetask.adapter;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.genuinetask.R;
import com.example.genuinetask.model.ProductModel;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ViewHolder> {

    Context context;
    List<ProductModel> productModelList;
    RelativeLayout layout;
    TextView stockSizeTV;

    public ProductsAdapter(Context context, List<ProductModel> productModelList, RelativeLayout rootLayoutProductFragment, TextView stockSizeTV) {
        this.context = context;
        this.productModelList = productModelList;
        layout = rootLayoutProductFragment;
        this.stockSizeTV = stockSizeTV;
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

        holder.productName.setText(model.getName());
        Glide.with(context).load(model.getImagePath()).placeholder(R.drawable.broccoli).into(holder.productImage);

        String priceString = String.format(context.getString(R.string.book_price_tk), model.getOldPrice());
        holder.productPriceTV.setText(priceString);
        holder.productPriceTV.setPaintFlags(holder.productPriceTV.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

        String price = String.format(context.getString(R.string.book_price_tk), model.getPrice());
        holder.productOfferPriceTV.setText(price);


        holder.favouriteImageView.setOnClickListener(v -> {

            SharedPreferences sharedPreferences = context.getSharedPreferences("MyPrefs", MODE_PRIVATE);
            Set<String> IDs = sharedPreferences.getStringSet("Items", new HashSet<>());

            Set<String> updatedIDs = new HashSet<>(IDs);

            if (updatedIDs.contains(model.getCode())) {
                updatedIDs.remove(model.getCode());
                holder.favouriteImageView.setImageResource(R.drawable.ic_baseline_favorite_border_24);

            } else {
                updatedIDs.add(model.getCode());
                holder.favouriteImageView.setImageResource(R.drawable.ic_baseline_favorite_24);
                Snackbar.make(layout, "Add to Cart", BaseTransientBottomBar.LENGTH_SHORT).show();
            }

            if (updatedIDs.size() > 0) {
                stockSizeTV.setVisibility(View.VISIBLE);
                stockSizeTV.setText(String.valueOf(updatedIDs.size()));
            }else {
                stockSizeTV.setVisibility(View.GONE);
            }
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putStringSet("Items", updatedIDs);
            editor.apply();

        });

        SharedPreferences preferences = context.getSharedPreferences("MyPrefs", MODE_PRIVATE);
        Set<String> IDset = preferences.getStringSet("Items", new HashSet<>());

        if (IDset.contains(model.getCode())) {
            holder.favouriteImageView.setImageResource(R.drawable.ic_baseline_favorite_24);
        }
    }

    @Override
    public int getItemCount() {
        return productModelList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView productImage, favouriteImageView;
        TextView productName, productPriceTV, productOfferPriceTV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            productImage = itemView.findViewById(R.id.productImage);
            favouriteImageView = itemView.findViewById(R.id.favouriteImageView);
            productName = itemView.findViewById(R.id.productName);
            productPriceTV = itemView.findViewById(R.id.productPriceTV);
            productOfferPriceTV = itemView.findViewById(R.id.productOfferPriceTV);

        }
    }
}
