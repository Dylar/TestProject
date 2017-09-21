package dylar.bitb.testproject.ui.home;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import dylar.bitb.testproject.R;
import dylar.bitb.testproject.ui.base.BaseFragment;

public class HomeFragment extends BaseFragment implements IHomeView {
    public static HomeFragment createInstance() {
        HomeFragment homeFragment = new HomeFragment();
        return homeFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = super.onCreateView(inflater, container, savedInstanceState);

        return rootView;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }
}
