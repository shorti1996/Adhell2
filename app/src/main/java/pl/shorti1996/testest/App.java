package pl.shorti1996.testest;


import android.app.Application;

import pl.shorti1996.testest.dagger.component.AppComponent;
import pl.shorti1996.testest.dagger.component.DaggerAppComponent;
import pl.shorti1996.testest.dagger.module.AppModule;

public class App extends Application {
    private static App instance;
    private AppComponent appComponent;

    public static App get() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        appComponent = initDagger(instance);
    }

    protected AppComponent initDagger(App application) {
        return DaggerAppComponent.builder()
                .appModule(new AppModule(application))
                .build();
    }


    public AppComponent getAppComponent() {
        return appComponent;
    }
}
