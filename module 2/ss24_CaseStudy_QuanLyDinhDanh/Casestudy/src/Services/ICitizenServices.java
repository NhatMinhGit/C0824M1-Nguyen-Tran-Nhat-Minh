package Services;

import Models.Entities.Citizens;

import java.util.List;

public interface ICitizenServices <T extends Citizens> {
    List<T> getAll();
    void save(T t);
    void remove(String id);
    void update(String id, T t);

    T findById(String id);

}
