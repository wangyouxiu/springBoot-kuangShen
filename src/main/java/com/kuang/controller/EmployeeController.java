package com.kuang.controller;

import com.kuang.dao.DepartmentDao;
import com.kuang.dao.EmployeeDao;
import com.kuang.pojo.Department;
import com.kuang.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.websocket.server.PathParam;
import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private DepartmentDao departmentDao;


    @RequestMapping("/emps")
    public String list(Model model) {
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("emps", employees);
        return "emp/list";
    }

    @GetMapping("/emp")
    public String toAddpage(Model model) {
        //查出所有部门信息
        Collection<Department> departments = departmentDao.getdepartments();
        model.addAttribute("departments", departments);

        return "emp/add";
    }


    @PostMapping("/emp")
    public String addpage(Employee employee) {
        employeeDao.save(employee);
        return "redirect:/emps";
    }


    @GetMapping("/emp/{id}")
    public String toUpdatePage(@PathVariable("id") Integer id, Model model) {
        Employee employee = employeeDao.getEmployee(id);
        Collection<Department> departments = departmentDao.getdepartments();
        model.addAttribute("departments", departments);
        model.addAttribute("employee", employee);
        return "emp/update";
    }

    @PostMapping("/updateEmp")
    public String updateEmp(Employee employee) {
        employeeDao.updateById(employee);
        return "redirect:/emps";
    }


    @GetMapping("/delEmp/{id}")
    public String delEmp(@PathVariable("id") Integer id) {
        employeeDao.delEmployee(id);
        return "redirect:/emps";
    }

}
