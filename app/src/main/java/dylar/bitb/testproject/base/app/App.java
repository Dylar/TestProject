package dylar.bitb.testproject.base.app;

import android.app.Application;

import dylar.bitb.testproject.base.injection.AppComponent;
import lombok.Getter;


public class App extends Application {
    @Getter
    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

//        appComponent =
//                DaggerAppComponent
//                        .builder()
//                        .netModule(new NetModule(ServiceUrl.ProgramUrl))
//                        .channelListModule(new ChannelListModule(() -> Schedulers.io(), () -> Schedulers.computation()))
//                        .programModule(new ProgramModule(() -> Schedulers.io(), () -> Schedulers.computation()))
//                        .build();
//
//        Fresco.initialize(this);
    }
}
