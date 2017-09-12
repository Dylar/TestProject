package dylar.bitb.testproject.base.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import dylar.bitb.testproject.base.app.App;
import dylar.bitb.testproject.base.injection.AppComponent;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        injectDependency(((App) getApplication()).getAppComponent());
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
    }

    protected abstract int getLayoutId();

    public abstract void injectDependency(AppComponent appComponent);

    public abstract int getContentContainer();

    public void addOrReplaceFragment(BaseFragment fragment) {
        addOrReplaceFragment(fragment, getContentContainer());
    }

    public void addOrReplaceFragment(BaseFragment fragment, int container) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction trans = manager.beginTransaction();
        if (manager.getBackStackEntryCount() > 0) {
            trans.replace(container, fragment);
        } else {
            trans.add(container, fragment);
        }
        trans.commit();
    }

}
