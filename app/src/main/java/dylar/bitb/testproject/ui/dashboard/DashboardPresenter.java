package dylar.bitb.testproject.ui.dashboard;


import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dylar.bitb.testproject.controller.GooController;
import dylar.bitb.testproject.model.Goo;
import dylar.bitb.testproject.model.Prickle;
import dylar.bitb.testproject.ui.model.gooprickle.IGooRowView;
import dylar.bitb.testproject.ui.model.gooprickle.IPrickleRowView;
import easymvp.RxPresenter;

public class DashboardPresenter extends RxPresenter<IDashboardView> implements GooController.GooRequest {

    public static final int DUMMY_GOO_COUNT = 14;
    public static final int DUMMY_PRICKLE_COUNT = 4;
    private final GooController gooController;

    private List<Goo> gooList = new ArrayList<>();

    @Inject
    public DashboardPresenter(GooController gooController){
        this.gooController = gooController;
       gooController.loadAllGoo(this);
    }

    public int getGooAndPrickleCount() {
        return getGooCount() + getPrickleCount();
    }

    public int getGooCount() {
        return DUMMY_GOO_COUNT;
    }

    public int getPrickleCount() {
        return DUMMY_PRICKLE_COUNT;
    }

    public void setGoo(IGooRowView holder, int position) {
        holder.setGoo(gooController.createNewGoo());
    }

    public void setPrickle(IPrickleRowView holder, int position) {
        holder.setText(new Prickle().getUuid());
    }

    @Override
    public void setGoos(List<Goo> goo) {
        gooList = goo;
    }
}
