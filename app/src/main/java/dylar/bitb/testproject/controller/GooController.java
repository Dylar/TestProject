package dylar.bitb.testproject.controller;


import java.util.List;
import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Singleton;

import dylar.bitb.testproject.model.Goo;
import dylar.bitb.testproject.utils.DaggerUtilsComponent;
import dylar.bitb.testproject.utils.MathUtils;
import dylar.bitb.testproject.utils.UtilsModule;

@Singleton
public class GooController extends GooConstants{

//    private final Object persistedStore;
    @Inject
    public MathUtils mathUtils;

    public GooController(){
        DaggerUtilsComponent.builder().utilsModule(new UtilsModule()).build().inject(this);
//        this.persistedStore = ((SampleApp) getApplicationContext()).getPersistedStore();
    }

    public Goo createNewGoo(){
        return createNewGoo(mathUtils.getRandomInt(MIN_GOONESS, MAX_GOONESS));
    }

    public Goo createNewGoo(int gooness){
        Goo goo = new Goo(gooness);
        goo.setUuid(UUID.randomUUID().toString());
        return goo;
    }

    public void loadAllGoo(GooRequest gooRequest) {
//        BarCode awwRequest = new BarCode(Goo.class.getSimpleName(), "goo");
//
//        this.persistedStore
//                .get(awwRequest)
//                .flatMapObservable(this::sanitizeData)
//                .toList()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(gooRequest::setGoos, throwable ->
//                        Log.e(StoreActivity.class.getSimpleName(), throwable.getMessage(),
//                                throwable));
    }


    public interface GooRequest {
        void setGoos(List<Goo> goo);
    }
}
