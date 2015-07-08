package com.infoeducatie.app.recyclerviews.news;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.infoeducatie.app.R;
import com.infoeducatie.app.client.entities.News;

/**
 * Created by Browsing on 7/7/2015.
 */
public class NewsAdapter extends RecyclerView.Adapter<NewsViewHolder> {

    private News[] news = new News[0];

    /* getters and setters for the news */
    public void setNews(News[] news) {
        this.news = news;
        notifyDataSetChanged();
    }

    public News[] getNews() {
        return news;
    }

    /* */
    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        /* create the view holder */
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news, null);
        NewsViewHolder viewHolder = new NewsViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(NewsViewHolder holder, int position) {
     /* bind the viewholder item */
        holder.title.setText(news[position].getTitle());
        holder.body.setText(news[position].get_Short() + "...");
    }

    @Override
    public int getItemCount() {
        return news.length;
    }
}
