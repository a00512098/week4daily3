package com.example.week4daily3.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.week4daily3.R;
import com.example.week4daily3.adapters.RecyclerAdapter;
import com.example.week4daily3.model.apiobjects.Repositories;

import java.util.ArrayList;

public class RepositoriesFragment extends Fragment {
    private ArrayList<Repositories> repos;
    private RecyclerView recyclerView;
    private RecyclerAdapter recyclerAdapter;

    public RepositoriesFragment() {
        // Required empty public constructor
    }

    public static RepositoriesFragment newInstance() {
        RepositoriesFragment fragment = new RepositoriesFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_repositories, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        repos = new ArrayList<>();
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerAdapter = new RecyclerAdapter(repos);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(recyclerAdapter);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    public void setReposArayList(ArrayList<Repositories> repos) {
        this.repos = repos;
        recyclerAdapter.updateList(repos);
    }
}
