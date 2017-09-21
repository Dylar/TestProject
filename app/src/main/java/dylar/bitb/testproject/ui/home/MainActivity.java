package dylar.bitb.testproject.ui.home;

import android.os.Bundle;

import javax.inject.Inject;

import dylar.bitb.testproject.R;
import dylar.bitb.testproject.base.AppComponent;
import dylar.bitb.testproject.base.IDependencyInjection;
import dylar.bitb.testproject.ui.base.NavigationActivity;
import dylar.bitb.testproject.ui.dashboard.DashboardFragment;
import dylar.bitb.testproject.ui.notifications.NotificationFragment;
import easymvp.annotation.ActivityView;
import easymvp.annotation.Presenter;

@ActivityView(presenter = MainPresenter.class)
public class MainActivity extends NavigationActivity implements IMainView, IDependencyInjection {

    @Inject
    @Presenter
    MainPresenter presenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addOrReplaceFragment(HomeFragment.createInstance());
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void injectDependency(AppComponent appComponent) {
        appComponent.inject(this);
    }

    @Override
    public int getContentContainer() {
        return R.id.mainactivity_container;
    }

    @Override
    public int getNavigationLayout() {
        return R.menu.navigation;
    }

    @Override
    public int getFirstTabId() {
        return R.id.navigation_home;
    }

    @Override
    protected boolean navigateTo(int id) {
        switch (id) {
            case R.id.navigation_home:
                addOrReplaceFragment(HomeFragment.createInstance());
                return true;
            case R.id.navigation_dashboard:
                addOrReplaceFragment(DashboardFragment.createInstance());
                return true;
            case R.id.navigation_notifications:
                addOrReplaceFragment(NotificationFragment.createInstance());
                return true;
        }
        return false;
    }


}
