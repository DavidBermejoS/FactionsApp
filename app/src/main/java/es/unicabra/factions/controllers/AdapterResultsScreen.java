package es.unicabra.factions.controllers;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Arrays;

import androidx.recyclerview.widget.RecyclerView;
import es.unicabra.factions.R;
import es.unicabra.factions.pojos.values.Values;

/**
 * <b>AdapterResultsScreen Class</b>
 * This class is named RA for the acronym of Recycler Adapter. This class is the adapter
 * of the results screen in tool functionality.
 * @author David Bermejo Simon
 */
public class AdapterResultsScreen extends RecyclerView.Adapter <AdapterResultsScreen.MyViewHolder> {
    private Values values;

    /**
     * <b>MyViewHolder</b>
     * This class is used by adapter for every single item in the results list.
     * @author David Bermejo Simón
     */
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        /**
         * This textView will store all the dice results per row
         */
        public TextView textDiceResults;
        /**
         * This textView will store the result of the sumatory of all the elements
         * in textDiceResults
         */
        public TextView textSumResults;

        /**
         * This textview will notify users the index of failed results per row.
         */
        public TextView textIndexFailed;

        public MyViewHolder(View itemView) {
            super(itemView);
            textDiceResults = (TextView) itemView.findViewById(R.id.textDiceResults);
            textDiceResults.setSelected(true);
            textSumResults = (TextView) itemView.findViewById(R.id.textSumResults);
            textIndexFailed=itemView.findViewById(R.id.textIndexFailed);
        }
    }

    public AdapterResultsScreen(Values v) {
        values = v;
    }

    @Override
    public AdapterResultsScreen.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.single_item_tool_result,parent,false);
        MyViewHolder vh = new MyViewHolder(listItem);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.textDiceResults.setText(getResultsPerRow(position));
        holder.textSumResults.setText(values.getCalculatedValues().getSumValues()[position]);
        holder.textIndexFailed.setText(values.getCalculatedValues().getIndexFailed()[position]+"% de los ataques han fallado.");
    }

    private String getResultsPerRow(int position) {
        int [] vector = values.getInitialValues().getMatrixValues()[position];
        String result = Arrays.toString(vector);
        return result.substring(1, result.length()-1);
    }

    @Override
    public int getItemCount() {
        return values.getInitialValues().getMatrixValues().length;
    }
}