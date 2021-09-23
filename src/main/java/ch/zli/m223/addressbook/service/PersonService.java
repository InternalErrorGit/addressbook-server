package ch.zli.m223.addressbook.service;

import ch.zli.m223.addressbook.entity.Person;

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
public class PersonService extends AbstractService<Person> {

    @Inject
    EntityManager entityManager;

    @Override
    @Transactional
    public Person create(Person entity) {
        entityManager.persist(entity);
        return entity;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        entityManager.remove(entityManager.find(Person.class, id));
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Person> findAll() {
        return entityManager.createQuery("SELECT p FROM Person p").getResultList();
    }

    @Override
    public Person find(Long id) {
        return entityManager.find(Person.class, id);
    }
}
