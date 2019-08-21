package adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.fcy.firstday_xts_eight_twenty_one.MainActivity;
import com.example.fcy.firstday_xts_eight_twenty_one.R;

import java.util.ArrayList;

import bean.FuLi;

/**
 * Created by fcy on 2019/8/21.
 */

public class Adapter_Rv extends RecyclerView.Adapter{
    private Context context;
    private ArrayList<FuLi.ResultsBean> list;

    public Adapter_Rv(Context context, ArrayList<FuLi.ResultsBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.layout, null);
        return new Holder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        Holder holder1 = (Holder) holder;
        Glide.with(context).load(list.get(position).getUrl()).into(holder1.img_FuLi);
        holder1.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onMyClick.onItemClickListener(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }



    class Holder extends RecyclerView.ViewHolder{

        public ImageView img_FuLi;

        public Holder(View itemView) {
            super(itemView);
             img_FuLi = itemView.findViewById(R.id.img_FuLi);
        }
    }
    public interface onMyClick{
        void onItemClickListener(int position);
    }
    onMyClick onMyClick;

    public void setOnMyClick(Adapter_Rv.onMyClick onMyClick) {
        this.onMyClick = onMyClick;
    }
}
