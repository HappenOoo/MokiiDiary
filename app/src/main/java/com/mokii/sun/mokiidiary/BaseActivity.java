package com.mokii.sun.mokiidiary;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;

import com.mokii.sun.mokiidiary.ui.fragment.CalendarFragment;
import com.mokii.sun.mokiidiary.ui.fragment.MainFragment;
import com.mokii.sun.mokiidiary.ui.fragment.PrivateFragment;
import com.mokii.sun.mokiidiary.ui.fragment.TimelineFragment;

import me.yokeyword.fragmentation.SupportActivity;

public class BaseActivity extends SupportActivity implements
        CalendarFragment.OnFragmentInteractionListener,
        PrivateFragment.OnFragmentInteractionListener,
        TimelineFragment.OnFragmentInteractionListener {

    private final static String TAG = "BaseActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_base);

        Log.d(TAG,"onCreate start");
        if (findFragment(MainFragment.class) == null) {
            loadRootFragment(R.id.fl_container, MainFragment.newInstance());
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG,"onResume end");
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onBackPressedSupport() {
        // 对于 4个类别的主Fragment内的回退back逻辑,已经在其onBackPressedSupport里各自处理了
        super.onBackPressedSupport();
    }
}
