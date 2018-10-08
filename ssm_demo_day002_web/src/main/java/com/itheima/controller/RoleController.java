package com.itheima.controller;

import com.itheima.pojo.Permission;
import com.itheima.pojo.Role;
import com.itheima.service.PermissionService;
import com.itheima.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(path = "/role")
public class RoleController {

    @Autowired
    private RoleService roleService;


    @Autowired
    private PermissionService permissionService;

    @RequestMapping(path = "/findAll.do")
    public ModelAndView findAll(){
        List<Role> roleList = roleService.findAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("roleList",roleList);
        modelAndView.setViewName("role-list");
        return modelAndView;
    }

    @RequestMapping(path = "/save.do")
    public String save(Role role){
        roleService.save(role);
        return "redirect:findAll.do";
    }

    @RequestMapping(path = "/findRoleByIdAndAllPermission.do")
    public ModelAndView findRoleByIdAndAllPermission(String id){
        ModelAndView modelAndView = new ModelAndView();
        Role role = roleService.findById(id);
        List<Permission> permissionList = permissionService.findRoleByIdAndAllPermission(id);
        modelAndView.addObject("role",role);
        modelAndView.addObject("permissionList",permissionList);
        modelAndView.setViewName("role-permission-add");
        return modelAndView;
    }

    @RequestMapping(path = "/addPermissionToRole.do")
    public String addPermissionToRole(@RequestParam(name = "roleId",required = true) String roleId ,@RequestParam(name = "ids",required = true) String[] permissions){
        roleService.addPermissionToRole(roleId,permissions);
        return "redirect:findAll.do";
    }

    @RequestMapping(path = "/findById.do")
    public ModelAndView findById(String id){
        Role role = roleService.findById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("role",role);
        modelAndView.setViewName("role-show");
        return modelAndView;
    }
}
