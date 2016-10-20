package net.adamhilton.handylyst.ui.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import net.adamhilton.handylyst.R;
import net.adamhilton.handylyst.data.model.List;
import net.adamhilton.handylyst.ui.main.recyclerview.ListAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainScreenContract.View{

    @BindView(R.id.list_recycler_view)
    RecyclerView list_recycler_view;

    private ListAdapter listAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private MainScreenContract.Presenter presenter = new MainPresenter(this);

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initializeView();
    }

    private void initializeView() {

        layoutManager = new LinearLayoutManager(this);
        list_recycler_view.setLayoutManager(layoutManager);

        presenter.retrieveViewResults();
    }

    @Override
    public void showViewResults(java.util.List<List> list) {
        listAdapter = new ListAdapter(list);
        list_recycler_view.setAdapter(listAdapter);
    }
}
