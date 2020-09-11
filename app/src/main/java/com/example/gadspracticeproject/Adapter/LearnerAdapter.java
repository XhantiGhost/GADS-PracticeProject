package com.example.gadspracticeproject.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gadspracticeproject.R;
import com.example.gadspracticeproject.models.LearnerHours;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class LearnerAdapter extends RecyclerView.Adapter<LearnerAdapter.LearnerHolder> {
    private List<LearnerHours> mLearnerHours = new ArrayList<>();

    @NonNull
    @Override
    public LearnerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LearnerHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.learners_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull LearnerHolder holder, int position) {
        LearnerHours learnerHours = mLearnerHours.get(position);
        holder.nameTextView.setText(learnerHours.getName());
        holder.hours.setText(learnerHours.getHours());
        holder.country.setText(learnerHours.getCountry());
        Picasso.get().load(learnerHours.getBadgeUrl()).into(holder.mImageView);
    }

    @Override
    public int getItemCount() {
        return mLearnerHours.size();
    }

    public void setLearnerHours(List<LearnerHours> learnerHours) {
        this.mLearnerHours = learnerHours;
        notifyDataSetChanged();
    }

    class LearnerHolder extends RecyclerView.ViewHolder {
        private TextView nameTextView;
        private TextView country;
        private TextView hours;
        private ImageView mImageView;

        public LearnerHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.tvLName);
            country = itemView.findViewById(R.id.tvLCountry);
            hours = itemView.findViewById(R.id.tvHours);
            mImageView = itemView.findViewById(R.id.learnerBadge);
        }
    }
}
