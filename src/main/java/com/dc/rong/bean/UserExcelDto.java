package com.dc.rong.bean;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import com.dc.rong.utils.FormatterStyle;
import com.dc.rong.utils.LocalDateTimeConverter;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@Builder
@ContentRowHeight(10)
@HeadRowHeight(20)
@ColumnWidth(25)
public class UserExcelDto implements Serializable {

    @ExcelProperty("姓名")
    private String userName;


    @ExcelProperty("密码")
    private String password;

    @FormatterStyle(style = "yy-MM-dd")
    @ExcelProperty(value = "过期时间",converter = LocalDateTimeConverter.class)
    private LocalDate expireTime;


    @ExcelProperty("用户状态")
    private String userState;

}
