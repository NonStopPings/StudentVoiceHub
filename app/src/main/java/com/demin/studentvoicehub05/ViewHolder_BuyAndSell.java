package com.demin.studentvoicehub05;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class ViewHolder_BuyAndSell extends RecyclerView.ViewHolder {

    View mView;

    public ViewHolder_BuyAndSell(@NonNull View itemView) {
        super(itemView);

        mView = itemView;

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mClickListener.onItemClick(v,getAdapterPosition());
            }
        });

        itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                mClickListener.onItemLongClick(v,getAdapterPosition());
                return true;
            }
        });

    }

    public void setDetails(Context ctx, String title, String description, String image, String email, String price, String campus){
        TextView mTitleTv = mView.findViewById(R.id.bTitleTv);
        TextView mDescription = mView.findViewById(R.id.bDescriptionTv);
        ImageView mImageIv = mView.findViewById(R.id.bImageView);
        TextView mEmail = mView.findViewById(R.id.bEmail);
        TextView mPrice = mView.findViewById(R.id.bPrice);
        TextView mCampus = mView.findViewById(R.id.bCampus);

        mTitleTv.setText(title);
        mDescription.setText(description);
        mEmail.setText(email);
        mPrice.setText(price);
        mCampus.setText(campus);
        Picasso.get().load(image).into(mImageIv);
    }

    private ViewHolder_BuyAndSell.ClickListener mClickListener;

    public interface ClickListener{
        void onItemClick(View view,int position);
        void onItemLongClick(View view,int position);
    }
    public void setOnClickListener(ViewHolder_BuyAndSell.ClickListener clickListener){
        mClickListener = clickListener;
    }

}
