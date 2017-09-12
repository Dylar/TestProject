package dylar.bitb.testproject;

import dagger.Module;
import dagger.Provides;
import dylar.bitb.testproject.model.DummyClass;

@Module
public class DummyClassModule {
    String data = "String";

    public DummyClassModule() {

    }

    public DummyClassModule(String data) {
        this.data = data;
    }

    @Provides
    public DummyClass getDummy() {
        return new DummyClass(data);
    }
}
