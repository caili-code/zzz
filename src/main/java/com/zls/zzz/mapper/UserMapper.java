package com.zls.zzz.mapper;

import com.zls.zzz.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    public Boolean add(User user);
    public Boolean del(int id);
    public Boolean edit(User user);
    public User findAll();
    public User findOne(int id);
}
