package com.example.fcy.firstday_xts_eight_twenty_one;

import bean.FuLi;
import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by fcy on 2019/8/21.
 */

public interface ApiService {
    String httFuLi="http://gank.io/api/";
    @GET("data/%E7%A6%8F%E5%88%A9/20/1")
    Observable<FuLi> getFuLiDatas();
}
