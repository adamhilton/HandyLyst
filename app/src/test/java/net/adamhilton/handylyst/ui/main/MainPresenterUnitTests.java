package net.adamhilton.handylyst.ui.main;

import net.adamhilton.handylyst.data.local.ListRepo;
import net.adamhilton.handylyst.data.model.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MainPresenterUnitTests {

    @Mock MainScreenContract.View view;
    @Mock ListRepo listRepo;

    private MainPresenter presenter;
    private java.util.List<List> lists;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.presenter = new MainPresenter(view, listRepo);
        this.lists = generateListList();
        when(listRepo.getAll())
                .thenReturn(this.lists);
    }

    @After
    public void cleanup() {
        this.presenter = null;
        this.lists = null;
    }

    @Test
    public void retrieveViewResults_callsShowViewResults() {
        presenter.retrieveViewResults();
        verify(view).showViewResults(lists);
    }

    private static java.util.List<List> generateListList() {
        java.util.List<List> lists = new ArrayList<>();
        for(int i = 0; i < 5; i++) {
            List list = new List();
            list.Name = String.format("My list #%s", i);
            lists.add(list);
        }
        return lists;
    }
}
