package com.example.fetchandroidinterntestapp.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fetchandroidinterntestapp.R;
import com.example.fetchandroidinterntestapp.models.Group;
import com.example.fetchandroidinterntestapp.models.Item;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

import java.util.List;

public class GroupAdapter extends RecyclerView.Adapter<GroupAdapter.GroupViewHolder> {

    private final List<Group> groupList;
    private final Context context;

    public GroupAdapter(Context context, List<Group> groupList) {
        this.context = context;
        this.groupList = groupList;
    }

    @NonNull
    @Override
    public GroupViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.group_item, parent, false);
        return new GroupViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final GroupViewHolder holder, @SuppressLint("RecyclerView") int position) {
        final Group group = groupList.get(holder.getAdapterPosition());
        holder.tvGroupHeader.setText("List " + group.getListId());

        if (group.isExpanded()) {
            holder.chipGroupItems.setVisibility(View.VISIBLE);
            holder.chipGroupItems.removeAllViews();
            for (Item item : group.getItems()) {
                if (item.getName() != null && !item.getName().trim().isEmpty()) {
                    LayoutInflater inflater = LayoutInflater.from(context);
                    if (item.getName() != null && !item.getName().trim().isEmpty()) {
                        Chip chip = (Chip) inflater.inflate(R.layout.chip_item, holder.chipGroupItems, false);
                        chip.setText(item.getName());
                        holder.chipGroupItems.addView(chip);
                    }
                }
            }
            holder.ivExpandIcon.setRotation(180f);
        } else {
            holder.chipGroupItems.setVisibility(View.GONE);
            holder.ivExpandIcon.setRotation(0f);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                group.setExpanded(!group.isExpanded());
                notifyItemChanged(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return groupList.size();
    }

    public static class GroupViewHolder extends RecyclerView.ViewHolder {
        TextView tvGroupHeader;
        ImageView ivExpandIcon;
        ChipGroup chipGroupItems;

        public GroupViewHolder(@NonNull View itemView) {
            super(itemView);
            tvGroupHeader = itemView.findViewById(R.id.tvGroupHeader);
            ivExpandIcon = itemView.findViewById(R.id.ivExpandIcon);
            chipGroupItems = itemView.findViewById(R.id.chipGroupItems);
        }
    }
}
