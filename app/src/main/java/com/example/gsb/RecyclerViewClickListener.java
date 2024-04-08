package com.example.gsb;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public interface RecyclerViewClickListener {

    void onClick(View view, int position);

}
