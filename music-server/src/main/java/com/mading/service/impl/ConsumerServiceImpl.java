package com.mading.service.impl;

import com.mading.dao.ConsumerMapper;
import com.mading.pojo.Consumer;
import com.mading.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsumerServiceImpl implements ConsumerService {
    @Autowired
    private ConsumerMapper consumerMapper;

    @Override
    public boolean verifypassword(String username, String password) {
        return consumerMapper.verifyPassword(username , password)>0?true:false;
    }

    @Override
    public List<Consumer> loginStatus(String username) {
        return consumerMapper.loginStatus(username);
    }

    @Override
    public List<Consumer> userOfId(Integer id) {
        return consumerMapper.userOfId(id);
    }

    @Override
    public boolean updateUserMsg(Consumer consumer) {
        return consumerMapper.updateUserMsg(consumer) >0 ?true:false;
    }

    @Override
    public boolean addUser(Consumer consumer) {
        return consumerMapper.insertSelective(consumer) >0 ?true:false;
    }

}
