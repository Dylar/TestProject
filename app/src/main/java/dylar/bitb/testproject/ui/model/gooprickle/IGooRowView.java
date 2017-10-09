package dylar.bitb.testproject.ui.model.gooprickle;


import dylar.bitb.testproject.model.Goo;

public interface IGooRowView {

    void setGoo(Goo goo);

    void setDetailClickListener(IGooAndPrickleView gooAndPrickleView);
}
