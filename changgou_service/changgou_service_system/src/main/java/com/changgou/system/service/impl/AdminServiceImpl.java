package com.changgou.system.service.impl;

import com.changgou.pojo.Admin;
import com.changgou.system.mapper.AdminMapper;
import com.changgou.system.service.AdminService;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;
    /**
     * 增加
     * @param admin
     */
    @Override
    public void add(Admin admin) {
        String password = BCrypt.hashpw(admin.getPassword(), BCrypt.gensalt());
        admin.setPassword(password);
        adminMapper.insert(admin);
    }

    /**
     * 登录验证密码
     * @param admin
     * @return
     */
    @Override
    public boolean login(Admin admin) {
        //根据登录名查询管理员
        Admin admin1 = new Admin();
        admin1.setLoginName(admin.getLoginName());
        admin1.setStatus("1");

        Admin admin2 = adminMapper.selectOne(admin1);//数据库查询出的对象
        if (admin2 == null){
            return false;
        }else {
            return BCrypt.checkpw(admin.getPassword(),admin2.getPassword());
        }
    }
}
