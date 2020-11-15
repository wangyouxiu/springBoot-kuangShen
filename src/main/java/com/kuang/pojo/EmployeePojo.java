package com.kuang.pojo;

import com.kuang.model.Department;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeePojo implements Serializable {

    private Integer id;

    private String lastname;

    private String email;

    private Integer gender;

    private Date birth;

    private Integer departmentId;

    private Department department;
}
