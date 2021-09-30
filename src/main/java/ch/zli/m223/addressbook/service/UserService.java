package ch.zli.m223.addressbook.service;

import ch.zli.m223.addressbook.entity.User;

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
public class UserService extends AbstractService<User> {

    @Inject
    EntityManager entityManager;

    @Override
    @Transactional
    public User create(User entity) {
        entityManager.persist(entity);
        return entity;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        entityManager.remove(entityManager.find(User.class, id));
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> findAll() {
        return entityManager.createQuery("SELECT u FROM User u").getResultList();
    }

    @Override
    public User find(Long id) {
        return entityManager.find(User.class, id);
    }

    public User find(User user) {
        var query = entityManager.createQuery("FROM User where username = :username AND password = :password");
        query.setParameter("username", user.getUsername());
        query.setParameter("password", user.getPassword());
        return (User) query.getSingleResult();
    }
}
