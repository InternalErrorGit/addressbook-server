package ch.zli.m223.addressbook.controller;

import java.util.List;

/**
 * @author P. Gatzka
 * @version 23.09.2021
 * Project: addressbookserver
 */
public abstract class AbstractController<T> {
    public abstract T create(T entity);
    public abstract void delete(Long id);
    public abstract List<T> findAll();
    public abstract T find(Long id);
}
