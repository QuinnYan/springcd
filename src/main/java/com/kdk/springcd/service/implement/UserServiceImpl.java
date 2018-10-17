package com.kdk.springcd.service.implement;
import com.kdk.springcd.entity.UserInfo;
import com.kdk.springcd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Null;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public UserInfo GetUser(String user_id){

        UserInfo userInfo = new UserInfo();

        Map<String,Object> map = jdbcTemplate.queryForMap("select * from user_info where user_id = ? " ,user_id);

        userInfo.setUserID(map.get("user_id").toString());
        userInfo.setPassword(map.get("user_pwd").toString());


        return userInfo;
    }

    @Override
    public void verifyAccount(String user_id, String user_pwd){
        String sql = "select * from user_info where user_id= ? and user_pwd= ?;";

        Map<String,Object> map = jdbcTemplate.queryForMap(sql,user_id,user_pwd);

    }

    @Override
    public void addUser(String user_id, String user_pwd){
        String sql = "insert into user_info (user_id, user_pwd) values(?,?)";
        jdbcTemplate.update(sql,user_id,user_pwd);
    }

    @Override
    public void updatePwd(String user_id, String user_pwd){
        String sql = "update  user_info set user_pwd = ? where user_id = ?";
        jdbcTemplate.update(sql,user_pwd,user_id);
    }
    @Override
    public void delUser(String user_id){
        String sql = "delete  from user_info  where user_id = ?";
        jdbcTemplate.update(sql,user_id);
    }

}
