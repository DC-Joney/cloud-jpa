package com.dc.rong.utils;

import com.alibaba.excel.EasyExcel;
import com.dc.rong.bean.UserExcelDto;

import java.nio.file.Path;
import java.util.List;

public class ExcelUtils {

    public static <E> void writeExcel(Path path, List<E> datas){
        EasyExcel.write(path.toFile(), UserExcelDto.class).sheet("模板").doWrite(datas);
    }

}
