package dylar.bitb.testproject.ui.notifications;

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
import dylar.bitb.testproject.model.Reddit;
import dylar.bitb.testproject.ui.base.BaseFragment;
import easymvp.annotation.FragmentView;
import easymvp.annotation.Presenter;

@FragmentView(presenter = NotificationPresenter.class)
public class NotificationFragment extends BaseFragment implements INotificationView, IDependencyInjection {

    @Inject
    @Presenter
    NotificationPresenter notificationPresenter;

    @BindView(R.id.reddit)
    TextView text;

    public static NotificationFragment createInstance() {
        NotificationFragment notificationFragment = new NotificationFragment();
        return notificationFragment;
    }

    @Override
    public void injectDependency(AppComponent appComponent) {
        appComponent.inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = super.onCreateView(inflater,container,savedInstanceState);

//        setupRecyclerView();

        notificationPresenter.onCreate();

        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        notificationPresenter.onResume();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_dashboard;
    }

    @Override
    public void showPost(Reddit posts) {
        text.setText(posts.getJson());
    }

//    private void setupRecyclerView() {
//        GooAndPrickleAdapter adapter = new GooAndPrickleAdapter(this);
//        recyclerView.setAdapter(adapter);
//        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
//        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
//    }
//
//    @Override
//    public int getListCount() {
//        return notificationPresenter.getGooAndPrickleCount();
//    }
//
//    @Override
//    public void setRowGoo(IGooRowView holder, int position) {
//        notificationPresenter.setGoo(holder, position);
//    }
//
//    @Override
//    public void setRowPrickle(IPrickleRowView holder, int position) {
//        notificationPresenter.setPrickle(holder, position);
//    }
//
//    @Override
//    public void openGooDetails(String id) {
//
//    }
}
