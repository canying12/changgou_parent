package com.changgou.system.service;

import com.changgou.pojo.Admin;

public interface AdminService {
    /**
     * 增加
     * @param admin
     */
    public void add(Admin admin);

    /**
     * 登录验证密码
     * @param admin
     * @return
     */
    boolean login(Admin admin);
}
