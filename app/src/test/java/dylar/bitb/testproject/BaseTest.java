package dylar.bitb.testproject;

import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

@RunWith(RobolectricTestRunner.class)
@Config(sdk = 26, packageName = "dylar.bitb.testproject", constants = BuildConfig.class)
public abstract class BaseTest {

    public BaseTest() {
        MockitoAnnotations.initMocks(this);
    }
}
