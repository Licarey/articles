package com.navigation;

import android.app.Application;
import android.content.Context;

import com.facebook.react.ReactApplication;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactPackage;
import com.facebook.react.shell.MainReactPackage;
import com.facebook.soloader.SoLoader;
import com.packages.MyIntentPackage;

import java.util.Arrays;
import java.util.List;

public class MainApplication extends Application implements ReactApplication {

    public MyIntentPackage myIntentPackage;

    private final ReactNativeHost mReactNativeHost = new ReactNativeHost(this) {
        @Override
        public boolean getUseDeveloperSupport() {
            return BuildConfig.DEBUG;
        }

        @Override
        protected List<ReactPackage> getPackages() {
            myIntentPackage = new MyIntentPackage();
            return Arrays.<ReactPackage>asList(
                    new MainReactPackage(), myIntentPackage
            );
        }

        @Override
        protected String getJSMainModuleName() {
            return "index";
        }
    };

    @Override
    public ReactNativeHost getReactNativeHost() {
        return mReactNativeHost;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        this.context = this;
        SoLoader.init(this, /* native exopackage */ false);
    }

    private static Application context;

    public static Context getContext() {
        return context;
    }

    public MyIntentPackage getMyIntentPackage(){
        return myIntentPackage;
    }
}
