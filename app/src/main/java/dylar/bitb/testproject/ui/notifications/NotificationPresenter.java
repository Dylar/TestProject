package dylar.bitb.testproject.ui.notifications;


import com.nytimes.android.external.store3.base.impl.BarCode;

import javax.inject.Inject;

import dylar.bitb.testproject.controller.RedditController;
import dylar.bitb.testproject.model.Reddit;
import easymvp.RxPresenter;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class NotificationPresenter extends RxPresenter<INotificationView> {

    private final RedditController redditController;

    @Inject
    public NotificationPresenter(RedditController redditController){
        this.redditController = redditController;
    }

    public void onCreate(){

    }

    protected void onResume() {
        loadPosts();
    }

    @SuppressWarnings("CheckReturnValue")
    public void loadPosts() {
        BarCode awwRequest = new BarCode(Reddit.class.getSimpleName(), "drugs");

        this.redditController.getPersistedStore()
                .get(awwRequest)
//                .flatMapObservable(this::sanitizeData)
//                .toList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::showPosts);
    }



    private void showPosts(Reddit posts) {
        getView().showPost(posts);
    }

//    private Observable<Reddit> sanitizeData(Reddit redditData) {
//        return Observable.fromIterable(redditData.data().children()).map(Children::data);
//    }
}
