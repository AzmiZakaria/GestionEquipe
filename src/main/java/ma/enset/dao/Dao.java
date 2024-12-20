package ma.enset.dao;
import java.util.List;

public interface Dao<T> {
    List<T> findAll();
    T findById(long id);
    void save(T obj);
    void deleteById(long id);
    void update(T obj);
}
