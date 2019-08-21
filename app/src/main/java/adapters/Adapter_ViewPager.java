package adapters;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.fcy.firstday_xts_eight_twenty_one.R;

import java.util.ArrayList;
/**
 * Created by fcy on 2019/8/21.
 */

public class Adapter_ViewPager extends PagerAdapter{


    private ArrayList<ImageView> views;

    public Adapter_ViewPager(ArrayList<ImageView> views) {
        this.views = views;
    }

    @Override
    public int getCount() {
        return views.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        ImageView imageView = views.get(position);
        container.addView(imageView);
        return imageView;
    }
    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        ImageView imageView = views.get(position);
        container.removeView(imageView);
    }
}
