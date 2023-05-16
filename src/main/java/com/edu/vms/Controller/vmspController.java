package com.edu.vms.Controller;
import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.stp.StpUtil;
import com.edu.vms.Entity.User;
import com.edu.vms.Entity.VMSP;
import com.edu.vms.Impl.Userimpl;
import com.edu.vms.Impl.VmspImpl;
import com.edu.vms.StpUserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@Controller
public class vmspController {
    @Autowired
    private VmspImpl vmsps;
    @Autowired
    private Userimpl users;


    @RequestMapping("/addvmsp")
    @ResponseBody
    public String addvmsp(String phoneName,String password,String username,String vmtime,String sex){
        VMSP user1 = new VMSP();
        user1.setVMname(username);
        user1.setPhoneName(phoneName);
        user1.setPassword(password);
        user1.setSex(sex);
        user1.setVMTime(vmtime);
        vmsps.save(user1);
        return "注册成功";
    }
    @SaCheckRole("admin")
    @RequestMapping("/queryvmsp1")
    @ResponseBody
    public Map<String, Object> queryVMsuser(Long uid, Long vid){
        Optional<User> user = users.findById(uid);
        Map<String,Object> map =new HashMap<>();
        if(Objects.equals(user.get().getZyz(), vmsps.findById(vid).get().getId().toString())){
            map.put("vmps",vmsps.findById(vid).get().getVMname());
            map.put("data",user.get().getUsername());
            return map;
        }else {
            Map<String,Object> map1 =new HashMap<>();
            map1.put("data","非该组成员");
            return  map1;
        }

    }


    //志愿组列表
    @RequestMapping("readVM")
    @ResponseBody
    public Map<String, Object> getVM(){
        Iterable<VMSP> user1 = vmsps.findAll();
        Map<String,Object> map =new HashMap<>();
        map.put("data",user1);
        map.put("code",0);
        return map;
    }

    //加入项目组
    @RequestMapping("addVM")
    @ResponseBody
    @SaCheckRole(type = StpUserUtil.TYPE)
    public Map<String, Object> addVM(Long uid,Long id){
        Optional<User> use = users.findById(uid);
        use.ifPresent(user -> {
            user.setZyz(String.valueOf(vmsps.findById(id).get().getId()));
            users.save(user);
        });
        Iterable<VMSP> user1 = vmsps.findAll();
        Map<String,Object> map =new HashMap<>();
        map.put("data",user1);
        map.put("code",0);
        map.put("suss",use);
        return map;
    }

    @SaCheckRole("admin")
    @RequestMapping("/delzyz1")
    @ResponseBody
    public String delzyz1(String id){
        if(!StpUtil.isLogin()){
            System.out.print("请登录");
            return "跳转中";
        }else {
            vmsps.deleteById(Long.valueOf(id));
        }
        return "成功";
    }

   @RequestMapping("/regZY")
    public  String addZY(){
        return "regZY";
   }

    @SaCheckRole(type = StpUserUtil.TYPE)
    @RequestMapping("/zyxmgl")
    public  String zyxmgl(){
        return "ZYXMAdmin";
    }

    @RequestMapping("/zydwlogin")
    public String zydwlogin(){
        return "zydlogin";
    }


}
