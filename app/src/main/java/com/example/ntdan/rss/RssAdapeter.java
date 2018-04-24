package com.example.ntdan.rss;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ntdan on 4/21/2018.
 */
public class RssAdapeter extends BaseAdapter {
    ArrayList<RssItem> lst;
    Context context;

    public RssAdapeter(ArrayList<RssItem> lst, Context context) {
        this.lst = lst;
        this.context = context;
    }

    @Override
    public int getCount() {
        return lst.size();
    }

    @Override
    public Object getItem(int position) {
        return lst.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        RssCell rssCell;
        if(convertView == null)
        {
            rssCell = new RssCell();

            convertView = ((Activity)context).getLayoutInflater().inflate(R.layout.rsscell, parent, false);

            rssCell.tvTitle = (TextView) convertView.findViewById(R.id.tvTitle);
            //rssCell.tvUrl = (TextView) convertView.findViewById(R.id.tvUrl);
            //rssCell.img = (ImageView)convertView.findViewById(R.id.img);

            convertView.setTag(rssCell);
        }else
        {
            rssCell = (RssCell) convertView.getTag();
        }

        rssCell.tvTitle.setText(lst.get(position).getTitle());
        //rssCell.tvUrl.setText(lst.get(position).getUrl());
        //rssCell.img.setImageBitmap(lst.get(position).getImage());

        return convertView;
    }

    class RssCell
    {
        ImageView img;
        TextView tvTitle, tvUrl;
    }

}
