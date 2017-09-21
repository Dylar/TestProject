package dylar.bitb.testproject.utils;


import android.support.v4.app.FragmentTransaction;

import javax.inject.Inject;
import javax.inject.Singleton;

import dylar.bitb.testproject.R;

@Singleton
public class AnimationUtils {

    @Inject
    public AnimationUtils() {

    }

    public void setAnimations(FragmentTransaction fragmentTransaction) {
        fragmentTransaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right);
    }
}
