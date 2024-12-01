package model.dao;

import java.util.List;

public interface InterfaceDAO<T> {
    
    public abstract void create(T objeto);
    public abstract List<T> retrieve();
    public abstract T retrieve(int pk);
    public abstract List<T> retrieve(String parametro, String atributo);
    public abstract void update(T objeto);
    
}
