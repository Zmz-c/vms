package com.edu.vms;

import cn.dev33.satoken.stp.StpInterface;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Role implements StpInterface {
    /**
     * @param o
     * @return
     */
    @Override
    public List<String> getPermissionList(Object loginId, String loginType) {
        List<String> list = new ArrayList<>();
        list.add("101");
        list.add("/upnews");
        list.add("/addNew");
        list.add("/delNews");
        list.add("/editNews");
        list.add("/edittz");
        list.add("/deltz");
        list.add("/uptz");
        list.add("/addtz");
        list.add("/editzc");
        list.add("/delzc");
        list.add("/upzc");
        list.add("/addzc");
        list.add("/admin");
        return list;
    }

    /**
     * @param o
     */
    @Override
    public List<String> getRoleList(Object o, String s) {
        List<String> list = new ArrayList<>();
        list.add("admin");
        list.add("super-admin");
        list.add("adminLogin");
        return list;
    }
}
