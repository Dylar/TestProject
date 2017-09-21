package dylar.bitb.testproject.ui.home;

import javax.inject.Inject;

import easymvp.RxPresenter;

public class MainPresenter extends RxPresenter<IMainView> {

    @Inject
    public MainPresenter(){

    }

    public String getTitle() {
        return "Title";
    }
}
