package dylar.bitb.testproject;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.BindView;
import dylar.bitb.testproject.base.injection.AppComponent;
import dylar.bitb.testproject.base.view.BaseActivity;
import dylar.bitb.testproject.feature.dashboard.view.DashboardFragment;
import dylar.bitb.testproject.feature.home.IMainView;
import dylar.bitb.testproject.feature.home.MainPresenter;
import easymvp.annotation.ActivityView;
import easymvp.annotation.Presenter;

@ActivityView(presenter = MainPresenter.class)
public class MainActivity extends BaseActivity implements BottomNavigationView.OnNavigationItemSelectedListener, IMainView {

    @Inject
    @Presenter
    MainPresenter presenter;

    @BindView(R.id.mainactivity_title)
    protected TextView mTextMessage;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.mainactivity_navigation);
        navigation.setOnNavigationItemSelectedListener(this);

    }

    @Override
    protected void onStart() {
        super.onStart();

        mTextMessage.setText(presenter.getTitle());
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
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.navigation_home:
                mTextMessage.setText(R.string.title_home);
                return true;
            case R.id.navigation_dashboard:
                addOrReplaceFragment(DashboardFragment.createInstance());
                return true;
            case R.id.navigation_notifications:
                mTextMessage.setText(R.string.title_notifications);
                return true;
        }
        return false;
    }
}
