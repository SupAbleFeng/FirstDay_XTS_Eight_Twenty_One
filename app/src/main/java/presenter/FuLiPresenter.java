package presenter;

import java.util.ArrayList;

import bean.FuLi;
import model.FuLiModel;
import view.FuLiView;

/**
 * Created by fcy on 2019/8/21.
 */

public class FuLiPresenter implements FuLiModel.FuLiInterFace{
    FuLiModel fuLiModel;
    FuLiView fuLiView;

    public FuLiPresenter(FuLiView fuLiView) {
        this.fuLiModel =new FuLiModel();
        this.fuLiView = fuLiView;
    }

    public void getFuLiDatas(){
        fuLiModel.getFuLiDatas(this);
    }
    @Override
    public void onSuccess(ArrayList<FuLi.ResultsBean> list) {
        fuLiView.setFuLiDatas(list);
    }

    @Override
    public void onFaile(String string) {
        fuLiView.showToast(string);
    }
}
