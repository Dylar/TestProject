package dylar.bitb.testproject.ui.home;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;

import javax.inject.Inject;

import butterknife.BindView;
import dylar.bitb.testproject.R;
import dylar.bitb.testproject.base.AppComponent;
import dylar.bitb.testproject.base.IDependencyInjection;
import dylar.bitb.testproject.ui.base.BaseActivity;
import dylar.bitb.testproject.ui.dashboard.DashboardFragment;
import dylar.bitb.testproject.ui.notifications.NotificationFragment;
import easymvp.annotation.ActivityView;
import easymvp.annotation.Presenter;

@ActivityView(presenter = MainPresenter.class)
public class MainActivity extends BaseActivity implements BottomNavigationView.OnNavigationItemSelectedListener, IMainView, IDependencyInjection {

    @Inject
    @Presenter
    MainPresenter presenter;
    private int currentFocus;

    @BindView(R.id.mainactivity_navigation)
    BottomNavigationView navigation;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        navigation.setOnNavigationItemSelectedListener(this);
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
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id != currentFocus) {
            currentFocus = id;
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
        }
        return false;
    }

    @Override
    public void onBackPressed() {
        MenuItem homeItem = navigation.getMenu().getItem(0);

        if (currentFocus != homeItem.getItemId()) {
            // Select home item
            navigation.setSelectedItemId(homeItem.getItemId());
        } else {
            super.onBackPressed();
        }
    }
}
