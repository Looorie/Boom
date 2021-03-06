package me.looorielovbb.boom.ui.home.meizi;

import android.os.Handler;
import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import me.looorielovbb.boom.config.Constants;
import me.looorielovbb.boom.data.bean.gank.Girl;
import me.looorielovbb.boom.data.source.DataRepository;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

import static me.looorielovbb.boom.utils.Preconditions.checkNotNull;

/**
 * Created by Lulei on 2017/2/9.
 * time : 10:58
 * date : 2017/2/9
 * mail to lulei4461@gmail.com
 */

public class GirlPresenter implements MeiziContract.Presenter {

    CompositeSubscription mSubscriptions = new CompositeSubscription();
    @NonNull
    private DataRepository mRepository = DataRepository.getInstance();
    @NonNull
    private MeiziContract.View mView;

    private List<Girl> mList = new ArrayList<>();

    public GirlPresenter(@NonNull MeiziContract.View mView) {
        this.mView = checkNotNull(mView, "mView can not be null");
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void loaddata(final int page) {
        if (page == 1)
            mView.showloading();
        Subscription subscription = mRepository
                .getGirl(page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<Girl>>() {
                    @Override
                    public void onCompleted() {
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                mView.dismissLoading();
                            }
                        }, 500);
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showerror(e.getMessage());
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                mView.dismissLoading();
                            }
                        }, 500);
                    }

                    @Override
                    public void onNext(List<Girl> list) {
                        if (list == null) {
                            mView.showerror("没有数据~ 喵");
                        } else if (list.size() == 0) {
                            mView.showerror("没有数据~ 喵");
                            if (!mList.isEmpty()) {
                                mView.showList(mList);
                                mView.loadComplete();
                            }
                        } else {

                            mList.addAll(list);
                            mView.showList(mList);
                            if (list.size() < Constants.PAGE_COUNT) {
                                mView.loadComplete();
                            }
                        }
                    }
                });
        mSubscriptions.add(subscription);
    }

    @Override
    public void clearListData() {
        mList.clear();
    }

    @Override
    public void unsubscribe() {
        mView.dismissLoading();
        mSubscriptions.clear();
    }

}
