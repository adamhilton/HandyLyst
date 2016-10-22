package net.adamhilton.handylyst.ui.edit.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import net.adamhilton.handylyst.R;
import net.adamhilton.handylyst.data.model.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListItemAdapter extends RecyclerView.Adapter<ListItemAdapter.ListItemViewHolder> {

    private List list;

    public ListItemAdapter(List list) {
        this.list = list;
    }

    @Override
    public ListItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);

        ListItemViewHolder viewHolder = new ListItemViewHolder(view, new EditTextListener());
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ListItemViewHolder holder, int position) {
        holder.editTextListener.updatePosition(holder.getAdapterPosition());
        holder.item.setText(list.getItems().get(position));
    }

    @Override
    public int getItemCount() {
        return list.getItems().size();
    }

    public static class ListItemViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.list_item_text)
        EditText item;

        EditTextListener editTextListener;

        public ListItemViewHolder(View itemView, EditTextListener listener) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            this.editTextListener = listener;
            this.item.addTextChangedListener(listener);
        }
    }

    private class EditTextListener implements TextWatcher {
        private int position;

        public void updatePosition(int position) {
            this.position = position;
        }

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            list.setItem(position, charSequence.toString());
        }

        @Override
        public void afterTextChanged(Editable editable) {
        }
    }
}
