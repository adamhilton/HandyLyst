package net.adamhilton.handylyst.ui.edit;

import net.adamhilton.handylyst.data.model.List;

public class EditScreenContract {

    public interface View {

        void GoBack();
        void showListItems(List listItems);
    }

    public interface Presenter {

        void CreateList(List list);
        void RetrieveListItems();
    }
}
