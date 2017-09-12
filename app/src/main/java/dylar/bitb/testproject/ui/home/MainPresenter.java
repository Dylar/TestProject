package dylar.bitb.testproject.ui.home;

import javax.inject.Inject;

import dylar.bitb.testproject.model.DummyClass;
import easymvp.RxPresenter;

public class MainPresenter extends RxPresenter<IMainView> {

    protected final DummyClass dummyClass;

    @Inject
    public MainPresenter(DummyClass dummyClass){
        this.dummyClass = dummyClass;
    }

    public String getTitle() {
        return dummyClass.string;
    }
}
