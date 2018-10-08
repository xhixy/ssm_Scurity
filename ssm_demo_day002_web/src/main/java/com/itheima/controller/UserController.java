package com.itheima.controller;

import com.itheima.pojo.Role;
import com.itheima.pojo.UserInfo;
import com.itheima.service.RoleService;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author 用户操作
 */
@Controller
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @RequestMapping(path = "/save.do")
    @PreAuthorize("authentication.principal.username == 'mayun'")
    public String save(UserInfo userInfo){
        userService.save(userInfo);
        return "redirect:findAll.do";
    }


    @RequestMapping(path = "/findAll.do")
    @PreAuthorize("hasRole('ROLE_BABA')")
    public ModelAndView findAll(){
        List<UserInfo> userList = userService.findAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userList",userList);
        modelAndView.setViewName("user-list");
        return modelAndView;
    }

    @RequestMapping(path = "/findById.do")
    public ModelAndView findById(String id){
        ModelAndView modelAndView = new ModelAndView();
        UserInfo userInfo = userService.findById(id);
        modelAndView.addObject("user",userInfo);
        modelAndView.setViewName("user-show");
        return modelAndView;
    }

    @RequestMapping(path = "/findUserByIdAndAllRole.do")
    public ModelAndView findUserByIdAndAllRole(String id){
        UserInfo user = userService.findById(id);
        List<Role> roleList =  roleService.findUserByIdAndAllRole(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user",user);
        modelAndView.addObject("roleList",roleList);
        modelAndView.setViewName("user-role-add");
        return modelAndView;
    }

    @RequestMapping(path = "addRoleToUser.do")
    public String addRoleToUser(@RequestParam(name = "userId") String userId , @RequestParam(name = "ids") String[] str){
        userService.addRoleToUser(userId,str);
        return "redirect:findAll.do";
    }

    @RequestMapping(path = "deleteRole.do")
    public String deleteRole(@RequestParam(value = "userId",required = true) String userId,@RequestParam(name = "ids",required = true) String[] roleIds){
        userService.deleteRole(userId,roleIds);
        return "redirect:findAll.do";
    }

    @RequestMapping(path = "findUserByIdDeleteRole.do")
    public ModelAndView findUserByIdDeleteRole(@RequestParam(name = "id") String userId){
        ModelAndView modelAndView = new ModelAndView();
        UserInfo userInfo = userService.findUserByIdDeleteRole(userId);
        modelAndView.addObject("user",userInfo);
        modelAndView.addObject("roleList",userInfo.getRoles());
        modelAndView.setViewName("user-delete-role");
        return modelAndView;
    }
}
