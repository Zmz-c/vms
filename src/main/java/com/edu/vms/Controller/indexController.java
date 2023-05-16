package com.edu.vms.Controller;

import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.stp.StpUtil;
import com.edu.vms.Impl.*;
import com.edu.vms.StpUserUtil;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Controller
public class indexController {
    @Autowired
    private AdminUserimpl Admin;
    @Autowired
    private Userimpl user;
    @Autowired
    private zcimpl zc;
    @Autowired
    private Newimpl NewText;
    @Autowired
    private VMSUGimpl vmsuGimpl;


    @RequestMapping("/")
    public String index(Model model){
        //返回前端新闻1
        String newsAuthor1 = NewText.findById(1L).get().getNewAuthor();
        String newsText1 = NewText.findById(1L).get().getNewText();
        String newsTitle1 = NewText.findById(1L).get().getNewTitle();
        model.addAttribute("newsAuthor1",newsAuthor1);
        model.addAttribute("newsText1",newsText1);
        model.addAttribute("newsTitle1",newsTitle1);

        //返回前端新闻2
        String newsAuthor2 = NewText.findById(2L).get().getNewAuthor();
        String newsText2 = NewText.findById(2L).get().getNewText();
        String newsTitle2 = NewText.findById(2L).get().getNewTitle();
        model.addAttribute("newsAuthor2",newsAuthor2);
        model.addAttribute("newsText2",newsText2);
        model.addAttribute("newsTitle2",newsTitle2);

        //返回志愿内容
        String vmt1 = vmsuGimpl.findById(1L).get().getVMT();
        String vmn1 = vmsuGimpl.findById(1L).get().getVmN();
        model.addAttribute("vmt1",vmt1);
        model.addAttribute("vmn1",vmn1);

        //政策文件下发
        String zcName1 = zc.findById(1L).get().getZcTitle();
        String zcText1 = zc.findById(1L).get().getZcText();
        model.addAttribute("zcname1",zcName1);
        model.addAttribute("zctext1",zcText1);

        String zcName2 = zc.findById(2L).get().getZcTitle();
        String zcText2 = zc.findById(2L).get().getZcText();
        model.addAttribute("zcname2",zcName2);
        model.addAttribute("zctext2",zcText2);

        //用户信息
        String userInfo1 = user.findById(1L).get().getGrjj();
        String author = user.findById(1L).get().getUsername();
        model.addAttribute("userinfo1",userInfo1);
        model.addAttribute("author",author);

        String userInfo2 = user.findById(2L).get().getGrjj();
        String author1 = user.findById(2L).get().getUsername();
        model.addAttribute("userinfo2",userInfo2);
        model.addAttribute("author1",author1);

        String userInfo3 = user.findById(3L).get().getGrjj();
        String author2 = user.findById(3L).get().getUsername();
        model.addAttribute("userinfo3",userInfo3);
        model.addAttribute("author2",author2);
        return "index";
    }

    @RequestMapping("/login")
    public String login(HttpServletResponse httpServletResponse) throws IOException {
        if(!StpUtil.isLogin()){
            return "login";
        }else{
            httpServletResponse.sendRedirect("/admin");
            return "1";
        }
    }

    @RequestMapping("/outLogin")
    @ResponseBody
    public String outLogin(HttpServletResponse httpServletResponse) throws IOException {
        StpUtil.logout();
        httpServletResponse.sendRedirect("/index");
        return "null";
    }

    @SaCheckRole()
    @RequestMapping("/admin")
    public String admin(Model model){

        return "admin";
    }

    @SaCheckRole(type = StpUserUtil.TYPE)
    @RequestMapping("/admin1")
    public String admin1(Model model){
        return "admin";
    }

}
