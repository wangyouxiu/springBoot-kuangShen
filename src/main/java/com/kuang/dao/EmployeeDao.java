package com.kuang.dao;

import com.kuang.pojo.Department;
import com.kuang.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class EmployeeDao {
    //模拟数据库中的数据
    private static Map<Integer, Employee> employees = null;

    @Autowired
    private DepartmentDao departmentDao;

    static {
        employees = new HashMap<Integer, Employee>();
        employees.put(1001,new Employee(1001,"AA","A21342332@qq.com",1,new Department(101,"教学部")));
        employees.put(1002,new Employee(1002,"BB","B21342332@qq.com",0,new Department(102,"市场部")));
        employees.put(1003,new Employee(1003,"CC","C21342332@qq.com",1,new Department(103,"教研部")));
        employees.put(1004,new Employee(1004,"DD","D21342332@qq.com",0,new Department(104,"运营部")));
        employees.put(1005,new Employee(1005,"EE","E21342332@qq.com",1,new Department(105,"后勤部")));
    }

    private static Integer initId = 1006;

    //增加一个员工
    public void save(Employee employee) {
        if (employee.getId() == null) {
            employee.setId(initId++);
        }
        employee.setDepartment(departmentDao.getdepartment(employee.getDepartment().getId()));

        employees.put(employee.getId(), employee);
    }

    public Collection<Employee> getAll() {
        return employees.values();
    }

    public Employee getEmployee(Integer id) {
        return employees.get(id);
    }

    public Employee delEmployee(Integer id) {
        return employees.remove(id);
    }

    public void updateById(Employee employee) {
        delEmployee(employee.getId());
        save(employee);
    }
}
