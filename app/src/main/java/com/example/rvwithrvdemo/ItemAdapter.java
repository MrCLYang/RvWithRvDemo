package com.example.rvwithrvdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/**
 * @ClassName ItemAdapter
 * @Description TODO
 * @Author YangChengLei
 * @Date 2023/6/16 11:03
 * @Version 1.0
 */
public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.lstItemViewHolder> {
    private List<Citem> mitems;
    private Context mContext;


    public ItemAdapter(Context context) {
        mContext = context;
    }

    //给当前列表数据赋值
    public void SetData(List<Citem> citems) {
        mitems = citems;
    }


    @NonNull
    @Override
    public lstItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.rcl_item, parent, false);
        return new lstItemViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull lstItemViewHolder holder, int position) {
        final lstItemViewHolder viewHolder = ((lstItemViewHolder) holder);
        final Citem item = mitems.get(position);
        viewHolder.tvCode.setText(item.Code);
        viewHolder.tvName.setText(item.Name);
        viewHolder.btncs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                item.Name = item.Name + ",被点击了";
                viewHolder.tvName.setText(item.Name);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mitems.size();
    }


    public static class lstItemViewHolder extends RecyclerView.ViewHolder {
        public TextView tvCode;
        public TextView tvName;
        public Button btncs;


        public lstItemViewHolder(View itemView) {
            super(itemView);
            tvCode = itemView.findViewById(R.id.tvcode);
            tvName = itemView.findViewById(R.id.tvname);
            btncs = itemView.findViewById(R.id.btncs);
        }
    }

}
