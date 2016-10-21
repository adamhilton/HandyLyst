package net.adamhilton.handylyst.data.local;


import net.adamhilton.handylyst.data.model.List;

public interface ListRepoContract {
    java.util.List<List> getAll();
    java.util.List<List> create(List list);
}
