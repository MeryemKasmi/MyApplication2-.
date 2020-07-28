package com.example.myapplication;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class recycleviewAdapter extends RecyclerView.Adapter <recycleviewAdapter.ViewHolder> {
    private static final String TAG = "recycleviewAdapter"; // to mark the debug
    //les variables
    private ArrayList<String>  mNames;
    private ArrayList<String>  mImgURL;
    private Context mContext;

    public recycleviewAdapter(Context mContext , ArrayList<String>  Names , ArrayList<String>  ImgURL) {
        this.mContext = mContext;
        this.mNames = Names ;
        this.mImgURL = ImgURL;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG,"onCreateViewHolder : called");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitems,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d(TAG,"onBindViewHolder : called");
        holder.titre.setText(mNames.get(position));
        holder.logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG,"onClick : image clicked");
                Toast.makeText(mContext,mNames.get(position),Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public int getItemCount() {

        return mNames.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView logo;
        TextView titre;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            logo = (ImageView) itemView.findViewById(R.id.image);
            titre =(TextView) itemView.findViewById(R.id.nom);
        }

    }
}
