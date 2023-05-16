package com.edu.vms.Controller;

import cn.dev33.satoken.stp.StpUtil;
import com.edu.vms.Entity.AdminUser;
import com.edu.vms.Entity.User;
import com.edu.vms.Entity.VMSP;
import com.edu.vms.Impl.AdminUserimpl;
import com.edu.vms.Impl.Userimpl;
import com.edu.vms.Impl.VmspImpl;
import com.edu.vms.StpUserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginContr {
    @Autowired
    private AdminUserimpl Admin;
    @Autowired
    private Userimpl user;
    @Autowired
    private VmspImpl vmspSeriver;


    @PostMapping("isLogin")
    public boolean AdminLogin(String username,String password){
        AdminUser admin;
        admin = Admin.findAllByUsernameAndAndPassword(username, password);
        if (admin != null){
            StpUtil.login("101");
            return true;
        }else{
            return false;
        }
    }

    @RequestMapping( "isReg")
     public String Reg(String username,String password,String sex,String phoneNumber){
      AdminUser adminReg = new AdminUser();
      adminReg.setPassword(password);
      adminReg.setSex(sex);
      adminReg.setPhoneName(phoneNumber);
      adminReg.setUsername(username);
      Admin.save(adminReg);
      if (Admin.findAllByUsernameAndAndPassword(username, password) != null){
          return "Msg:注册成功";
      }else {
          return "Msg:注册失败，请联系管理员。";
      }
  }
    @PostMapping("/isUserLogin")
    public boolean UserLogin(String username, String password){
        User userP;
        userP = user.findAllByUsernameAndAndPassword(username, password);
        if (userP != null){
            StpUserUtil.login("1001");
            return true;
        }else{
            return false;
        }
    }

    @PostMapping("isUserReg")
    public String isUserReg(String username,String password,String sex,String phoneNumber) {
        User userReg = new User();
        userReg.setPassword(password);
        userReg.setSex(sex);
        userReg.setPhoneName(phoneNumber);
        userReg.setUsername(username);
        user.save(userReg);
        if (user.findAllByUsernameAndAndPassword(username, password) != null) {
            return "Msg:注册成功";
        } else {
            return "Msg:注册失败，请联系管理员。";
        }
    }


    @PostMapping("/isVMLogin")
    public boolean VMLogin(String username, String password){
       VMSP  vmsp = vmspSeriver.findAllByVMnameAndPassword(username,password);
        if (vmsp != null){
            StpUserUtil.login("1002");
            return true;
        }else{
            return false;
        }
    }
}