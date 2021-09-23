package ch.zli.m223.addressbook.service;

import ch.zli.m223.addressbook.entity.City;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

/**
 * @author P. Gatzka
 * @version 23.09.2021
 * Project: addressbookserver
 */
public class CityService extends AbstractService<City> {

    @Inject
    EntityManager entityManager;

    @Override
    @Transactional
    public City create(City entity) {
        entityManager.persist(entity);
        return entity;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        entityManager.remove(entityManager.find(City.class, id));
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<City> findAll() {
        return entityManager.createQuery("SELECT c FROM City c").getResultList();
    }

    @Override
    public City find(Long id) {
        return entityManager.find(City.class, id);
    }
}
