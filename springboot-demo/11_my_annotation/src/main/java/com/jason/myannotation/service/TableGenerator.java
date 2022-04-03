package com.jason.myannotation.service;

import com.jason.myannotation.annotations.MyColumn;
import com.jason.myannotation.annotations.MyConstraints;
import com.jason.myannotation.annotations.MyTable;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

@Service
public class TableGenerator {

    /**
     * 运行时解析注解 生成对应的建表语句
     * @return
     */
    public String genSQL(Class clazz) throws Exception{
        String table;
        List<String> columnSegments = new ArrayList<>();

        // 获取表注解
        MyTable myTable = (MyTable) clazz.getAnnotation(MyTable.class);
        if(myTable == null){
            throw new Exception("表注解不能为空");
        }

        table = myTable.value();
        Field[] fields = clazz.getDeclaredFields();
        for(Field field : fields){
            MyColumn column = field.getAnnotation(MyColumn.class);
            System.out.println("column: "+ column);
            if(column == null){
                continue; // 该字段没有 @MyColumn注解
            }

            StringBuilder columnSegement = new StringBuilder();
            String columnType = column.type().toUpperCase();
            String columnName = column.value().toUpperCase();
            columnSegement.append(columnName).append(" ").append(columnType).append(" ");

            MyConstraints constraints = column.constraints();
            boolean primaryKey = constraints.primaryKey();
            boolean unique = constraints.unique();
            boolean nullable = constraints.nullable();
            if (primaryKey) {
                //主键唯一且不为空
                columnSegement.append("PRIMARY KEY ");
            } else if (!nullable) {
                //字段不为null
                columnSegement.append("NOT NULL ");
            }
            if (unique) {
                //有唯一键
                columnSegement.append("UNIQUE ");
            }

            columnSegments.add(columnSegement.toString());
        }

        if (columnSegments.size() < 1) {
            //没有映射任何表字段,抛出异常
            throw new IllegalArgumentException("没有映射任何表字段: " + columnSegments.size());
        }

        StringJoiner joiner = new StringJoiner(",", "(", ")");
        for (String segement : columnSegments) {
            joiner.add(segement);
        }
        //生成SQL语句
        return String.format("CREATE TABLE %s", table) + joiner.toString();
    }
}
