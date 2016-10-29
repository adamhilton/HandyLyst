package net.adamhilton.handylyst.ui.edit;

import net.adamhilton.handylyst.data.local.ListRepo;
import net.adamhilton.handylyst.data.model.List;

public class EditPresenter implements EditScreenContract.Presenter {

    private EditScreenContract.View view;
    private ListRepo listRepo;

    public EditPresenter(EditScreenContract.View view, ListRepo listRepo) {
        this.view = view;
        this.listRepo = listRepo;
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
        list.Items.remove(position);
        view.removeListItem(position);
    }
}
