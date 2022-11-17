package com.example.salaryproject.day20220916Excel;

import lombok.Data;
import lombok.ToString;

/**
 * @program: StudyProject
 * @description: 学生实体
 * @author: kangwei
 * @create: 2022-09-18 17:34
 **/
@Data
@ToString
public class Student {
//    @ExcelProperty("学生姓名")
    private String stuName;
    private String stuId;
}
