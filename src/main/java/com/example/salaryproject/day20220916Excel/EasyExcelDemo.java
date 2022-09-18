package com.example.salaryproject.day20220916Excel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.event.SyncReadListener;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: StudyProject
 * @description:https://easyexcel.opensource.alibaba.com/
 * 官方文档
 * @author: kangwei
 * @create: 2022-09-18 17:19
 **/
public class EasyExcelDemo {

    /**
     * 导出
     *
     * @throws FileNotFoundException
     */
    public static void easyExcelExport() throws FileNotFoundException {
        LinkedList<Student> students = new LinkedList<>();
        for (int i = 0; i < 2; i++) {
            Student student = new Student();
            student.setStuId("" + (i + 1));
            student.setStuName("xiaolin" + (i + 1));
            students.add(student);
        }
        EasyExcel.write(new FileOutputStream(new File("D:\\JavaEE学习资料\\easy.xlsx")), Student.class).sheet(0).doWrite(students);
    }

    /**
     * 导入
     *
     * @throws FileNotFoundException
     */
    public static void easyExcelImport() throws FileNotFoundException {
        List<Student> students = EasyExcel.read(new FileInputStream("D:\\JavaEE学习资料\\easy.xlsx"), Student.class, new SyncReadListener()).sheet(0).doReadSync();
        System.out.println(students);

    }

    public static void main(String[] args) throws FileNotFoundException {
//        easyExcelExport();
        easyExcelImport();
    }
}
