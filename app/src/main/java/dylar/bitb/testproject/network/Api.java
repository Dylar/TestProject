package dylar.bitb.testproject.network;

import io.reactivex.Observable;
import io.reactivex.Single;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface Api {

    interface Goo {

        @GET("goo_list.json")
        Observable<dylar.bitb.testproject.model.Goo> getGoos();

    }

    interface Reddit {

        String PATH_START = "r/{";
        String PATH_END = "}/new/.json";
        String PATH_SUBREDDIT = "subredditName";

        @GET(PATH_START + PATH_SUBREDDIT + PATH_END)
        Single<dylar.bitb.testproject.model.Reddit> fetchSubreddit(@Path(PATH_SUBREDDIT) String subredditName,
                                                                   @Query("limit") String limit);

        @GET(PATH_START + PATH_SUBREDDIT + PATH_END)
        Single<ResponseBody> fetchSubredditForPersister(@Path(PATH_SUBREDDIT) String subredditName,
                                                        @Query("limit") String limit);
    }
}
