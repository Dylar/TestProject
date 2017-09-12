package dylar.bitb.testproject.base.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import dylar.bitb.testproject.base.app.App;
import dylar.bitb.testproject.base.injection.AppComponent;

public abstract class  BaseFragment extends Fragment{

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        injectDependency(((App)getActivity().getApplication()).getAppComponent());
        super.onCreate(savedInstanceState);
    }

    public abstract void injectDependency(AppComponent appComponent);
}
