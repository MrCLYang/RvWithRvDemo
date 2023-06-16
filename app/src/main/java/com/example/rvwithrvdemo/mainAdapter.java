package com.example.rvwithrvdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/**
 * @ClassName mainAdapter
 * @Description TODO
 * @Author YangChengLei
 * @Date 2023/6/16 11:17
 * @Version 1.0
 */
public class mainAdapter extends RecyclerView.Adapter<mainAdapter.mainViewHolder> {
    private List<CListdemo> mlistdemos;


    private Context mContext;


    private int lastpoint;


    public mainAdapter(Context context, List<CListdemo> listdemos) {
        mContext = context;
        mlistdemos = listdemos;
        lastpoint = 0; //第一个默认展开
    }

    @NonNull
    @Override
    public mainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.rcl_main, parent, false);


        return new mainViewHolder(mContext, v);
    }

    @Override
    public void onBindViewHolder(@NonNull mainViewHolder holder, int position) {
        final mainViewHolder viewHolder = (mainViewHolder) holder;


        final CListdemo item = mlistdemos.get(position);
        viewHolder.ShowItem(item.items);
        viewHolder.tvOrderno.setText(item.OrderNo);
        viewHolder.btnshow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (viewHolder.rcl_item.getVisibility() == View.VISIBLE) {
                    viewHolder.rcl_item.setVisibility(View.GONE);
                } else {
                    viewHolder.rcl_item.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mlistdemos.size();
    }




    public static class mainViewHolder extends RecyclerView.ViewHolder {
        public TextView tvOrderno;
        public Button btnshow;
        public RecyclerView rcl_item;
        private ItemAdapter itemAdapter;
        private GridLayoutManager layoutManager;
        public void ShowItem(List<Citem> citems) {
            itemAdapter.SetData(citems);
            //填充数据
            rcl_item.setAdapter(itemAdapter);
        }
        public mainViewHolder(Context context, View itemView) {
            super(itemView);

            tvOrderno = itemView.findViewById(R.id.tvpallcode);
            btnshow = itemView.findViewById(R.id.btnshowitem);
            rcl_item = itemView.findViewById(R.id.rcl_item);


            itemAdapter = new ItemAdapter(context);
            layoutManager = new GridLayoutManager(context, 2);
            rcl_item.setLayoutManager(layoutManager);


        }
    }

}
