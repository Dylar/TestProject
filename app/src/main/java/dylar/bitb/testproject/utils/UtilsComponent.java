package dylar.bitb.testproject.utils;


import javax.inject.Singleton;

import dagger.Component;
import dylar.bitb.testproject.controller.GooController;

@Singleton
@Component(modules = {UtilsModule.class})
public interface UtilsComponent {

//    MathUtils provideMathUtils();
    UiUtils provideUiUtils();
    AnimationUtils provideAnimationUtils();

    void inject(GooController gooController);
}
