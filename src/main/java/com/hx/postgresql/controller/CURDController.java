package com.hx.postgresql.controller;

import com.hx.postgresql.bean.table.Users;
import com.hx.postgresql.dao.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created  on 2019/04/21.
 */
@Controller
public class CURDController {

    @Autowired
    private UsersMapper mapper;

    @RequestMapping("/psql/update")
    @ResponseBody
    public Object update() {
        Users user=new Users();
        user.setId(10);
        user.setScore(39.9F);
        int res = mapper.updateByPrimaryKeySelective(user);
        return res == 1 ? "success" : "failure";
    }



    @RequestMapping("/psql/del")
    @ResponseBody
    public Object del() {
        int res = mapper.deleteByPrimaryKey(11);
        return res == 1 ? "success" : "failure";
    }



    @RequestMapping("/psql/get")
    @ResponseBody
    public Object getAll(){
        List<Users> list=mapper.getAll();
        return list;
    }

    @RequestMapping("/psql/insert")
    @ResponseBody
    public Object insert(){
        Users users=new Users();
        users.setId(13);
        users.setTeam("火箭");
        users.setPlayer("姚明");
        users.setScore(39.0f);
        try {
            mapper.insert(users);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "failure";
        }
    }

}
