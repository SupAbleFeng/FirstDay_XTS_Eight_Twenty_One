package com.example.fcy.firstday_xts_eight_twenty_one;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import adapters.Adapter_Rv;
import adapters.Adapter_ViewPager;
import bean.FuLi;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import presenter.FuLiPresenter;
import view.FuLiView;

public class MainActivity extends AppCompatActivity implements FuLiView, Adapter_Rv.onMyClick, ViewPager.OnPageChangeListener {

    @BindView(R.id.rv)
    RecyclerView mRv;
    @BindView(R.id.vp)
    ViewPager mVp;
    @BindView(R.id.txt)
    TextView mTxt;
    private FuLiPresenter mFuLiPresenter;
    private ArrayList<FuLi.ResultsBean> resultsBeans;
    private Adapter_Rv mAdapter_rv;
    private ArrayList<ImageView> mList_view;
    private Adapter_ViewPager mAdapter_viewPager;
    int position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFuLiPresenter = new FuLiPresenter(this);
        ButterKnife.bind(this);
        initSetRv();
    }

    private void initSetRv() {
        mRv.setLayoutManager(new StaggeredGridLayoutManager(2, OrientationHelper.VERTICAL));
        mFuLiPresenter.getFuLiDatas();
        resultsBeans = new ArrayList<>();
        mAdapter_rv = new Adapter_Rv(this, resultsBeans);
        mRv.setAdapter(mAdapter_rv);




        mAdapter_rv.setOnMyClick(this);
        mVp.addOnPageChangeListener(this);
    }

    @OnClick({R.id.rv, R.id.vp, R.id.txt})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.rv:
                break;
            case R.id.vp:
                break;
            case R.id.txt:
                break;
        }
    }

    @Override
    public void setFuLiDatas(ArrayList<FuLi.ResultsBean> list) {
        resultsBeans.addAll(list);
        mAdapter_rv.notifyDataSetChanged();
        Log.i("tag", "福利数据" + list.toString());
    }

    @Override
    public void showToast(String string) {
        Toast.makeText(this, string, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemClickListener(int position) {
        mList_view = new ArrayList<>();
        mRv.setVisibility(View.GONE);
        mVp.setVisibility(View.VISIBLE);
        mTxt.setVisibility(View.VISIBLE);
        this.position = position;
        for (int i = 0; i < resultsBeans.size(); i++) {
            ImageView imageView = new ImageView(this);
          /*  View inflate = LayoutInflater.from(this).inflate(R.layout.layout_show_viewpager, null);
            ImageView img_show = inflate.findViewById(R.id.img_show);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                         mRv.setVisibility(View.VISIBLE);
                         mVp.setVisibility(View.GONE);
                         mTxt.setVisibility(View.GONE);
                }
            });*/
            Glide.with(this).load(resultsBeans.get(i).getUrl()).into(imageView);
            mList_view.add(imageView);
        }
        mAdapter_viewPager = new Adapter_ViewPager(mList_view);
        mVp.setAdapter(mAdapter_viewPager);
        mVp.setCurrentItem(position);
        mAdapter_viewPager.notifyDataSetChanged();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        mTxt.setText(position+1+"/"+20);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    //返回键方法
  /*  @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BACK){
            mRv.setVisibility(View.VISIBLE);
            mVp.setVisibility(View.GONE);
            mTxt.setVisibility(View.GONE);
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }*/

    @Override
    public void onBackPressed() {
        //如果RecyclerView的
        if(mRv.getVisibility()!=View.VISIBLE){
            mRv.setVisibility(View.VISIBLE);
            mVp.setVisibility(View.GONE);
            mTxt.setVisibility(View.GONE);
        }else {
            super.onBackPressed();
        }

    }
}
