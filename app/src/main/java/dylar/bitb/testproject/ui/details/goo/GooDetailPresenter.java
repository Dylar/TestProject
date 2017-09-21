package dylar.bitb.testproject.ui.details.goo;


import android.os.Bundle;

import javax.inject.Inject;

import dylar.bitb.testproject.controller.GooController;
import dylar.bitb.testproject.model.Goo;
import easymvp.RxPresenter;

public class GooDetailPresenter extends RxPresenter<IGooDetailView> {

    private final GooController controller;
    private Goo goo;

    @Inject
    public GooDetailPresenter(GooController gooController) {
        this.controller = gooController;
    }

    public void onResume() {
        Bundle args = getView().getArguments();
        if (args != null) {
            goo = controller.createNewGoo();
        }

        getView().updateText(goo.getUuid());
    }
}
