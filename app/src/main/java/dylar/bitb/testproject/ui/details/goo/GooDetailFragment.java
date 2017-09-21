package dylar.bitb.testproject.ui.details.goo;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.BindView;
import dylar.bitb.testproject.R;
import dylar.bitb.testproject.base.AppComponent;
import dylar.bitb.testproject.base.IDependencyInjection;
import dylar.bitb.testproject.ui.base.BaseFragment;
import easymvp.annotation.FragmentView;
import easymvp.annotation.Presenter;

import static dylar.bitb.testproject.ui.details.goo.GooDetailActivity.GOO_ID;

@FragmentView(presenter = GooDetailPresenter.class)
public class GooDetailFragment extends BaseFragment implements IGooDetailView,IDependencyInjection {

    @Inject
    @Presenter
    public GooDetailPresenter presenter;

    @BindView(R.id.fragment_detail_goo_id)
    public TextView idTV;

    public static GooDetailFragment createNewInstance(String gooId) {
        Bundle args = new Bundle();
        args.putString(GOO_ID, gooId);
        GooDetailFragment gooDetailFragment = new GooDetailFragment();
        gooDetailFragment.setArguments(args);
        return gooDetailFragment;
    }

    @Override
    public void injectDependency(AppComponent appComponent) {
        appComponent.inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = super.onCreateView(inflater, container, savedInstanceState);

        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.onResume();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_details_goo;
    }

    @Override
    public void updateText(String text) {
        idTV.setText(text);
    }
}
