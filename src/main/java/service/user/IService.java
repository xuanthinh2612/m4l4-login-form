package service.user;

import java.util.List;

public interface IService<T> {
    List<T> findAll();

}
