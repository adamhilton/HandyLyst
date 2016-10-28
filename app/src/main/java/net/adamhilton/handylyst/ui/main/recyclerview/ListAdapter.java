package net.adamhilton.handylyst.ui.main.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.adamhilton.handylyst.R;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListViewHolder> {

    private List<net.adamhilton.handylyst.data.model.List> lists;

    public ListAdapter(List<net.adamhilton.handylyst.data.model.List> lists) {
        this.lists = lists;
    }

    @Override
    public ListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list, parent, false);

        ListViewHolder viewHolder = new ListViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ListViewHolder holder, int position) {
        holder.name.setText(lists.get(position).Name);
    }

    @Override
    public int getItemCount() {
        return lists.size();
    }
}
