package dylar.bitb.testproject.controller;


import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Singleton;

import dylar.bitb.testproject.model.Goo;
import dylar.bitb.testproject.utils.DaggerUtilsComponent;
import dylar.bitb.testproject.utils.MathUtils;
import dylar.bitb.testproject.utils.UtilsModule;

@Singleton
public class GooController extends GooConstants{

    @Inject
    public MathUtils mathUtils;

    public GooController(){
        DaggerUtilsComponent.builder().utilsModule(new UtilsModule()).build().inject(this);
    }

    public Goo createNewGoo(){
        return createNewGoo(mathUtils.getRandomInt(MIN_GOONESS, MAX_GOONESS));
    }

    public Goo createNewGoo(int gooness){
        Goo goo = new Goo(gooness);
        goo.setUuid(UUID.randomUUID().toString());
        return goo;
    }
}
