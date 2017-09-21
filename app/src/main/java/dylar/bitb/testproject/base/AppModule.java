package dylar.bitb.testproject.base;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dylar.bitb.testproject.controller.GooController;

@Module
public class AppModule {

    @Singleton
    @Provides
    public GooController providesGooController(){
        return new GooController();
    }
}
