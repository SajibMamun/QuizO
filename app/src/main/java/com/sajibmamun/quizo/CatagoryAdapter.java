package com.sajibmamun.quizo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.net.URL;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class CatagoryAdapter extends RecyclerView.Adapter<CatagoryAdapter.viewHolder> {
    private  Context context;

    private List<CatagoryModel> catagoryModelList;

    public CatagoryAdapter(Context context, List<CatagoryModel> catagoryModelList) {
        this.context = context;
        this.catagoryModelList = catagoryModelList;
    }

    @NonNull
    @Override
    public CatagoryAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.catagoryitem, parent, false);

        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CatagoryAdapter.viewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.setData(catagoryModelList.get(position).getImageURL(),catagoryModelList.get(position).getTitle());

        holder.catagorylayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(context,QuestionSetActivity.class);
                intent.putExtra("title",catagoryModelList.get(position).getTitle());
                context.startActivity(intent);


            }
        });

    }

    @Override
    public int getItemCount() {
        return catagoryModelList.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {

        private CircleImageView catagoryImage;
        private TextView CatagoryTitle;
        private LinearLayout catagorylayout;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            catagoryImage = itemView.findViewById(R.id.catagoryimageid);
            CatagoryTitle = itemView.findViewById(R.id.catagorytileid);
            catagorylayout=itemView.findViewById(R.id.catagoryitemid);
        }

        private void setData(String url, String title) {
            Glide.with(itemView.getContext()).load(url).into(catagoryImage);
            this.CatagoryTitle.setText(title);
        }
    }
}
