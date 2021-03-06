package me.looorielovbb.boom.data.source.local;

import java.util.List;

import me.looorielovbb.boom.data.bean.gank.Girl;
import me.looorielovbb.boom.data.bean.others.ZhuangbiImage;
import me.looorielovbb.boom.data.source.DataSource;
import rx.Observable;

/**
 * Created by Lulei on 2017/2/21.
 * time : 15:38
 * date : 2017/2/21
 * mail to lulei4461@gmail.com
 */

public class LocalDataSource implements DataSource{
    private static LocalDataSource INSTANCE;

    private LocalDataSource() {

    }

    public  static LocalDataSource getInstance(){
        if (INSTANCE==null){
            INSTANCE = new LocalDataSource();
        }
        return INSTANCE;
    }

    @Override
    public Observable<List<Girl>> getGirl(int page) {
        return Observable.empty();
    }

    @Override
    public Observable<List<ZhuangbiImage>> getEmoji(String keyword) {
        return Observable.empty();
    }
}
