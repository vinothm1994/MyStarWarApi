package com.example.vinoth.mystarwarapi.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.vinoth.mystarwarapi.R;
import com.example.vinoth.mystarwarapi.model.StarShip;

import java.util.List;
public class SWAdapter extends RecyclerView.Adapter<SWAdapter.MyViewHolder> {

    private Context mContext;
    private List<StarShip> StarShipList;

    public SWAdapter(Context mContext, List<StarShip> StarShipList) {
        this.mContext = mContext;
        this.StarShipList = StarShipList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.starships_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        StarShip starships = StarShipList.get(position);
        holder.tvname.setText("Name:" + starships.getName());
        holder.model.setText("Model:" + starships.getModel());
        holder.manufacturer.setText("manufacturer " + starships.getManufacturer());
        holder.cost_in_credits.setText("cost_in_credits:" + starships.getCost_in_credits());
    }

    @Override
    public int getItemCount() {

        return StarShipList.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {
        private final TextView tvname, model, manufacturer, cost_in_credits;
        public MyViewHolder(View view) {
            super(view);
            tvname = (TextView) view.findViewById(R.id.tvname);
            model = (TextView) view.findViewById(R.id.tvmodel);
            manufacturer = (TextView) view.findViewById(R.id.tvmanufacturer);
            cost_in_credits = (TextView) view.findViewById(R.id.tvcost_in_credits);


        }
    }
}
