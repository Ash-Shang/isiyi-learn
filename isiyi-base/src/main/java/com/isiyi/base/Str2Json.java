package com.isiyi.base;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.*;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Str2Json {

    public static void main(String[] args)  {
        try {
            String file = "D:\\codews\\data\\user.txt";
            String desc_file = "D:\\codews\\data\\user_desc.txt";
            File jsonFile = new File(file);
            FileReader fileReader = new FileReader(jsonFile);
            Reader reader = new InputStreamReader(new FileInputStream(jsonFile), "utf-8");
            int ch = 0;
            StringBuffer sb = new StringBuffer();
            while ((ch = reader.read()) != -1) {
                sb.append((char) ch);
            }
            fileReader.close();
            reader.close();
            JSONObject parse = (JSONObject) JSONObject.parse(sb.toString());
            JSONArray data = (JSONArray) parse.get("data");
            Iterator<Object> iterator = data.iterator();
            while (iterator.hasNext()) {
                JSONObject next = (JSONObject) iterator.next();
                JSONObject user = (JSONObject) next.get("UserWorkspace");
                String user1 = (String) user.get("user");
                boolean check = check(user1);
                if (check) {
                    //todo 写出去
                    System.out.println(user.toJSONString());
                }

            }
        }catch (Exception e){

        }
    }


    private static boolean check(String name){
        if(null == name || "".equals(name)){
            return false;
        }
        List<String> strings = Arrays.asList("科脉", "企迈", "怀思", "安卓", "e成", "郎新", "企管宝", "热拍", "信安", "企迈", "奇秦", "景同");
        for (int i = 0; i < strings.size(); i++) {
            if(name.contains(strings.get(i))){
                return false;
            }
        }
        return true;
    }
}
