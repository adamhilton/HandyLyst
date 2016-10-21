package net.adamhilton.handylyst.ui.edit;

public class EditPresenter implements EditScreenContract.Presenter {

    private EditScreenContract.View view;

    public EditPresenter(EditScreenContract.View view) {
        this.view = view;
    }
}
