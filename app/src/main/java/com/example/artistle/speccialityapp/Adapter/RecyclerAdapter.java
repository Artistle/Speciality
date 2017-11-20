package com.example.artistle.speccialityapp.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.artistle.speccialityapp.Model.SpecialityModel;
import com.example.artistle.speccialityapp.R;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    private ArrayList<SpecialityModel> listModel;

    public RecyclerAdapter(ArrayList<SpecialityModel> listModels) {
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_user, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        SpecialityModel user = listModel.get(position);
        holder.lname.setText(user.getLName());
        holder.fname.setText(user.getFName());

        //String url_avatar = user.getAvatrUrl();

       /* Glide
                .with(context)
                .load(user.getAvatrUrl())
                .into(holder.avatar);*/
    }

    @Override
    public int getItemCount() {
        return listModel.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView lname;
        TextView fname;
        TextView birthday;
        ImageView avatar;
        public ViewHolder(View itemView) {
            super(itemView);
            lname = (TextView)itemView.findViewById(R.id.text_username);
            fname = (TextView)itemView.findViewById(R.id.text);
            avatar = (ImageView)itemView.findViewById(R.id.avatar);
        }
    }
}
