package dylar.bitb.testproject.utils;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class UtilsModule {

    @Singleton
    @Provides
    public MathUtils provideMathUtils(){
        return new MathUtils();
    }

}
