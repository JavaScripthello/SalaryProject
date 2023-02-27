package com.example.salaryproject.day20230227CSV.utils;

import cn.hutool.core.text.csv.*;
import cn.hutool.core.util.CharsetUtil;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.net.URL;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @program: SalaryProject
 * @description: csv导入导出工具类
 * @author: kangwei
 * @create: 2023-02-27 14:59
 **/
public class CSVUtils {
    private final static URL PATH = Thread.currentThread().getContextClassLoader().getResource("");


    /**
     * 文件流转为文件
     *
     * @param multipartFile
     * @return
     */
    public static File uploadFile(MultipartFile multipartFile) {
        // 获取上传路径
        String path = PATH.getPath() + multipartFile.getOriginalFilename();
        try {
            // 通过将给定的路径名字符串转换为抽象路径名来创建新的 File实例
            File file = new File(path);
            // 此抽象路径名表示的文件或目录是否存在
            if (!file.getParentFile().exists()) {
                // 创建由此抽象路径名命名的目录，包括任何必需但不存在的父目录
                file.getParentFile().mkdirs();
            }
            // 转换为一般file 文件
            multipartFile.transferTo(file);
            return file;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * csv读取内容
     *
     * @param filePath
     * @return
     */
    public static List<List<String>> readCSV(String filePath) {

        try {
            // 读取文件流
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));
            CSVParser csvRecords = CSVFormat.DEFAULT.parse(bufferedReader); //
            List<CSVRecord> records = csvRecords.getRecords();
            long currentLineNumber = csvRecords.getCurrentLineNumber();
            System.out.println(currentLineNumber);
            String headerComment = csvRecords.getHeaderComment();
            System.out.println(headerComment);
            Map<String, Integer> headerMap = csvRecords.getHeaderMap();
            long recordNumber = csvRecords.getRecordNumber();
            Iterator<CSVRecord> iterator = records.stream().iterator();
            while (iterator.hasNext()) {
                //
                CSVRecord csvRecord = iterator.next();
                System.out.println("==>" + csvRecord);

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static final String WRITE_CSV_FILE_PATH = "D:\\write_test.csv";

    /**
     * 利用hutool写入csv文件
     *
     * @param writeCsvFilePath
     */
    public static void writeCSVFile(String writeCsvFilePath) {
//        CsvWorkbook csvWorkbook = new CsvWorkbook();
//        csvWorkbook.createSheet("用户白名单");
        CsvWriter csvWriter = new CsvWriter(writeCsvFilePath, CharsetUtil.CHARSET_GBK);
        String[] headers = new String[]{"用户名", "手机号", "身份证号"};
//        csvWriter.writeHeaderLine(headers); // 写入文件头
        List<CsvRow> csvRowList = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            String userName = "测试" + (i + 1);
            String userPhone = "188888" + (i + 1);
            String idNo = "188888" + (i + 1);
            List<String> list = Arrays.asList(userName, userPhone, idNo);
            System.out.println(list);
            System.out.println(list);
            HashMap<String, Integer> map = new HashMap<>();
            map.put("userName", 0);
            map.put("userPhone", 1);
            map.put("idNo", 2);
            CsvRow csvRow = new CsvRow(i, map, list);
//            String[] content = new String[]{userName, userPhone, idNo};
//            CsvWriter write = csvWriter.write(content);
            System.out.println(csvRow);
            csvRowList.add(csvRow);
        }
        List<String> collect = Arrays.stream(headers).collect(Collectors.toList());
        CsvData csvData = new CsvData(collect, csvRowList);
        csvWriter.write(csvData);
        csvWriter.close();

    }


    /**
     * 读csv文件
     *
     * @param filePath
     */
    public static void readCSV1(String filePath) {
        CsvReadConfig csvReadConfig = new CsvReadConfig();
        csvReadConfig.setContainsHeader(true);
        // csvReader
//        CsvReader csvReader1 = new CsvReader(new File(filePath),CharsetUtil.CHARSET_GBK, csvReadConfig);
        CsvReader csvReader = new CsvReader(Paths.get(filePath), CharsetUtil.CHARSET_GBK, csvReadConfig);
        CsvData read = csvReader.read();
        System.out.println(read.getHeader());
        System.out.println(read.getRows());
        List<CsvRow> rows = read.getRows();

        for (CsvRow row : rows) {
            Map<String, String> fieldMap = row.getFieldMap();
            System.out.println(fieldMap);
        }
        try {
            csvReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
//        writeCSVFile(WRITE_CSV_FILE_PATH);
        readCSV(WRITE_CSV_FILE_PATH);
    }
}
