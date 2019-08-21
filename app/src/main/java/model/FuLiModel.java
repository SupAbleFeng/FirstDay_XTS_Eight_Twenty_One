package model;

import android.util.Log;

import com.example.fcy.firstday_xts_eight_twenty_one.ApiService;

import java.util.ArrayList;
import java.util.List;

import bean.FuLi;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by fcy on 2019/8/21.
 */

public class FuLiModel {

    public void getFuLiDatas(final FuLiInterFace fuLiInterFace){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiService.httFuLi)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        Observable<FuLi> fuLiDatas = apiService.getFuLiDatas();
        fuLiDatas.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<FuLi>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(FuLi fuLi) {
                        if(fuLi!=null){
                            ArrayList<FuLi.ResultsBean> results = (ArrayList<FuLi.ResultsBean>) fuLi.getResults();
                            Log.i("tag","解析数据"+results.toString());
                            fuLiInterFace.onSuccess(results);
                        }else{
                            fuLiInterFace.onFaile("福利没有数据");
                        }
                    }
                    @Override
                    public void onError(Throwable e) {
                        Log.i("tag","福利错误"+e.getMessage());
                    }
                    @Override
                    public void onComplete() {

                    }
                });
    }
    public interface FuLiInterFace{
        void onSuccess(ArrayList<FuLi.ResultsBean> list);
        void onFaile(String string);
    }
}
