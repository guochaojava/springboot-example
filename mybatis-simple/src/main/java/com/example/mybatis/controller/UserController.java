package com.example.mybatis.controller;

import com.example.mybatis.dao.UserDao;
import com.example.mybatis.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author GuoChao.
 * @since
 */
@RestController
public class UserController {

    @Autowired
    private UserDao dao;

    /**
     * 添加user
     *
     * @param user user信息
     * @return 操作结果
     */
    @PostMapping("/user")
    public Object insert(User user) {
        int result = dao.insert(user);

        if (result == 1) {
            return "insert success";
        } else {
            return "insert error";
        }
    }

    /**
     * 根据id删除user
     *
     * @param id 用户id
     * @return 操作结果
     */
    @DeleteMapping("/user/{id}")
    public Object delete(@PathVariable("id") Integer id) {
        int result = dao.delete(id);

        if (result == 1) {
            return "delete success";
        } else {
            return "delete error";
        }
    }

    /**
     * 根据id 更新user信息
     *
     * @param user 需要更新字段
     * @return 操作结果
     */
    @PutMapping("/user/{id}/{name}/{telephone}")
    public Object update(User user) {
        int result = dao.update(user);

        if (result == 1) {
            return "update success";
        } else {
            return "update error";
        }
    }

    /**
     * 根据id查询用户信息
     *
     * @param id 用户id
     * @return 查询结果
     */
    @GetMapping("/user/{id}")
    public Object getUserById(@PathVariable("id") Integer id) {
        User user = dao.getUserById(id);
        return user;
    }

    /**
     * 查询用户列表
     *
     * @return 查询结果
     */
    @GetMapping("/user")
    public Object list() {
        List<User> list = dao.list();
        return list;
    }

}