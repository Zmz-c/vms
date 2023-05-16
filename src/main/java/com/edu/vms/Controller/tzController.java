package com.edu.vms.Controller;

import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.stp.StpUtil;
import com.edu.vms.Entity.tz;
import com.edu.vms.Impl.tzimpl;
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
public class tzController {
    @Autowired
    private tzimpl tzs;
    //添加通知
    @SaCheckRole("admin")
    @RequestMapping("/addtz")
    @ResponseBody
    public String addtz(String tzText, String tzTitle, String tzAuthor) throws InterruptedException {
        if(!StpUtil.isLogin()){
            System.out.print("请登录");
            Thread.sleep(5000);
            return  "/index";
        }else {
            tz edittz = new tz();
            edittz.setTzAuthor(tzAuthor);
            edittz.setTzTitle(tzTitle);
            edittz.setTzText(tzText);
            tzs.save(edittz);
            return "1";
        }
    }
    //修改通知
    @SaCheckRole("admin")
    @RequestMapping("/edittz")
    @ResponseBody
    public Map<String, Object> edittz(String tzText, HttpServletResponse response, String id) throws IOException, InterruptedException {
        if(!StpUtil.isLogin()){
            System.out.print("请登录");
            Thread.sleep(5000);
            response.sendRedirect("/index");
        }else {
            Optional<tz> edittz;
            edittz = tzs.findById(Long.valueOf(id));
            System.out.printf("通知内容为:",tzText);
            edittz.ifPresent(tzText1 -> {
                tzText1.setTzText(tzText);
                tzs.save(tzText1);
            });
        }
        Optional<tz> etz = tzs.findById(Long.valueOf(id));
        Map<String,Object> map =new HashMap<>();
        map.put("data",etz);
        return map;
    }

    //删除通知
    @SaCheckRole("admin")
    @RequestMapping("/deltz")
    @ResponseBody
    public String deltz(String id){
        if(!StpUtil.isLogin()){
            System.out.print("请登录");
            return "跳转中";
        }else {
            System.out.print("该方法被调用");
            tzs.deleteById(Long.valueOf(id));
        }
        return "成功";
    }

    //读取通知
    @RequestMapping("readtz")
    @ResponseBody
    public Map<String, Object> getNews(){
        Iterable<tz> Tz = tzs.findAll();
        Map<String,Object> map =new HashMap<>();
        map.put("data",Tz);
        map.put("code",0);
        return map;
    }

    @RequestMapping("/uptz")
    @SaCheckRole("admin")
    public String upnews(HttpServletResponse response) throws InterruptedException, IOException {
        if(!StpUtil.isLogin()){
            System.out.print("请登录");
            Thread.sleep(5000);
            response.sendRedirect("/index");
            return "1";
        }else {
            return "tzadd";
        }
    }

}
