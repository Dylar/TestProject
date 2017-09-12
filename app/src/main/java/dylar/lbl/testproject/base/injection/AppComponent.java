package dylar.lbl.testproject.base.injection;

import javax.inject.Singleton;

import dagger.Component;
import dylar.lbl.testproject.MainActivity;


@Singleton
@Component(modules = {NetModule.class, ChannelListModule.class, ProgramModule.class})
public interface AppComponent {
    void inject(MainActivity mainActivity);
}
