package net.adamhilton.handylyst.ui.main;

import java.util.List;

public class MainScreenContract {

    public interface View {
        void showViewResults(List<net.adamhilton.handylyst.data.model.List> lists);
    }

    public interface Presenter {
        void retrieveViewResults();
    }

}
