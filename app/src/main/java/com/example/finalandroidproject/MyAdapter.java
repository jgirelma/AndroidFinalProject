package com.example.finalandroidproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private ArrayList<Note> mDataset;
    private OnNoteListener mOnNoteListener;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        // each data item is just a string in this case
        public TextView Title;
        public TextView Summary;
        public OnNoteListener onNoteListener;

        public MyViewHolder(View v, OnNoteListener onNoteListener) {
            super(v);
            Title = v.findViewById(R.id.Title);
            Summary = v.findViewById(R.id.Summary);
            this.onNoteListener = onNoteListener;
            v.setOnClickListener(this);
        }

        public void onClick(View view) {
            onNoteListener.onNoteClick(getAdapterPosition());
        }


    }


    public void refreshMyList(ArrayList<Note> list){
        this.mDataset.clear();
        this.mDataset.addAll(list);
        this.notifyDataSetChanged();
    }

    public interface OnNoteListener {
        void onNoteClick(int position);
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(ArrayList<Note> myDataset, OnNoteListener onNoteListener) {
        this.mDataset = myDataset;
        this.mOnNoteListener = onNoteListener;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.my_text_view, parent, false);

        MyViewHolder vh = new MyViewHolder(v, mOnNoteListener);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        String title = mDataset.get(position).getTitle();
        holder.Title.setText(title.length() > 36 ? title.substring(0,37) + "..." : title);
        String body = mDataset.get(position).getBody();
        holder.Summary.setText( body.length() > 63 ? body.substring(0,64) + "..." : body);


    }



    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}

