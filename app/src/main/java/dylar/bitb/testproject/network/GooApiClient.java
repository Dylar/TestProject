package dylar.bitb.testproject.network;

import com.google.gson.GsonBuilder;

import dylar.bitb.testproject.model.Goo;
import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class GooApiClient {
    protected String baseUrl;
    protected Api.Goo programService;

    public GooApiClient(String baseUrl) {
        this.baseUrl = baseUrl;

        programService = buildProgramService(baseUrl);
    }

    private Api.Goo buildProgramService(String baseUrl) {
        return new Retrofit
                .Builder()
                .baseUrl(baseUrl)
//                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(
                        new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create())
                )
                .build()
                .create(Api.Goo.class);
    }

    public Observable<Goo> getGoos() {
        return programService.getGoos();
    }

}
