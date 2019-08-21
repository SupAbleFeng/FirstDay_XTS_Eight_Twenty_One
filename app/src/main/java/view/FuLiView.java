package view;

import java.util.ArrayList;

import bean.FuLi;

/**
 * Created by fcy on 2019/8/21.
 */

public interface FuLiView {
    void setFuLiDatas(ArrayList<FuLi.ResultsBean> list);
    void showToast(String string);
}
