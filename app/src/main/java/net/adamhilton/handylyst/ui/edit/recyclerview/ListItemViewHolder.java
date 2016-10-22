package net.adamhilton.handylyst.ui.edit.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import net.adamhilton.handylyst.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListItemViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.list_item_text)
    EditText item;

    public ListItemViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
