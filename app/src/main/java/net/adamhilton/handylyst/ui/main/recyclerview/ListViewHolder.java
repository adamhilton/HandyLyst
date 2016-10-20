package net.adamhilton.handylyst.ui.main.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import net.adamhilton.handylyst.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListViewHolder extends RecyclerView.ViewHolder{

    @BindView(R.id.name)
    TextView name;

    public ListViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
