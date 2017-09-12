package dylar.bitb.testproject.network;

import dylar.bitb.testproject.model.Goo;
import io.reactivex.Observable;
import retrofit2.http.GET;


interface IGooService {
    @GET("goo_list.json")
    Observable<Goo> getGoos();

//    @GET("channel_programs_{channelId}.json")
//    Observable<Programs> getPrograms(@Path("channelId")int channelId);
}
