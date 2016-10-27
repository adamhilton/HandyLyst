package net.adamhilton.handylyst.ui.edit;

import net.adamhilton.handylyst.data.local.InMemoryListRepo;
import net.adamhilton.handylyst.data.local.ListRepoContract;
import net.adamhilton.handylyst.data.model.List;

public class EditPresenter implements EditScreenContract.Presenter {

    private EditScreenContract.View view;
    private ListRepoContract listRepo;

    public EditPresenter(EditScreenContract.View view) {
        this.view = view;
        listRepo = InMemoryListRepo.getInstance();
    }

    @Override
    public void createList(List list) {
        listRepo.create(list);
        view.goBack();
    }

    @Override
    public void updateList(List list) {
        listRepo.update(list);
        view.goBack();
    }

    @Override
    public void addListItem() {
        view.addItemToList("an item...");
    }

    @Override
    public void deleteItem(List list, int position) {
        list.removeItem(position);
        view.removeListItem(position);
    }
}
