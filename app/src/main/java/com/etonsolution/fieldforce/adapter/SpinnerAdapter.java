package com.etonsolution.fieldforce.adapter;

import android.app.Activity;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.etonsolution.fieldforce.R;

import java.util.List;

import butterknife.ButterKnife;

/**
 * Created by BawejaTushar on 10/20/2016.
 */

public class SpinnerAdapter extends ArrayAdapter<String> {

    private Activity activity;
    private List<String> spinnerItems;
    private LayoutInflater inflater;

    public SpinnerAdapter(Activity activity, List<String> spinnerItems) {
        super(activity, R.layout.item_spinner_view_arrow, R.id.tvText, spinnerItems);
        this.activity = activity;
        this.spinnerItems = spinnerItems;
        inflater = activity.getLayoutInflater();
    }

    @Override
    public int getCount() {
        return spinnerItems.size();
    }

    @Override
    public String getItem(int position) {
        return spinnerItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (null == convertView) {
            convertView = inflater.inflate(R.layout.item_spinner_view_arrow, parent, false);
        }
        TextView tvText = ButterKnife.findById(convertView, R.id.tvText);
        tvText.setText(getItem(position));

        if (0 == position) {
            tvText.setTextColor(ContextCompat.getColor(activity, R.color.colorPrimary));
        } else {
            tvText.setTextColor(ContextCompat.getColor(activity, R.color.colorPrimary));
        }
        return convertView;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        if (null == convertView) {
            convertView = inflater.inflate(R.layout.item_spinner_dropdown, parent, false);
        }

        TextView tvItemText = ButterKnife.findById(convertView, R.id.tvItemText);
        tvItemText.setText(getItem(position));

        if (position == spinnerItems.size() - 1) {
            convertView.setBackgroundColor(Color.TRANSPARENT);
        } else {
            convertView.setBackgroundResource(R.drawable.background_bottom_border_grey);
        }
        return convertView;
    }
}
