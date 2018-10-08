package com.kdk.springcd.service;
import com.kdk.springcd.entity.UserInfo;

public interface UserService {
    /**
     *获取用户信息
     * @param user_id
     * @return
     */
    UserInfo GetUser(String user_id);

    /**
     *注册用户
     * @param user_id
     * @param user_pwd
     * @return
     */
    void addUser(String user_id, String user_pwd);

    /**
     * 修改密码
     * @param user_id
     * @param user_pwd
     */
    void updatePwd(String user_id, String user_pwd);

    /**
     * 用户注销
     * @param user_id
     */
    void delUser(String user_id);

}
