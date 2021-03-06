package com.weather.byhieg.easyweather.base;


import android.content.Context;
import android.graphics.PixelFormat;
import android.graphics.drawable.LevelListDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;

import com.squareup.leakcanary.RefWatcher;
import com.weather.byhieg.easyweather.MyApplication;

import org.greenrobot.eventbus.EventBus;

/**
 * A simple {@link Fragment} subclass.
 */
public class BaseFragment extends Fragment {

    private WindowManager mWindowManager = null;
    private View mNightView = null;
    private WindowManager.LayoutParams mNightViewParam;



    public BaseFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        TextView textView = new TextView(getActivity());
        textView.setText("你好");
        return textView;
    }

    protected void initNightView(int layoutID)
    {
        mNightViewParam = new WindowManager.LayoutParams(
                WindowManager.LayoutParams.TYPE_APPLICATION,
                WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                PixelFormat.TRANSPARENT);

        mWindowManager = (WindowManager) getActivity().getSystemService(Context.WINDOW_SERVICE);
        mNightView=LayoutInflater.from(getActivity()).inflate(layoutID,null);
        mWindowManager.addView(mNightView, mNightViewParam);
    }

    protected void removeNightView(){
        if(mNightView!=null) {
            mWindowManager.removeViewImmediate(mNightView);
            mNightView = null;
        }
    }
}
