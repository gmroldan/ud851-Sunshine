package com.example.android.sunshine.utilities;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.sunshine.R;

/**
 * Created by martin on 15/05/17.
 */

public class ForecastAdapter extends RecyclerView.Adapter<ForecastAdapter.ForecastAdapterViewHolder> {
    private String[] mWeatherData;

    @Override
    public ForecastAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutId = R.layout.forecast_list_item;
        LayoutInflater layoutInflater = LayoutInflater.from(context);

        View view = layoutInflater.inflate(layoutId, parent, false);

        return new ForecastAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ForecastAdapterViewHolder holder, int position) {
        String text = this.mWeatherData[position];
        holder.mWeatherTextView.setText(text);
    }

    @Override
    public int getItemCount() {
        return this.mWeatherData == null ? 0 : this.mWeatherData.length;
    }

    public void setWeatherData(String[] weatherData) {
        this.mWeatherData = weatherData;
        notifyDataSetChanged();
    }

    class ForecastAdapterViewHolder extends RecyclerView.ViewHolder {
        public final TextView mWeatherTextView;

        public ForecastAdapterViewHolder(View itemView) {
            super(itemView);
            this.mWeatherTextView = (TextView) itemView.findViewById(R.id.tv_weather_data);
        }
    }
}
