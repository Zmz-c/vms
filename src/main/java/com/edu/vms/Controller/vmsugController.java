package com.edu.vms.Controller;

import com.edu.vms.Entity.User;
import com.edu.vms.Entity.VMSUG;
import com.edu.vms.Impl.Userimpl;
import com.edu.vms.Impl.VMSUGimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@Controller
public class vmsugController {
    @Autowired
    private VMSUGimpl vmsSeriver;
    @Autowired
    private Userimpl users;


    @RequestMapping("readVmsug")
    @ResponseBody
    public Map<String, Object> getvmsug(){
        Iterable<VMSUG> vMSUG =vmsSeriver.findAll();
        Map<String,Object> map =new HashMap<>();
        map.put("data",vMSUG);
        map.put("code",0);
        return map;
    }



    @RequestMapping("/addV")
    @ResponseBody
    public String addV(Long id,Long uid){
        Optional<User> use = users.findById(uid);
        use.ifPresent(user -> {
            user.setZyxm(String.valueOf(vmsSeriver.findById(id).get().getId()));
            users.save(user);
        });
        Optional<VMSUG> vmsug = vmsSeriver.findById(id);
        vmsug.ifPresent(vmsug1 -> {
            vmsug1.setIsuser(use.get().getUsername());
            vmsSeriver.save(vmsug1);
        });
        if(!Objects.equals(use.get().getZyxm(), vmsug.get().getIsuser())){
            return "非该组成员";
        }else{
            Map<String,Object> map =new HashMap<>();
            map.put("data",vmsug.get().getIsuser());
            map.put("code",0);
            map.put("suss",use);
        }

        return "添加成功";
    }

    @RequestMapping("/queryV")
    @ResponseBody
    public Map<String, Object> queryV(Long uid, Long vid){
        Optional<User> user = users.findById(uid);
        Map<String,Object> map =new HashMap<>();
        if(Objects.equals(user.get().getZyxm(),vmsSeriver.findById(vid).get().getIsuser())){
            map.put("vmps",vmsSeriver.findById(vid).get().getVMname());
            map.put("data",user.get().getUsername());
            return map;
        }else {
            Map<String,Object> map1 =new HashMap<>();
            map1.put("data","非该组成员");
            return  map1;
        }

    }

    @RequestMapping("/addVMSUG")
    @ResponseBody
    public String addVMsug(String vmname, String isvm,String vmn,String vmt,String Vadders){
        VMSUG vmsug = new VMSUG();
        vmsug.setVMname(vmname);
        vmsug.setIsvm(isvm);
        vmsug.setVmN(vmn);
        vmsug.setVMT(vmt);
        vmsug.setVmAdders(Vadders);
        vmsSeriver.save(vmsug);
        return "添加成功";
    }

    @RequestMapping("/upVMSUG")
    public String upVMsug(){
        return "addVMSUG";
    }

    @RequestMapping("/editZYtext")
    @ResponseBody
    public Map<String, Object> editVmt(String vmt, String id) throws IOException, InterruptedException {
            Optional<VMSUG> editzc;
            editzc = vmsSeriver.findById(Long.valueOf(id));
            editzc.ifPresent(zcText1 -> {
                zcText1.setVMT(vmt);
                vmsSeriver.save(zcText1);
            });

            Optional<VMSUG> ezc = vmsSeriver.findById(Long.valueOf(id));
            Map<String,Object> map =new HashMap<>();
            map.put("data",ezc);
            return map;
    }
}
