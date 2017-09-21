package dylar.bitb.testproject.ui.model;


import dylar.bitb.testproject.model.Goo;

public interface IGooRowView {

    void setGoo(Goo goo);

    void setDetailClickListener(IGooAndPrickleView gooAndPrickleView);
}
