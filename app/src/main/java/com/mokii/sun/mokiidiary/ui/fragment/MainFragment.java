package com.mokii.sun.mokiidiary.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mokii.sun.mokiidiary.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.yokeyword.fragmentation.SupportFragment;

public class MainFragment extends SupportFragment {

    @BindView(R.id.navigation)
    BottomNavigationView navigation;

    public static final int FIRST = 0;
    public static final int SECOND = 1;
    public static final int THIRD = 2;

    private SupportFragment[] mFragments = new SupportFragment[3];

    public static MainFragment newInstance() {

        Bundle args = new Bundle();

        MainFragment fragment = new MainFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    showHideFragment(mFragments[FIRST]);
                    return true;
                case R.id.navigation_dashboard:
                    showHideFragment(mFragments[SECOND]);
                    return true;
                case R.id.navigation_notifications:
                    showHideFragment(mFragments[THIRD]);
                    return true;
            }
            return false;
        }
    };

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this,view);
        initView(view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        SupportFragment firstFragment = findChildFragment(CalendarFragment.class);
        if (firstFragment == null) {
            mFragments[FIRST] = CalendarFragment.newInstance();
            mFragments[SECOND] = TimelineFragment.newInstance();
            mFragments[THIRD] = PrivateFragment.newInstance();

            loadMultipleRootFragment(R.id.tab_container, FIRST,
                    mFragments[FIRST],
                    mFragments[SECOND],
                    mFragments[THIRD]);
        } else {
            // 这里库已经做了Fragment恢复,所有不需要额外的处理了, 不会出现重叠问题
            // 这里我们需要拿到mFragments的引用
            mFragments[FIRST] = firstFragment;
            mFragments[SECOND] = findChildFragment(TimelineFragment.class);
            mFragments[THIRD] = findChildFragment(PrivateFragment.class);
        }
    }

    private void initView(View view) {
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
