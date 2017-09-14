package dylar.bitb.testproject.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import dylar.bitb.testproject.base.App;
import dylar.bitb.testproject.base.IDependencyInjection;

public abstract class  BaseFragment extends Fragment{

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        if (this instanceof IDependencyInjection) {
            ((IDependencyInjection)this).injectDependency(((App)getActivity().getApplication()).getAppComponent());
        }
        super.onCreate(savedInstanceState);
    }
}
