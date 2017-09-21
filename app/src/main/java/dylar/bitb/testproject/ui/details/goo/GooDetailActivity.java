package dylar.bitb.testproject.ui.details.goo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import dylar.bitb.testproject.R;
import dylar.bitb.testproject.ui.base.NavigationActivity;

public class GooDetailActivity extends NavigationActivity{

    public static final String GOO_ID = "goo_id";

    public static void startActivity(Context context, String id){
        Intent intent = new Intent(context, GooDetailActivity.class);
        intent.putExtra(GOO_ID, id);
        context.startActivity(intent);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public int getContentContainer() {
        return R.id.mainactivity_container;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addOrReplaceFragment(GooDetailFragment.createNewInstance(getIntent().getStringExtra(GOO_ID)));
    }

    @Override
    protected int getFirstTabId() {
        return R.id.navigation_info;
    }

    @Override
    protected boolean navigateTo(int id) {
        return false;
    }

    @Override
    public int getNavigationLayout() {
        return R.menu.navigation_details;
    }
}
