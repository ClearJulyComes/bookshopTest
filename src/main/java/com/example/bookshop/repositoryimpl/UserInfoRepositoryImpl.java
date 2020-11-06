package com.example.bookshop.repositoryimpl;

import com.example.bookshop.model.UserInfo;
import com.example.bookshop.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

@Repository
public class UserInfoRepositoryImpl implements UserInfoRepository {

    @Autowired
    private EntityManager entityManager;

    @Override
    public UserInfo findByUsername(String name) {
        TypedQuery<UserInfo> query =
                entityManager.createQuery("SELECT u FROM UserInfo u WHERE u.username = :username", UserInfo.class);
        query.setParameter("username", name);
        return query.getSingleResult();
    }
}
