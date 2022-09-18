package com.example.salaryproject.day20220916Excel;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @program: StudyProject
 * @description: excel文件导出
 * @author: kangwei
 * @create: 2022-09-16 17:17
 **/
public class ExportExcel {

    /**
     * 2003导出
     * @throws IOException
     */
    public static void exports() throws IOException {
        HSSFWorkbook sheets = new HSSFWorkbook();
        //有行、有列
        //创建一个sheet
        HSSFSheet sheet0 = sheets.createSheet("sheet0");
        //创建行，默认0-第一行
        HSSFRow row0 = sheet0.createRow(0);
        //创建一个个单元格，也叫细胞，0-第一个单元格
        //        //创建单元格并设置单元格内容
        row0.createCell( 0 ).setCellValue( "姓名" );
        row0.createCell( 1 ).setCellValue( "班级" );
        row0.createCell( 2 ).setCellValue( "笔试成绩" );
        row0.createCell( 3 ).setCellValue( "机试成绩" );
//        //在sheet里创建第三行
        HSSFRow row1=sheet0.createRow( 1 );
        row1.createCell( 0 ).setCellValue( "李明" );
        row1.createCell( 1 ).setCellValue( "As178" );
        row1.createCell( 2 ).setCellValue( 87 );
        row1.createCell( 3 ).setCellValue( 78 );
        //输出
        FileOutputStream fileOutputStream = new FileOutputStream(new File("D:\\JavaEE学习资料\\score.xls"));
        sheets.write(fileOutputStream);


    }

    /**
     * 2003导出
     *
     * @throws IOException
     */
    public static void export() throws IOException {
        HSSFWorkbook sheets = new HSSFWorkbook();
        //有行、有列
        //创建一个sheet
        HSSFSheet sheet0 = sheets.createSheet("sheet0");
        //创建行，默认0-第一行
        HSSFRow row = sheet0.createRow(0);
        //创建一个个单元格，也叫细胞，0-第一个单元格
        HSSFCell cell = row.createCell(0);
        //设置单元格内容
        cell.setCellValue("测试");
        //输出
        FileOutputStream fileOutputStream = new FileOutputStream(new File("D:\\JavaEE学习资料\\text.xls"));
        sheets.write(fileOutputStream);

    }

    /**
     * 2003导入
     * @throws IOException
     */
    public static void importXlsx() throws IOException {
        //读取文件路径
        FileInputStream inputStream = new FileInputStream("D:\\JavaEE学习资料\\text.xls");

        HSSFWorkbook sheets = new HSSFWorkbook(inputStream);
        //获取excel文件第一个子表
        HSSFSheet sheetAt = sheets.getSheetAt(0);
        //获取总的列
//        int physicalNumberOfRows = sheetAt.getPhysicalNumberOfRows();

        //获取行
        HSSFRow row = sheetAt.getRow(0);

        //通过行取单元格值
        HSSFCell cell = row.getCell(0);
        String value = cell.getStringCellValue();
        System.out.println(value);
    }


    /**
     * 2007导出
     * @throws IOException
     */
    public static void exportXlxs() throws IOException {
        XSSFWorkbook sheets = new XSSFWorkbook();
        //有行、有列
        //创建一个sheet
        XSSFSheet sheet = sheets.createSheet();

        //创建行，默认0-第一行
        XSSFRow row = sheet.createRow(0);
        //创建一个个单元格，也叫细胞，0-第一个单元格
        XSSFCell cell = row.createCell(0);
        //设置单元格内容
        cell.setCellValue("测试");
        //输出
        FileOutputStream fileOutputStream = new FileOutputStream(new File("D:\\JavaEE学习资料\\text.xlsx"));
        sheets.write(fileOutputStream);
    }


    /**
     * 简单导入
     * 2007导入
     * @throws IOException
     */
    public static void importXls() throws IOException {
        //读取文件路径
        FileInputStream inputStream = new FileInputStream("D:\\JavaEE学习资料\\text.xlsx");

        XSSFWorkbook sheets = new XSSFWorkbook(inputStream);
        //获取excel文件第一个子表
        XSSFSheet sheetAt = sheets.getSheetAt(0);

        //获取行
        XSSFRow row = sheetAt.getRow(0);
        //通过行取单元格值
        XSSFCell cell = row.getCell(0);
        String value = cell.getStringCellValue();
        System.out.println(value);
    }



    public static void main(String[] args) throws IOException {
//        export();
//        importXlsx();
        exports();
    }
}
