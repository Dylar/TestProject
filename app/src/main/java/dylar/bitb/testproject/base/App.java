package dylar.bitb.testproject.base;

import android.app.Application;

import lombok.Getter;


public class App extends Application {
    @Getter
    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent =
                DaggerAppComponent
                        .builder()
                        .appModule(new AppModule())
//                        .netModule(new NetModule())
//                        .channelListModule(new ChannelListModule(() -> Schedulers.io(), () -> Schedulers.computation()))
//                        .programModule(new ProgramModule(() -> Schedulers.io(), () -> Schedulers.computation()))
                        .build();
    }
}
