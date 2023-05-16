package com.edu.vms.Controller;

import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.stp.StpUtil;
import com.edu.vms.Entity.New;
import com.edu.vms.Impl.Newimpl;
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
public class newController {
    @Autowired
    private Newimpl NewText;

    @RequestMapping("/editNews")
    @ResponseBody
    @SaCheckRole("admin")
    public Map<String, Object> editNews(String newText, HttpServletResponse response, String id) throws IOException, InterruptedException {
        if(!StpUtil.isLogin()){
            System.out.print("请登录");
            Thread.sleep(5000);
            response.sendRedirect("/index");
        }else {
            Optional<New> editnew;
            editnew = NewText.findById(Long.valueOf(id));
            editnew.ifPresent(newsText1 -> {
                newsText1.setNewText(newText);
                NewText.save(newsText1);
            });
        }
        Optional<New> eNews = NewText.findById(Long.valueOf(id));
        Map<String,Object> map =new HashMap<>();
        map.put("data",eNews);
        return map;
    }


    @RequestMapping("/delNews")
    @ResponseBody
    @SaCheckRole("admin")
    public String delNews(String id){
        if(!StpUtil.isLogin()){
            System.out.print("请登录");
            return "跳转中";
        }else {
            System.out.print("该方法被调用");
            NewText.deleteById(Long.valueOf(id));
        }

        return "成功";
    }
    @RequestMapping("/upnews")
    public String upnews(HttpServletResponse response) throws InterruptedException, IOException {
        if(!StpUtil.isLogin()){
            System.out.print("请登录");
            Thread.sleep(5000);
            response.sendRedirect("/index");
            return "1";
        }else {
            return "newsaadd";
        }
    }
    @RequestMapping("readNews")
    @ResponseBody
    public Map<String, Object> getNews(){
        Iterable<New> news = NewText.findAll();
        Map<String,Object> map =new HashMap<>();
        map.put("data",news);
        map.put("code",0);
        return map;
    }

    //添加新闻
    @RequestMapping("/addNew")
    @ResponseBody
    @SaCheckRole("admin")
    public String addNews(String newText, String NewTitle, String NewAuthor,HttpServletResponse response) throws InterruptedException, IOException {
        if(!StpUtil.isLogin()){
            System.out.print("请登录");
            Thread.sleep(5000);
            response.sendRedirect("/index");
            return "1";
        }else {
            New editnew = new New();
            editnew.setNewAuthor(NewAuthor);
            System.out.print(newText);
            editnew.setNewText(newText);
            editnew.setNewTitle(NewTitle);
            NewText.save(editnew);
            System.out.print("该方法被调用");
            return "1";
        }
    }
}
