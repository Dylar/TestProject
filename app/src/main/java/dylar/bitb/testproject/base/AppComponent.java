package dylar.bitb.testproject.base;

import javax.inject.Singleton;

import dagger.Component;
import dylar.bitb.testproject.ui.dashboard.DashboardFragment;
import dylar.bitb.testproject.ui.details.goo.GooDetailFragment;
import dylar.bitb.testproject.ui.home.MainActivity;
import dylar.bitb.testproject.ui.notifications.NotificationFragment;


@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    void inject(MainActivity mainActivity);
    void inject(NotificationFragment notificationFragment);
    void inject(DashboardFragment dashboardFragment);
    void inject(GooDetailFragment gooDetailFragment);
}
