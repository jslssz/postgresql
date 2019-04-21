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

    @RequestMapping("/psql/get")
    @ResponseBody
    public Object getAll(){
        List<Users> list=mapper.getAll();
        return list;
    }

}
