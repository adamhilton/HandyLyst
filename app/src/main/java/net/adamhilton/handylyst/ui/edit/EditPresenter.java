package net.adamhilton.handylyst.ui.edit;

import net.adamhilton.handylyst.data.local.ListRepo;
import net.adamhilton.handylyst.data.local.ListRepoContract;
import net.adamhilton.handylyst.data.model.List;

public class EditPresenter implements EditScreenContract.Presenter {

    private EditScreenContract.View view;
    private ListRepoContract listRepo;

    public EditPresenter(EditScreenContract.View view) {
        this.view = view;
        listRepo = ListRepo.getInstance();
    }

    @Override
    public void CreateList(List list) {
        if(list.getId() == 0) {
            listRepo.create(list);
        } else {
            listRepo.update(list);
        }

        view.GoBack();
    }

    @Override
    public void AddListItem() {
        view.AddItemToList("an item...");
    }
}
