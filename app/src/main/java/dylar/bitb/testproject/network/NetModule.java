package dylar.bitb.testproject.network;


import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class NetModule {

    private static String DEFAULT_URL = "www.google.de";

    final private String baseUrl;

    public NetModule() {
        this.baseUrl = DEFAULT_URL;
    }

    public NetModule(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Singleton
    @Provides
    public GooApiClient programApiClient() {
        return new GooApiClient(baseUrl);
    }
}
