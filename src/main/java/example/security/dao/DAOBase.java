package example.security.dao;

import java.util.Collection;

public interface DAOBase <T> {
    void create(T var1);

    void update(T var1);

    T delete(int var1);

    T findById(int var1);

    Collection<T> list();
}
