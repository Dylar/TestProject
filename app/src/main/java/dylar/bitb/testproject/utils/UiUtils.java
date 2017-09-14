package dylar.bitb.testproject.utils;


public class UiUtils {


    private static UiUtils instance;

    private UiUtils() {

    }

    public static UiUtils getInstance() {
        if (instance == null) {
            instance = new UiUtils();
        }
        return instance;
    }
}
