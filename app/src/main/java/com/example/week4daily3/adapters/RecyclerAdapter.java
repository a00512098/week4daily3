package com.example.week4daily3.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.week4daily3.R;
import com.example.week4daily3.model.apiobjects.Repositories;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    private ArrayList<Repositories> repos;

    public RecyclerAdapter(ArrayList<Repositories> repos) {
        this.repos = repos;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_repo, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.repoUrl.setText(repos.get(i).getHtmlUrl());
        viewHolder.repoName.setText(repos.get(i).getName());

        String str = String.format(viewHolder.itemView.getResources()
                        .getString(R.string.accessibility_b), repos.get(i).getPrivate());
        viewHolder.repoAccessibility.setText(str);

        str = String.format(viewHolder.itemView.getResources()
                .getString(R.string.repo_id_d), repos.get(i).getId());
        viewHolder.repoId.setText(str);
    }

    @Override
    public int getItemCount() {
        return repos != null ? repos.size() : 0;
    }

    public void update() {
        notifyDataSetChanged();
    }

    public void updateList(ArrayList<Repositories> updatedList) {
        repos = updatedList;
        update();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView repoName, repoUrl, repoId, repoAccessibility;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            repoName = itemView.findViewById(R.id.repoName);
            repoUrl = itemView.findViewById(R.id.repoUrl);
            repoId = itemView.findViewById(R.id.repoId);
            repoAccessibility = itemView.findViewById(R.id.repoAccessibility);
        }
    }
}
