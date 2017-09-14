package dylar.bitb.testproject.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import dylar.bitb.testproject.base.App;
import dylar.bitb.testproject.base.IDependencyInjection;
import dylar.bitb.testproject.utils.AnimationUtils;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        if (this instanceof IDependencyInjection) {
            ((IDependencyInjection)this).injectDependency(((App) getApplication()).getAppComponent());
        }
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
    }

    protected abstract int getLayoutId();

    public abstract int getContentContainer();

    public void addOrReplaceFragment(BaseFragment fragment) {
        addOrReplaceFragment(fragment, getContentContainer());
    }

    public void addOrReplaceFragment(BaseFragment fragment, int targetContainerId) {
        String tag = fragment.getClass().getName();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        AnimationUtils.getInstance().setAnimations(fragmentTransaction);
        ViewGroup mainContainer = (ViewGroup) findViewById(targetContainerId);
        if (mainContainer.getChildCount() > 0) {
            fragmentTransaction.replace(targetContainerId, fragment, tag);
            fragmentTransaction.addToBackStack(tag);
        } else {
            fragmentTransaction.add(targetContainerId, fragment, tag);
        }
        fragmentTransaction.commitAllowingStateLoss();
    }

}
