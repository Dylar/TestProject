package dylar.bitb.testproject.ui.home;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import dylar.bitb.testproject.R;
import dylar.bitb.testproject.ui.base.BaseFragment;

public class HomeFragment extends BaseFragment implements IHomeView {
    public static HomeFragment createInstance() {
        HomeFragment homeFragment = new HomeFragment();
        return homeFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        ButterKnife.bind(this, rootView);

        return rootView;
    }
}
