package model;

public interface CRUD<T> {
    void add(T dta,String key);
    boolean edit(T dta,String key);
    boolean delete(String key);
    T searchByNama(String key);
    T searchByMerk(String key);
}
