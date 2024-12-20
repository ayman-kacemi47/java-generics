package ma.en7.service;

import java.util.List;

public interface IMetier <T> {
    public  void add(T o);
    public List<T> getAll();
    public T findById(int id);
    public  void delete(long id);
}
