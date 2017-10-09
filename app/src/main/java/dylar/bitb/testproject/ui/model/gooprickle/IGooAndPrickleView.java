package dylar.bitb.testproject.ui.model.gooprickle;


import dylar.bitb.testproject.ui.base.IBaseView;

public interface IGooAndPrickleView extends IBaseView{
    int getListCount();

    void setRowGoo(IGooRowView holder, int position);

    void setRowPrickle(IPrickleRowView holder, int position);

    void openGooDetails(String id);
}
