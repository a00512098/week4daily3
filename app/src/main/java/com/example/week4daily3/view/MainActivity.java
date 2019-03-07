package com.example.week4daily3.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.week4daily3.R;
import com.example.week4daily3.RetrofitHelper;
import com.example.week4daily3.adapters.SectionsPagerAdapter;
import com.example.week4daily3.model.GitHubApi;
import com.example.week4daily3.model.apiobjects.User;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity
        implements BottomNavigationView.OnNavigationItemSelectedListener,
        ViewPager.OnPageChangeListener {
    private GitHubApi gitHubService;
    private SectionsPagerAdapter mSectionsPagerAdapter;
    private UserInfoFragment fragment1;
    private RepositoriesFragment fragment2;
    private ViewPager mViewPager;
    private BottomNavigationView navigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        gitHubService = RetrofitHelper.getHelper().create(GitHubApi.class);
        Call<User> callUser = gitHubService.getUserInfo("a00512098");
        callUser.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                User user = response.body();
                fragment1.setUser(user);
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.e("Log.d", "CallbackError: " + t.toString());
            }
        });
    }

    private void initViews() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.container);

        // Add fragments to adapter
        fragment1 = UserInfoFragment.newInstance();
        fragment2 = RepositoriesFragment.newInstance();
        mSectionsPagerAdapter.addFragment(fragment1);
        mSectionsPagerAdapter.addFragment(fragment2);

        mViewPager.setAdapter(mSectionsPagerAdapter);
        mViewPager.addOnPageChangeListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.userProfile:
                mViewPager.setCurrentItem(0);
                return true;
            case R.id.userRepositories:
                mViewPager.setCurrentItem(1);
                return true;
        }
        return false;
    }

    @Override
    public void onPageScrolled(int i, float v, int i1) {

    }

    @Override
    public void onPageSelected(int i) {
        switch (i) {
            case 0:
                navigation.setSelectedItemId(R.id.userProfile);
                break;
            case 1:
                navigation.setSelectedItemId(R.id.userRepositories);
                break;
        }
    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }
}
