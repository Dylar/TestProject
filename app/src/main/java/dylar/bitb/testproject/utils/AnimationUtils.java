package dylar.bitb.testproject.utils;


import android.support.v4.app.FragmentTransaction;

import dylar.bitb.testproject.R;

public class AnimationUtils {

    private static AnimationUtils instance;

    private AnimationUtils() {

    }

    public static AnimationUtils getInstance() {
        if (instance == null) {
            instance = new AnimationUtils();
        }
        return instance;
    }

    public void setAnimations(FragmentTransaction fragmentTransaction) {
        fragmentTransaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right);
    }
}
