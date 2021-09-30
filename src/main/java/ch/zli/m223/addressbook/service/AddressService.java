package ch.zli.m223.addressbook.service;

import ch.zli.m223.addressbook.entity.Address;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

/**
 * @author P. Gatzka
 * @version 23.09.2021
 * Project: addressbookserver
 */
@ApplicationScoped
public class AddressService extends AbstractService<Address> {

    @Inject
    EntityManager entityManager;

    @Override
    @Transactional
    public Address update(Address entity) {
        return entityManager.merge(entity);
    }

    @Override
    @Transactional
    public Address create(Address entity) {
        entityManager.persist(entity);
        return entity;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        entityManager.remove(entityManager.find(Address.class, id));
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Address> findAll() {
        return entityManager.createQuery("SELECT a FROM Address a").getResultList();
    }

    @Override
    public Address find(Long id) {
        return entityManager.find(Address.class, id);
    }
}
