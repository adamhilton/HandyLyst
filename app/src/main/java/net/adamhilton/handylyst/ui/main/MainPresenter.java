package net.adamhilton.handylyst.ui.main;

import net.adamhilton.handylyst.data.local.ListRepo;

import java.util.List;

public class MainPresenter implements MainScreenContract.Presenter {

    private MainScreenContract.View view;

    public MainPresenter(MainScreenContract.View view) {
        this.view = view;
    }

    @Override
    public void retrieveViewResults() {

        List<net.adamhilton.handylyst.data.model.List> lists;
        lists = new ListRepo().getAll();
        view.showViewResults(lists);
    }
}
