package com.krunalkapadiya.horizontalrecyclerviewindicator;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.amulyakhare.textdrawable.TextDrawable;
import com.amulyakhare.textdrawable.util.ColorGenerator;

import java.util.ArrayList;

/**
 * Created by krunal on 16-Nov-16.
 */
public class HorizontalRVAdapter extends RecyclerView.Adapter<HorizontalRVAdapter.ViewHolder> {

    private MainActivity mActivity;
    private ArrayList<String> mArrayList;

    public HorizontalRVAdapter(MainActivity mainActivity, ArrayList<String> arrayList) {
        this.mActivity = mainActivity;
        this.mArrayList = arrayList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.text.setText(mArrayList.get(position));

        ColorGenerator generator = ColorGenerator.MATERIAL;
        TextDrawable drawable = TextDrawable.builder()
                .buildRound(String.valueOf(mArrayList.get(position).charAt(0)), generator.getRandomColor());
        holder.image.setImageDrawable(drawable);

        //TODO When position comes between 4 to arraylist.size() get Notified

        if (position > 4)
            mActivity.updateIndicator(position);


    }

    @Override
    public int getItemCount() {
        return mArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView text;
        public ImageView image;

        public ViewHolder(View itemView) {
            super(itemView);
            text = (TextView) itemView.findViewById(R.id.txt_row_text);
            image = (ImageView) itemView.findViewById(R.id.img_row_image);
        }
    }
}
