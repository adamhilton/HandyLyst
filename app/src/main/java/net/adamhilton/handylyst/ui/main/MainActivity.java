package net.adamhilton.handylyst.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import net.adamhilton.handylyst.HandyLystApp;
import net.adamhilton.handylyst.R;
import net.adamhilton.handylyst.data.local.ListRepoContract;
import net.adamhilton.handylyst.data.model.List;
import net.adamhilton.handylyst.ui.base.BaseActivity;
import net.adamhilton.handylyst.ui.edit.EditActivity;
import net.adamhilton.handylyst.ui.main.recyclerview.ListAdapter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements MainScreenContract.View {

    @BindView(R.id.list_recycler_view)
    RecyclerView list_recycler_view;

    private ListAdapter listAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private MainScreenContract.Presenter presenter;

    @Inject
    ListRepoContract listRepo = HandyLystApp.getListRepo();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityComponent().inject(this);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        presenter = new MainPresenter(this, listRepo);
        initializeView();
    }

    @Override
    protected void onPause() {
        super.onPause();
        presenter = null;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_create:
                startEditActivity();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void showViewResults(java.util.List<List> list) {
        listAdapter = new ListAdapter(list);
        list_recycler_view.setAdapter(listAdapter);
    }

    private void initializeView() {
        layoutManager = new LinearLayoutManager(this);
        list_recycler_view.setLayoutManager(layoutManager);

        presenter.retrieveViewResults();
    }

    private void startEditActivity() {
        Intent intent = new Intent(this, EditActivity.class);
        intent.putExtra(EditActivity.EXTRA_IS_NEW_LIST, true);
        startActivity(intent);
    }
}
