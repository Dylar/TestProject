package dylar.bitb.testproject.ui.notifications;


import dylar.bitb.testproject.model.Goo;
import dylar.bitb.testproject.model.Prickle;
import dylar.bitb.testproject.ui.model.IGooRowView;
import dylar.bitb.testproject.ui.model.IPrickleRowView;
import easymvp.RxPresenter;

public class NotificationPresenter extends RxPresenter<INotificationView> {

    public static final int DUMMY_GOO_COUNT = 14;
    public static final int DUMMY_PRICKLE_COUNT = 4;

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
        holder.setText(new Goo().getName());
    }

    public void setPrickle(IPrickleRowView holder, int position) {
        holder.setText(new Prickle().getName());
    }
}
