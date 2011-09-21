/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mikebevz.upnp.device_browser;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.mikebevz.upnp.R;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mikebevz
 */
public class GenericKeyValueAdapter extends BaseAdapter {
    
    private List<String> data;
    private LayoutInflater mInflater;
    private final Bitmap icon;
    
    /**
     * 
     * @param context
     */
    public GenericKeyValueAdapter(Context context) {
        mInflater = LayoutInflater.from(context);

        data = new ArrayList<String>();
        icon = BitmapFactory.decodeResource(context.getResources(), R.drawable.info);
    }
    

     /**
      * 
      * @return
      */
     public int getCount() {
        
        return data.size();
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * 
     * @param position
     * @return
     */
    public Object getItem(int position) {
        return data.get(position);
        
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * 
     * @param position
     * @return
     */
    public long getItemId(int position) {
        return position;//throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * 
     * @param position
     * @param cView
     * @param parent
     * @return
     */
    public View getView(int position, View cView, ViewGroup parent) {

        ViewHolder holder;

        if (cView == null) {
            cView = mInflater.inflate(R.layout.list_item_icon_text, null);

            holder = new ViewHolder();
            holder.text = (TextView) cView.findViewById(R.id.text);
            holder.description = (TextView) cView.findViewById(R.id.description);
            holder.icon = (ImageView)cView.findViewById(R.id.icon);
            
            cView.setTag(holder);
        } else {
            holder = (ViewHolder) cView.getTag();
        }


        holder.text.setText(data.get(position));
        holder.icon.setImageBitmap(icon);

        return cView;
    }

    static class ViewHolder {

        TextView text;
        TextView description;
        ImageView icon;
    }

    /**
     * @return the data
     */
    public List<String> getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(List<String> data) {
        this.data = data;
    }

    
}
