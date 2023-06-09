package com.staryy.teamSystem.interfaces;

public interface ServiceInterface<T> {
    void save(T t);

    void update(T t);

    void delete(T t);

    Iterable<T> getAll();

}
