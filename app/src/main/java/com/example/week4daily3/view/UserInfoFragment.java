package com.example.week4daily3.view;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.week4daily3.R;
import com.example.week4daily3.model.apiobjects.User;

public class UserInfoFragment extends Fragment {
    User user;
    ImageView userAvatar;
    TextView username, bio, userUrl, location;

    public UserInfoFragment() {
        // Required empty public constructor
    }

    public static UserInfoFragment newInstance() {
        UserInfoFragment fragment = new UserInfoFragment();
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
        return inflater.inflate(R.layout.fragment_user_info, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        userAvatar = view.findViewById(R.id.userAvatar);
        username = view.findViewById(R.id.userName);
        bio = view.findViewById(R.id.userBio);
        userUrl = view.findViewById(R.id.userUrl);
        location = view.findViewById(R.id.userLocation);
    }

    public void setUser(User user) {
        this.user = user;
        populateViews();
    }

    private void populateViews() {
        if (user != null) {
            username.setText(user.getName());
            bio.setText(String.format(getResources().getString(R.string.bio_s), user.getBio()));
            userUrl.setText(String.format(getResources().getString(R.string.user_url_s), user.getReposUrl()));
            location.setText(String.format(getResources().getString(R.string.location_s), user.getLocation()));

            Glide.with(getContext())
                    .load(user.getAvatarUrl())
                    .centerCrop()
                    .placeholder(R.drawable.placeholder)
                    .into(userAvatar);
        }
    }
}
