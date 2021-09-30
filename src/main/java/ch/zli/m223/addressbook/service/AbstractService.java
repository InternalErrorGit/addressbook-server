package ch.zli.m223.addressbook.service;

import javax.ws.rs.NotAllowedException;
import java.util.List;

/**
 * @author P. Gatzka
 * @version 23.09.2021
 * Project: addressbookserver
 */
public abstract class AbstractService<T> {
    public abstract T create(T entity);

    public abstract void delete(Long id);

    public abstract List<T> findAll();

    public abstract T find(Long id);

    public T update(T entity) {
        throw new NotAllowedException("Cannot update User");
    }
}
