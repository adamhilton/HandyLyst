package net.adamhilton.handylyst.data.local;


import net.adamhilton.handylyst.data.model.List;

public interface ListRepo {
    java.util.List<List> getAll();
    List getById(int id);
    void create(List list);
    void update(List list);
    void delete(List list);
}
