package dylar.bitb.testproject;

import dagger.Module;
import dagger.Provides;
import dylar.bitb.testproject.model.DummyClass;

@Module
public class DummyClassModule {

    public DummyClassModule(){

    }

    @Provides
    public DummyClass getDummy(){
        return new DummyClass();
    }
}
