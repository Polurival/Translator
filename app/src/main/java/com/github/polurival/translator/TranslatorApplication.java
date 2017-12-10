package com.github.polurival.translator;

import android.app.Application;

import com.github.polurival.translator.data.network.ApiClient;
import com.github.polurival.translator.di.ApplicationComponent;
import com.github.polurival.translator.di.DaggerApplicationComponent;
import com.github.polurival.translator.di.modules.ApplicationModule;
import com.github.polurival.translator.di.modules.DataModule;

/**
 * @author Polurival on 16.11.2017.
 */

public class TranslatorApplication extends Application {

    private static ApplicationComponent applicationComponent;

    public static ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        applicationComponent = buildComponent();
    }

    public ApplicationComponent buildComponent() {
        return DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .dataModule(new DataModule(new ApiClient()))
                .build();
    }
}
