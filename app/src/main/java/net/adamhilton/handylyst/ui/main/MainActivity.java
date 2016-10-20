package net.adamhilton.handylyst.ui.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import net.adamhilton.handylyst.R;
import net.adamhilton.handylyst.data.local.ListRepo;
import net.adamhilton.handylyst.ui.main.recyclerview.ListAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.list_recycler_view)
    RecyclerView list_recycler_view;

    private ListAdapter listAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initializeView();
    }

    private void initializeView() {

        layoutManager = new LinearLayoutManager(this);
        list_recycler_view.setLayoutManager(layoutManager);

        listAdapter = new ListAdapter(new ListRepo().getAll());
        list_recycler_view.setAdapter(listAdapter);
    }

}
