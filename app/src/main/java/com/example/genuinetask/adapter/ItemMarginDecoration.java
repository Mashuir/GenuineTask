package com.example.genuinetask.adapter;

import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Objects;

public class ItemMarginDecoration extends RecyclerView.ItemDecoration {
    private final int mMargin;

    public ItemMarginDecoration(int margin) {
        mMargin = margin;
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, RecyclerView parent, @NonNull RecyclerView.State state) {
        // Apply margin to all sides of the item view except for the last item in the list
        int position = parent.getChildAdapterPosition(view);
        if (position != Objects.requireNonNull(parent.getAdapter()).getItemCount() - 1) {
            outRect.bottom = mMargin;
        }
    }
}

