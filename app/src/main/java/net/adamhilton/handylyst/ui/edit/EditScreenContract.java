package net.adamhilton.handylyst.ui.edit;

import net.adamhilton.handylyst.data.model.List;

public class EditScreenContract {

    public interface View {

        void GoBack();
        void AddItemToList(String item);
    }

    public interface Presenter {

        void CreateList(List list);

        void AddListItem();
    }
}
