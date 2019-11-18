package com.dc.rong.utils;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.property.ExcelContentProperty;
import com.dc.rong.utils.cache.LocalCache;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.concurrent.ConcurrentMap;

public class LocalDateTimeConverter implements Converter<LocalDateTime> {

    private ConversionService conversionService;


    public LocalDateTimeConverter() {
        this.conversionService = DefaultConversionService.getSharedInstance();
    }


    @Override
    public Class supportJavaTypeKey() {
        return LocalDateTime.class;
    }

    @Override
    public CellDataTypeEnum supportExcelTypeKey() {
        return CellDataTypeEnum.STRING;
    }

    @Override
    public LocalDateTime convertToJavaData(CellData cellData, ExcelContentProperty contentProperty, GlobalConfiguration globalConfiguration) throws Exception {
        return LocalDateTime.now();
    }

    @Override
    public CellData convertToExcelData(LocalDateTime localDateTime, ExcelContentProperty contentProperty, GlobalConfiguration globalConfiguration) throws Exception {

        LocalCache<String,String> shareInstance = LocalCache.getShareInstance();

        if (contentProperty != null) {
            FormatterStyle mergedAnnotation = AnnotatedElementUtils.findMergedAnnotation(contentProperty.getField(), FormatterStyle.class);
            if(StringUtils.hasText(mergedAnnotation.style())){

            }
        }


        if (conversionService.canConvert(LocalDateTime.class, String.class) && localDateTime != null) {
            return new CellData(conversionService.convert(localDateTime, String.class));
        }


        return null;
    }
}
