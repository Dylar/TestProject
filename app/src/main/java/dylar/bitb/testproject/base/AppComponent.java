package dylar.bitb.testproject.base;

import javax.inject.Singleton;

import dagger.Component;
import dylar.bitb.testproject.DummyClassModule;
import dylar.bitb.testproject.ui.home.MainActivity;


@Singleton
@Component(modules = {DummyClassModule.class})
public interface AppComponent {
    void inject(MainActivity mainActivity);
}
