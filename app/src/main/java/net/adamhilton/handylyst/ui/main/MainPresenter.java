package net.adamhilton.handylyst.ui.main;

import net.adamhilton.handylyst.data.local.ListRepo;

import java.util.List;

import javax.inject.Inject;

public class MainPresenter implements MainScreenContract.Presenter {

    private MainScreenContract.View view;
    private ListRepo listRepo;

    @Inject
    public MainPresenter(MainScreenContract.View view, ListRepo listRepo) {
        this.view = view;
        this.listRepo = listRepo;
    }

    @Override
    public void retrieveViewResults() {

        List<net.adamhilton.handylyst.data.model.List> lists;
        lists = listRepo.getAll();
        view.showViewResults(lists);
    }
}
