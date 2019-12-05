package com.example.storyteller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CardRecyclerAdapter extends RecyclerView.Adapter<CardRecyclerAdapter.CardViewHolder> {

    private Context mContext ;
    private List<BookCard> mData ;

    public CardRecyclerAdapter(Context mContext, List<BookCard> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        View view = mInflater.inflate(R.layout.content_cardview,parent,false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CardViewHolder holder, int position) {
        holder.tv_question.setText(mData.get(position).getQuestion());
        holder.tv_answer.setText(mData.get(position).getAnswer());
        holder.tv_question.setVisibility(mData.get(position).noQuestion() ?
                View.GONE : View.VISIBLE);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class CardViewHolder extends RecyclerView.ViewHolder {

        TextView tv_question;
        TextView tv_answer;

        public CardViewHolder(View itemView) {
            super(itemView);
            tv_question = itemView.findViewById(R.id.tvQuestion);
            tv_answer = itemView.findViewById(R.id.tvAnswer);
        }
    }
}
