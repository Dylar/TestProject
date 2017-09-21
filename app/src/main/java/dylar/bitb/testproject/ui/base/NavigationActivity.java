package dylar.bitb.testproject.ui.base;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import dylar.bitb.testproject.R;

public abstract class NavigationActivity extends BaseActivity {

    @BindView(R.id.mainactivity_navigation)
    BottomNavigationView navigation;

    private List<Integer> buttonHistory;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        navigation.setOnNavigationItemSelectedListener(this);
        navigation.inflateMenu(getNavigationLayout());
        buttonHistory = new ArrayList<>();
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (buttonHistory.isEmpty() || id != buttonHistory.get(buttonHistory.size() - 1)) {
            buttonHistory.add(id);
            return navigateTo(id);
        }
        return false;
    }

    public abstract int getNavigationLayout();

    protected abstract int getFirstTabId();

    protected abstract boolean navigateTo(int id);

    @Override
    public void onBackPressed() {
        if (buttonHistory != null && !buttonHistory.isEmpty()) {
            buttonHistory.remove(buttonHistory.size() - 1);
            Menu menu = navigation.getMenu();
            int id = buttonHistory.isEmpty() ? getFirstTabId() : buttonHistory.get(buttonHistory.size() - 1);
            for (int i = 0; i < menu.size(); i++) {
                MenuItem item = menu.getItem(i);
                if (item.getItemId() == id) {
                    item.setChecked(true);
                }
            }
        }
        super.onBackPressed();
    }

}
