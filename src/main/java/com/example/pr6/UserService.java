package com.example.pr6;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final EntityManager entityManager;
    @Transactional
    public UserEntity createUser(String firstName, String lastName, String email) {
        UserEntity user = new UserEntity();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        return entityManager.merge(user);
    }

    @Transactional
    public UserEntity getUserById(int id) {
        return entityManager.find(UserEntity.class, id);
    }

//    @Transactional
//    public List<UserEntity> findAllUsers() {
//        return entityManager.createQuery("FROM UserEntity", UserEntity.class).getResultList();
//    }

    @Transactional
    public List<UserEntity> findAllUsers() {
        return entityManager.createNamedQuery(UserEntity.FIND_ALL,
                UserEntity.class).getResultList();
    }

    public List<UserEntity> findByName(String name) {
        return entityManager.createNamedQuery(UserEntity.FIND_BY_NAME, UserEntity.class)
                .setParameter("last_name", name)
                .getResultList();
    }

    @Transactional
    public List<UserEntity> findAUsers(final String word) {
        return entityManager.createNamedQuery(
                UserEntity.FIND_BY_CONTAINIG_IN_LAST_OR_FIRST_NAME,
                UserEntity.class)
                .setParameter("word", word)
                .getResultList();
    }

//    public List<UserEntity> findSmithUsers(){
//        return entityManager.createQuery("FROM UserEntity WHERE last_name = 'Smith'", UserEntity.class).getResultList();
//    }
//
//    public List<UserEntity> findAUsers(){
//        return entityManager.createQuery("FROM UserEntity WHERE last_name LIKE '%a%' OR first_name LIKE '%a%'", UserEntity.class).getResultList();
//    }
}
