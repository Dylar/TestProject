package dylar.bitb.testproject.base.injection;

import javax.inject.Singleton;

import dagger.Component;
import dylar.bitb.testproject.DummyClassModule;
import dylar.bitb.testproject.MainActivity;


@Singleton
@Component(modules = {DummyClassModule.class})
public interface AppComponent {
    void inject(MainActivity mainActivity);
}
