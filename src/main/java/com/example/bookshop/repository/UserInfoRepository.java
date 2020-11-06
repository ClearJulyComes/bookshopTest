package com.example.bookshop.repository;

import com.example.bookshop.model.UserInfo;

public interface UserInfoRepository {
    UserInfo findByUsername (String name);
}
