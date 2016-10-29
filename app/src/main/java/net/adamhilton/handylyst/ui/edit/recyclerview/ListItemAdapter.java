package net.adamhilton.handylyst.ui.edit.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import net.adamhilton.handylyst.R;
import net.adamhilton.handylyst.data.model.List;
import net.adamhilton.handylyst.data.model.RealmString;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListItemAdapter extends RecyclerView.Adapter<ListItemAdapter.ListItemViewHolder> {

    private List list;
    private java.util.List<ButtonClickEventListener> listeners = new ArrayList<>();

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
    public void onBindViewHolder(ListItemViewHolder holder, final int position) {
        holder.editTextListener.updatePosition(position);
        holder.item.setText(list.Items.get(position).value);

        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(ButtonClickEventListener listener : listeners) {
                    listener.deleteButtonClicked(position);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.Items.size();
    }

    public void subscribeEventListener(ButtonClickEventListener listener) {
        listeners.add(listener);
    }

    public void unsubscribeEventListener(ButtonClickEventListener listener) {
        listeners.remove(listener);
    }

    public static class ListItemViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.list_item_text)
        EditText item;

        @BindView(R.id.delete_list_item_button)
        Button delete;

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
            list.Items.set(position, RealmString.valueOf(charSequence.toString()));
        }

        @Override
        public void afterTextChanged(Editable editable) {
        }
    }

    public interface ButtonClickEventListener {
        void deleteButtonClicked(int position);
    }
}
