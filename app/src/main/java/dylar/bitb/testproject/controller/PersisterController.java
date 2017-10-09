package dylar.bitb.testproject.controller;


import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.nytimes.android.external.fs3.SourcePersisterFactory;
import com.nytimes.android.external.store3.base.Parser;
import com.nytimes.android.external.store3.base.Persister;
import com.nytimes.android.external.store3.base.impl.BarCode;
import com.nytimes.android.external.store3.base.impl.Store;
import com.nytimes.android.external.store3.base.impl.StoreBuilder;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

import dylar.bitb.testproject.BuildConfig;
import dylar.bitb.testproject.model.Reddit;
import dylar.bitb.testproject.network.Api;
import io.reactivex.Single;
import okhttp3.ResponseBody;
import okio.BufferedSource;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PersisterController {

    //    private Store<Reddit, BarCode> nonPersistedStore;
    private Store<Reddit, BarCode> persistedStore;
    private Persister<BufferedSource, BarCode> persister;
    private File cacheDir;

    public PersisterController(Context context) {
        cacheDir = context.getCacheDir();
//        this.nonPersistedStore = provideRedditStore();
        this.persistedStore = providePersistedRedditStore();
    }

    private Persister<BufferedSource, BarCode> getPersister() {
        try {
            if (persister == null) {
                persister = newPersister();
            }
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        return persister;
    }

//    public Store<Reddit, BarCode> getNonPersistedStore() {
//        return this.nonPersistedStore;
//    }

    public Store<Reddit, BarCode> getPersistedStore() {
        return this.persistedStore;
    }

//    private Store<Reddit, BarCode> provideRedditStore() {
//        return StoreBuilder.<Reddit>barcode()
//                .fetcher(barCode -> provideRetrofit().fetchSubreddit(barCode.getKey(), "10"))
//                .memoryPolicy(
//                        MemoryPolicy
//                                .builder()
//                                .setExpireAfter(10)
//                                .setExpireAfterTimeUnit(TimeUnit.SECONDS)
//                                .build()
//                )
//                .open();
//    }

    private Store<Reddit, BarCode> providePersistedRedditStore() {
        return StoreBuilder.<BarCode, BufferedSource, Reddit>parsedWithKey()
                .fetcher(this::fetcher)
                .persister(getPersister())
                .parser(getParser())
                .open();
    }

    private Persister<BufferedSource, BarCode> newPersister() throws IOException {
        return SourcePersisterFactory.create(cacheDir);
    }

    private Single<BufferedSource> fetcher(BarCode barCode) {
        return provideRetrofit().fetchSubredditForPersister(barCode.getKey(), "10").map(ResponseBody::source);
    }

    private Api.Reddit provideRetrofit() {
        return new Retrofit.Builder()
                .baseUrl("http://reddit.com/")
                .addConverterFactory(GsonConverterFactory.create(provideGson()))
//                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .validateEagerly(BuildConfig.DEBUG)  // Fail early: check Retrofit configuration at creation time in Debug build.
                .build()
                .create(Api.Reddit.class);
    }

    Gson provideGson() {
        return new GsonBuilder()
                .create();
    }

    public Parser<BufferedSource, Reddit> getParser() {
//        Parser<BufferedSource, Object> parser = GsonParserFactory.createSourceParser(provideGson(), Reddit.class);
        Parser<BufferedSource, Reddit> parser = bufferedSource -> {
            Reddit reddit = new Reddit();
            Charset charset = Charset.defaultCharset();
            try {
                reddit.json = bufferedSource.readString(charset);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return reddit;
        };
        return parser;
    }
}
