package dylar.bitb.testproject.ui.model;


public interface IGooAndPrickleView {
    int getListCount();

    void setRowGoo(IGooRowView holder, int position);

    void setRowPrickle(IPrickleRowView holder, int position);
}
