package dylar.bitb.testproject.feature.dashboard.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import dylar.bitb.testproject.R;
import dylar.bitb.testproject.base.injection.AppComponent;
import dylar.bitb.testproject.base.view.BaseFragment;
import dylar.bitb.testproject.feature.dashboard.contract.IDashboardView;
import dylar.bitb.testproject.feature.dashboard.presenter.DashboardPresenter;
import easymvp.annotation.FragmentView;
import easymvp.annotation.Presenter;

@FragmentView(presenter = DashboardPresenter.class)
public class DashboardFragment extends BaseFragment implements IDashboardView {

    @Presenter
    DashboardPresenter dashboardPresenter;

    public static DashboardFragment createInstance() {
        DashboardFragment dashboardFragment = new DashboardFragment();
        return dashboardFragment;
    }

    public DashboardFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_dashboard, container, false);

        ButterKnife.bind(this, rootView);

//        setupRecyclerView();

        return rootView;
    }

    @Override
    public void injectDependency(AppComponent appComponent) {
//        appComponent.inject(this);
    }
}
