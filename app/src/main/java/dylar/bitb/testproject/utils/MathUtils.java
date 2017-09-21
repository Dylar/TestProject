package dylar.bitb.testproject.utils;


import java.util.Random;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class MathUtils {

    @Inject
    public MathUtils() {

    }

    public int getRandomInt(int min, int max) {
        Random rn = new Random();
        int n = max - min + 1;
        int i = rn.nextInt() % n;
        return min + i;
    }

}
