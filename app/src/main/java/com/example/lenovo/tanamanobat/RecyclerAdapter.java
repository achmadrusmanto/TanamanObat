package com.example.lenovo.tanamanobat;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenovo on 16/07/2018.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> implements Filterable {

    private Context mContext;
    private ArrayList<PoJo> mData;
    private ArrayList<PoJo> mFilter;

    // Constuctor
    public RecyclerAdapter(Context mContext, ArrayList<PoJo> mData) {
        this.mContext = mContext;
        this.mData = mData;
        this.mFilter = mData;

    }

    // Implement Method
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.list_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        holder.tv_book_title.setText(mFilter.get(position).getTitle());
        holder.img_book_thumbnail.setImageResource(mFilter.get(position).getThumbnail());

        // Click Listener
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(mContext, DetailActivity.class);

                // passing data to the book_activity
                intent.putExtra("Title", mFilter.get(position).getTitle());
                intent.putExtra("Category", mFilter.get(position).getCategory());
                intent.putExtra("Description", mFilter.get(position).getDescription());
                intent.putExtra("Thumbnail", mFilter.get(position).getThumbnail());

                // start the activity
                mContext.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return mFilter.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
            String charString = charSequence.toString();
                if (charString.isEmpty()){
                    mFilter = mData;
                }else{
                    ArrayList<PoJo> filteredList = new ArrayList<>();
                    for(PoJo poJo : mData){
                        if (poJo.getTitle().toLowerCase().contains(charString) || poJo.getCategory().toLowerCase().contains(charString) || poJo.getDescription().toLowerCase().contains(charString)) {
                            filteredList.add(poJo);
                        }
                    }
                    mFilter = filteredList;

                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = mFilter;
                return filterResults;

            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults results) {
                mFilter = (ArrayList<PoJo>)results.values;
                notifyDataSetChanged();
            }
        };
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tv_book_title;
        ImageView img_book_thumbnail;
        CardView cardView;

        public MyViewHolder(View itemView) {
            super(itemView);

            tv_book_title = (TextView) itemView.findViewById(R.id.namaTanaman);
            img_book_thumbnail = (ImageView) itemView.findViewById(R.id.gbrTanaman);
            cardView = (CardView) itemView.findViewById(R.id.cardview_id);

        }
    }

}
