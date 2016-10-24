package net.adamhilton.handylyst.ui.edit;

import net.adamhilton.handylyst.data.model.List;

public class EditScreenContract {

    public interface View {
        void goBack();
        void addItemToList(String item);
        void removeListItem(int position);
    }

    public interface Presenter {
        void createList(List list);
        void addListItem();
        void deleteItem(List list, int position);
    }
}
