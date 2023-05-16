package com.edu.vms.Controller;

import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.stp.StpUtil;
import com.edu.vms.Entity.zc;
import com.edu.vms.Impl.zcimpl;
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
public class zcController {
    @Autowired
    private zcimpl zcs;

    //添加政策
    @SaCheckRole("admin")
    @RequestMapping("/addzc")
    @ResponseBody
    public String addzc(String zcText, String zcTitle, String zcAuthor) throws InterruptedException {
        if(!StpUtil.isLogin()){
            System.out.print("请登录");
            Thread.sleep(5000);
            return  "/index";
        }else {
            zc editzc = new zc();
            editzc.setZcAuthor(zcAuthor);
            editzc.setZcTitle(zcTitle);
            editzc.setZcText(zcText);
            zcs.save(editzc);
            System.out.print("该方法被调用");
            return "1";
        }
    }
    //修改政策
    @SaCheckRole("admin")
    @RequestMapping("/editzc")
    @ResponseBody
    public Map<String, Object> editzc(String zcText, HttpServletResponse response, String id) throws IOException, InterruptedException {
        if(!StpUtil.isLogin()){
            System.out.print("请登录");
            Thread.sleep(5000);
            response.sendRedirect("/index");
        }else {
            Optional<zc> editzc;
            editzc = zcs.findById(Long.valueOf(id));
            System.out.printf("通知内容为:",zcText);
            editzc.ifPresent(zcText1 -> {
                zcText1.setZcText(zcText);
                zcs.save(zcText1);
            });
        }
        Optional<zc> ezc = zcs.findById(Long.valueOf(id));
        Map<String,Object> map =new HashMap<>();
        map.put("data",ezc);
        return map;
    }

    //删除政策
    @SaCheckRole("admin")
    @RequestMapping("/delzc")
    @ResponseBody
    public String delzc(String id){
        if(!StpUtil.isLogin()){
            System.out.print("请登录");
            return "跳转中";
        }else {
            zcs.deleteById(Long.valueOf(id));
        }
        return "成功";
    }

    //读取政策文件
    @RequestMapping("readzc")
    @ResponseBody
    public Map<String, Object> getzc(){
        Iterable<zc> zc = zcs.findAll();
        Map<String,Object> map =new HashMap<>();
        map.put("data",zc);
        map.put("code",0);
        return map;
    }

    @RequestMapping("/upzc")
    @SaCheckRole("admin")
    public String upnews(HttpServletResponse response) throws InterruptedException, IOException {
        if(!StpUtil.isLogin()){
            System.out.print("请登录");
            Thread.sleep(5000);
            response.sendRedirect("/index");
            return "1";
        }else {
            return "zcadd";
        }
    }

}
