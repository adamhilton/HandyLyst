package net.adamhilton.handylyst.ui.edit.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.adamhilton.handylyst.R;
import net.adamhilton.handylyst.data.model.List;

public class ListItemAdapter extends RecyclerView.Adapter<ListItemViewHolder> {

    private List list;

    public ListItemAdapter(List list) {
        this.list = list;
    }

    @Override
    public ListItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);

        ListItemViewHolder viewHolder = new ListItemViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ListItemViewHolder holder, int position) {
        holder.item.setText(list.getItems().get(position));
    }

    @Override
    public int getItemCount() {
        return list.getItems().size();
    }
}
