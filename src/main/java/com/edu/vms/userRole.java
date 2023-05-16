package com.edu.vms;

import cn.dev33.satoken.stp.StpInterface;

import java.util.ArrayList;
import java.util.List;

public class userRole implements StpInterface {
    /**
     * @param o
     * @param s
     * @return
     */
    @Override
    public List<String> getPermissionList(Object o, String s) {
        List<String> list = new ArrayList<>();
        list.add("1001");
        list.add("/admin");
        list.add("/readVM");
        return list;
    }

    /**
     * @param o
     * @param s
     * @return
     */
    @Override
    public List<String> getRoleList(Object o, String s) {
        List<String> list = new ArrayList<>();
        list.add("user");
        return list;
    }
}
