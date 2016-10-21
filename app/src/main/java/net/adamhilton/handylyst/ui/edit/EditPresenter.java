package net.adamhilton.handylyst.ui.edit;

import net.adamhilton.handylyst.data.model.List;

public class EditPresenter implements EditScreenContract.Presenter {

    private EditScreenContract.View view;

    public EditPresenter(EditScreenContract.View view) {
        this.view = view;
    }

    @Override
    public void CreateList(List list) {
        view.GoBack();
    }
}
