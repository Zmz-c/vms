package com.edu.vms.Controller;
import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.stp.StpUtil;
import com.edu.vms.Entity.User;
import com.edu.vms.Impl.Userimpl;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Controller
public class userController {
    @Autowired
    private Userimpl user;

    @RequestMapping("/regedit")
    public String regedit(){
        return "reg";
    }

    //志愿者注册逻辑
    @RequestMapping("/adduser")
    @ResponseBody
    public String adduser(String phoneName,String sex,String password,String username,String zyz){
        User user1 = new User();
        user1.setZyz(zyz);
        user1.setSex(sex);
        user1.setPassword(password);
        user1.setUsername(username);
        user1.setPhoneName(phoneName);
        user.save(user1);
        return "添加成功";
    }

    //志愿者列表
    @RequestMapping("readZyz")
    @ResponseBody
    public Map<String, Object> getzyz(){
        Iterable<User> user1 = user.findAll();
        Map<String,Object> map =new HashMap<>();
        map.put("data",user1);
        map.put("code",0);
        return map;
    }

    //删除志愿者
    @SaCheckRole("admin")
    @RequestMapping("/delzyz")
    @ResponseBody
    public String delzyz(String id){
        if(!StpUtil.isLogin()){
            System.out.print("请登录");
            return "跳转中";
        }else {
            user.deleteById(Long.valueOf(id));
        }
        return "成功";
    }

    //修改志愿者密码
    @SaCheckRole("admin")
    @RequestMapping("/editpassword")
    @ResponseBody
    public Map<String, Object> editpassword(String password, HttpServletResponse response, String id) throws IOException, InterruptedException {
        if(!StpUtil.isLogin()){
            System.out.print("请登录");
            Thread.sleep(5000);
            response.sendRedirect("/index");
        }else {
            Optional<User> editzyz;
            editzyz = user.findById(Long.valueOf(id));
            editzyz.ifPresent(zyzText1 -> {
                zyzText1.setPassword(password);
                user.save(zyzText1);
            });
        }
        Optional<User> user1 = user.findById(Long.valueOf(id));
        Map<String,Object> map =new HashMap<>();
        map.put("data",user1);
        return map;


    }
 //登录逻辑
    @RequestMapping("/zyzlog")
    public String zyzlog(){
        return "zyzlogin";
    }

}
