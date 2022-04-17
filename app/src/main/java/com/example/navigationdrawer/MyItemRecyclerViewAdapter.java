package com.example.navigationdrawer;

import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.example.navigationdrawer.placeholder.Machine;
import com.example.navigationdrawer.placeholder.PlaceholderContent;
import com.example.navigationdrawer.databinding.FragmentItemBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link PlaceholderContent.Machine}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyItemRecyclerViewAdapter extends RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder> implements Filterable {

    private  List<PlaceholderContent.Machine> mValues;
    private static List<PlaceholderContent.Machine> machinesFilter;
    private NewFilter mfilter;


    public MyItemRecyclerViewAdapter(List<PlaceholderContent.Machine> items) {
        machinesFilter = items;
        mValues=new ArrayList<>();
        mfilter = new NewFilter(this);

    }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d("viewHolder","dada");

        return new ViewHolder(FragmentItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = machinesFilter.get(position);
        holder.mIdView.setText(machinesFilter.get(position).getId()+"");
        holder.mContentView.setText(machinesFilter.get(position).getReference());
        holder.mMarqueView.setText(machinesFilter.get(position).getMarque().getLibelle());
        holder.mPrixView.setText(machinesFilter.get(position).getPrix()+"");
        holder.mDateView.setText(machinesFilter.get(position).getDateAchat()+"");
    }

    @Override
    public int getItemCount() {
        if(!machinesFilter.isEmpty())
            mValues.addAll(machinesFilter);
        return machinesFilter.size();
    }

    @Override
    public Filter getFilter() {
        return mfilter;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView mIdView;
        public final TextView mContentView;
        public final TextView mDateView;
        public final TextView mPrixView;
        public final TextView mMarqueView;
        public PlaceholderContent.Machine mItem;

        public ViewHolder(FragmentItemBinding binding) {
            super(binding.getRoot());
            mIdView = binding.item;
            mContentView = binding.content;
            mDateView = binding.date;
            mMarqueView = binding.marque;
            mPrixView = binding.prix;
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
    public class NewFilter extends Filter {
        public RecyclerView.Adapter mAdapter;
        public NewFilter(RecyclerView.Adapter mAdapter) {
            super();
            this.mAdapter = mAdapter;
        }
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            mValues.addAll(machinesFilter);
            machinesFilter.clear();
            final FilterResults results = new FilterResults();
            if (charSequence.length() == 0) {
                machinesFilter.addAll(mValues);
            } else {
                final String filterPattern = charSequence.toString().toLowerCase().trim();
                for (PlaceholderContent.Machine p : mValues) {
                    if (p.getReference().toLowerCase().startsWith(filterPattern)) {
                        machinesFilter.add(p);
                        mAdapter.notifyItemInserted(machinesFilter.size());

                    }
                }
//                mAdapter..clear();
//                mAdapter.notifyDataSetChanged();
//                mAdapter.getDataAdapter.addAll((ArrayList<MainActivity.Radios>) results.values);
//                mAdapter.notifyDataSetChanged();
            }
            results.values = machinesFilter;
            results.count = machinesFilter.size();
            return results;
        }
        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            machinesFilter = (List<PlaceholderContent.Machine>) filterResults.values;
            this.mAdapter.notifyDataSetChanged();
        }
    }

}