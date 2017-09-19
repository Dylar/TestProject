package dylar.bitb.testproject.ui.home;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

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
    @BindView(R.id.mainactivity_navigation)
    BottomNavigationView navigation;
    private List<Integer> buttonHistory;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        navigation.setOnNavigationItemSelectedListener(this);
        buttonHistory = new ArrayList<>();
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
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (buttonHistory.isEmpty() || id != buttonHistory.get(buttonHistory.size() - 1)) {
            buttonHistory.add(id);
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
        if (!buttonHistory.isEmpty()) {
            buttonHistory.remove(buttonHistory.size() - 1);
            Menu menu = navigation.getMenu();
            int id = buttonHistory.isEmpty() ? R.id.navigation_home : buttonHistory.get(buttonHistory.size() - 1);
            for (int i = 0; i < menu.size(); i++) {
                MenuItem item = menu.getItem(i);
                if (item.getItemId() == id) {
                    item.setChecked(true);
                }
            }
        }
        super.onBackPressed();
    }
}
