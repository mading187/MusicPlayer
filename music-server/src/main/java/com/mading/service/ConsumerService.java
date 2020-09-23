package com.mading.service;

import com.mading.pojo.Consumer;

import java.util.List;

public interface ConsumerService {
    boolean verifypassword(String username, String password);

    List<Consumer> loginStatus(String username);

    List<Consumer> userOfId(Integer id);

    boolean updateUserMsg(Consumer consumer);

    boolean addUser(Consumer consumer);
}
