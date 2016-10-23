package net.adamhilton.handylyst.ui.main;

import net.adamhilton.handylyst.data.local.ListRepoContract;

import java.util.List;

public class MainPresenter implements MainScreenContract.Presenter {

    private MainScreenContract.View view;
    private ListRepoContract listRepo;

    public MainPresenter(MainScreenContract.View view, ListRepoContract listRepo) {
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
