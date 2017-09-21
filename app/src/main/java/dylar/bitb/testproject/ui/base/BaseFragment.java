package dylar.bitb.testproject.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import dylar.bitb.testproject.base.App;
import dylar.bitb.testproject.base.IDependencyInjection;

public abstract class BaseFragment extends Fragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        if (this instanceof IDependencyInjection) {
            ((IDependencyInjection) this).injectDependency(((App) getActivity().getApplication()).getAppComponent());
        }

        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(getLayoutId(), container, false);

        ButterKnife.bind(this, rootView);

        return rootView;
    }

    protected abstract int getLayoutId();
}
