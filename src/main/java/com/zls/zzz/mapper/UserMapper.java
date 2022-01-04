package com.zls.zzz.mapper;

import com.zls.zzz.entity.Hilist_b;
import com.zls.zzz.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.Mapping;

import java.util.List;

//@Repository
@Mapper
public interface UserMapper {
    @Insert("insert into  User   (name,age) values (#{name},#{age})")
     Boolean add(User user);

     Boolean del(int id);

     Boolean edit(User user);

     @Select("select * from user")
     List<User> findAll();

     User findOne(int id);

     @Select("SELECT  hilist_code as hilistCode  FROM HILIST_B  WHERE  " +
             "INSU_ADMDVS = '610400' " +
             "and LIST_TYPE ='301' and VALI_FLAG ='1' and HILIST_CODE in(#{hilistCode});")
     Hilist_b find27dmbyhilist_b(String  hc27dm);
}
