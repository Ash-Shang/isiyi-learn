package com.isiyi.printer.utils;

import com.isiyi.printer.constant.PrinterConstant;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 打印模板的数据渲染工具类
 * <p></p>
 *
 * @version 1.0.0
 * @description: 打印模板的数据渲染工具类
 * @author: 向鹏飞
 * @since: 2021/4/27
 */
public class PrintTemplateUtil {

    private PrintTemplateUtil(){}
    /**
     * 打印模板的渲染数据
     * <p></p>
     *
     * @param template 模板字符串
     * @param dataMap  数据map
     * @return
     * @author 向鹏飞
     * @version 1.0.0
     * @date 2021/4/27 14:54
     */
    public static String render(String template, Map<String, Object> dataMap){
        if(StringUtils.isBlank(template) || dataMap.isEmpty()){
            return template;
        }
        try {
            StringBuffer sb = new StringBuffer();
            Pattern pattern = Pattern.compile(PrinterConstant.REPLACE_PATTERN);
            Matcher matcher = pattern.matcher(template);

            while (matcher.find()) {
                //键名
                String name = matcher.group(1);
                // 键值
                String value = dataMap.get(name).toString();
                if (value == null) {value = "";}
                matcher.appendReplacement(sb, value);
            }
            matcher.appendTail(sb);
            return sb.toString();
        } catch (Exception e) {
            System.out.println("PrintTemplateUtil.render::数据渲染异常，异常原因为："+e);
            e.printStackTrace();
        }
        return template;
    }


}
