package net.adamhilton.handylyst.ui.edit;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;

import net.adamhilton.handylyst.R;
import net.adamhilton.handylyst.data.model.List;
import net.adamhilton.handylyst.ui.edit.recyclerview.ListItemAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class EditActivity extends AppCompatActivity implements EditScreenContract.View {

    private List list = new List();

    private ListItemAdapter listAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private EditPresenter presenter =  new EditPresenter(this);

    @BindView(R.id.edit_name_text)
    EditText name_text;
    @BindView(R.id.list_item_recycler_view)
    RecyclerView list_item_recycler_view;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        ButterKnife.bind(this);

        initializeView();
    }

    @OnClick(R.id.cancel)
    public void onCancelClicked() {
        super.onBackPressed();
    }

    @OnClick(R.id.save)
    public void onSaveClicked() {
        List list = new List();
        String name = String.valueOf(name_text.getText());
        list.setName(name);
        presenter.CreateList(list);
    }

    @Override
    public void GoBack() {
        super.onBackPressed();
    }

    private void initializeView() {

        layoutManager = new LinearLayoutManager(this);
        list_item_recycler_view.setLayoutManager(layoutManager);

        listAdapter = new ListItemAdapter(list);
        list_item_recycler_view.setAdapter(listAdapter);
    }
}
