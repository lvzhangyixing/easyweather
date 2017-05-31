package com.weather.byhieg.easyweather.startweather;

import android.content.Intent;
import android.os.Handler;

import com.weather.byhieg.easyweather.base.BaseActivity;
import com.weather.byhieg.easyweather.home.MainActivity;
import com.weather.byhieg.easyweather.R;

import butterknife.ButterKnife;

public class StartActivity extends BaseActivity implements StartWeatherContract.View {

    private static final String ACTION_ADD_CITY = "com.weather.byhieg.easyweather.startweather" +
            ".Activity.action.addCity";

    private static final String ACTION_GET_WEATHER = "com.weather.byhieg.easyweather.startweather" +
            ".Activity.action.getWeather";

    private static final String ACTION_START_NOTIFICATION = "com.weather.byhieg.easyweather" +
            ".startweather.Activity.action.notification";

    private static final String ACTION_ADD_VIEWSPOT = "com.weather.byhieg.easyweather" +
            ".startweather.Activity.action.viewspot";

    private static final String ACTION_FILE_PROCESS = "com.weather.byhieg.easyweather.startweather" +
            ".Activity.action.fileprocess";

    private StartWeatherContract.Presenter mPresenter;

    @Override
    public void initData() {
        ButterKnife.bind(this);
        mPresenter = new StartWeatherPresenter(this);
        mPresenter.start();
    }

    @Override
    public void initEvent() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(MainActivity.class);
                finish();
            }
        }, 3500);
    }

    @Override
    public void initView() {

    }

    @Override
    public void initTheme() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_start;
    }


    @Override
    public void setPresenter(StartWeatherContract.Presenter presenter) {

    }

    @Override
    public void startService() {
        startAddCityService();
        startGetWeatherService();
        startNotificationService();
        startFileProcessService();
    }

    private void startAddCityService() {
        Intent intent = new Intent(this, BackGroundService.class);
        intent.setAction(ACTION_ADD_CITY);
        startService(intent);
    }

    private void startGetWeatherService() {
        Intent intent = new Intent(this, BackGroundService.class);
        intent.setAction(ACTION_GET_WEATHER);
        startService(intent);
    }

    private void startNotificationService() {
        Intent intent = new Intent(this, BackGroundService.class);
        intent.setAction(ACTION_START_NOTIFICATION);
        startService(intent);
    }


    private void startFileProcessService() {
        Intent intent = new Intent(this, BackGroundService.class);
        intent.setAction(ACTION_FILE_PROCESS);
        startService(intent);
    }

    public static String getActionAddCity() {
        return ACTION_ADD_CITY;
    }

    public static String getActionStartNotification() {
        return ACTION_START_NOTIFICATION;
    }

    public static String getActionGetWeather() {
        return ACTION_GET_WEATHER;
    }

    public static String getActionAddViewspot() {
        return ACTION_ADD_VIEWSPOT;
    }


    public static String getActionFileProcess() {
        return ACTION_FILE_PROCESS;
    }


}
