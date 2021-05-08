package com.isiyi.printer;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.isiyi.printer.params.*;

import java.io.*;
import java.net.Socket;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



/**
 * 控制打印机工具类
 *
 *
 *
 * @author SubLuLu
 */
public class EscPos {

    private static String encoding = null;

    // 通过socket流进行读写
    private OutputStream socketOut = null;
    private OutputStreamWriter writer = null;

    // 以ip作为key，EscPos实例作为value的Map
    private static Map<String, EscPos> posMap = new HashMap<String, EscPos>();
    private static EscPos escPos = null;


    public final static  String IP_TM_T82III="192.168.197.75";


    public static String PARAMS="{\n" +
            "  \"keys\": {\n" +
            "    \"shopname\": \"探鱼烤鱼\",\n" +
            "    \"barCode\": \"6921734976505\",\n" +
            "    \"qrCode\": \"http://www.gtmsh.com\",\n" +
            "    \"time\": \"15:35\",\n" +
            "    \"num\": 14,\n" +
            "    \"cash\": 324.5,\n" +
            "    \"logo\": \"/sdcard/qr.png\",\n" +
            "    \"adv\": \"关注微信，有大大地活动哦\"\n" +
            "  },\n" +
            "  \"goods\": [\n" +
            "    {\n" +
            "      \"name\": \"青椒烤鱼\",\n" +
            "      \"num\": 1,\n" +
            "      \"price\": 121.8,\n" +
            "      \"pay\": 120.8\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"酱香烤鱼\",\n" +
            "      \"num\": 1,\n" +
            "      \"price\": 114.8,\n" +
            "      \"pay\": 114.8\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"辣椒炒肉\",\n" +
            "      \"num\": 1,\n" +
            "      \"price\": 14.8,\n" +
            "      \"pay\": 14.8\n" +
            "    }\n" +
            "  ]\n" +
            "}";


    public static String TMP="{\n" +
            "    \"header\": [\n" +
            "        {\n" +
            "            \"text\": \"{$shopname}\",\n" +
            "            \"size\": 2,\n" +
            "            \"bold\": true,\n" +
            "            \"format\": 1,\n" +
            "            \"line\": 2,\n" +
            "            \"underline\": true,\n" +
            "            \"type\": 0\n" +
            "        },\n" +
            "        {\n" +
            "            \"text\": \"{$barCode}\",\n" +
            "            \"format\": 1,\n" +
            "            \"line\": 2,\n" +
            "            \"type\": 1\n" +
            "        },\n" +
            "        {\n" +
            "            \"path\": \"{$logo}\",\n" +
            "            \"format\": 1,\n" +
            "            \"line\": 2,\n" +
            "            \"type\": 3\n" +
            "        },\n" +
            "        {\n" +
            "            \"text\": \"---------------------------------------\",\n" +
            "            \"format\": 0,\n" +
            "            \"size\": 1,\n" +
            "            \"bold\": false,\n" +
            "            \"line\": 2,\n" +
            "            \"type\": 0\n" +
            "        },\n" +
            "        {\n" +
            "            \"text\": \"{$qrCode}\",\n" +
            "            \"format\": 1,\n" +
            "            \"line\": 2,\n" +
            "            \"type\": 2\n" +
            "        }\n" +
            "    ],\n" +
            "    \"goods\": [\n" +
            "        {\n" +
            "            \"name\": \"商品名\",\n" +
            "            \"width\": 24,\n" +
            "            \"format\": 0,\n" +
            "            \"variable\": \"name\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\": \"数量\",\n" +
            "            \"width\": 8,\n" +
            "            \"format\": 1,\n" +
            "            \"variable\": \"num\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\": \"单价\",\n" +
            "            \"width\": 8,\n" +
            "            \"format\": 1,\n" +
            "            \"variable\": \"price\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\": \"金额\",\n" +
            "            \"width\": 8,\n" +
            "            \"format\": 2,\n" +
            "            \"variable\": \"pay\"\n" +
            "        }\n" +
            "    ],\n" +
            "    \"bill\": [\n" +
            "        {\n" +
            "            \"text\": \"实收现金\",\n" +
            "            \"size\": 3,\n" +
            "            \"bold\": true,\n" +
            "            \"format\": 1,\n" +
            "            \"line\": 2,\n" +
            "            \"underline\": false,\n" +
            "            \"type\": 0\n" +
            "        },\n" +
            "        {\n" +
            "            \"text\": \"{$cash}\",\n" +
            "            \"size\": 3,\n" +
            "            \"bold\": true,\n" +
            "            \"format\": 1,\n" +
            "            \"line\": 2,\n" +
            "            \"underline\": false,\n" +
            "            \"type\": 0\n" +
            "        }\n" +
            "    ],\n" +
            "    \"footer\": [\n" +
            "        {\n" +
            "            \"text\": \"详情请访问官网\",\n" +
            "            \"size\": 2,\n" +
            "            \"bold\": true,\n" +
            "            \"format\": 1,\n" +
            "            \"line\": 2,\n" +
            "            \"underline\": true,\n" +
            "            \"type\": 0\n" +
            "        },\n" +
            "        {\n" +
            "            \"text\": \"http://www.sublulu.com\",\n" +
            "            \"format\": 1,\n" +
            "            \"line\": 2,\n" +
            "            \"type\": 2\n" +
            "        }\n" +
            "    ]\n" +
            "}";

    /**
     * 根据ip、端口、字符编码构造工具类实例
     *
     * @param ip          打印机ip
     * @param port        打印机端口，默认9100
     * @param encoding    打印机支持的编码格式(主要针对中文)
     * @throws IOException
     */
    public EscPos(String ip, int port, String encoding) throws IOException {
        Socket socket = new Socket(ip, port);
        socketOut = socket.getOutputStream();
        socket.isClosed();
        this.encoding = encoding;
        writer = new OutputStreamWriter(socketOut, encoding);
    }

    public synchronized static EscPos getInstance(String ip, Integer port, String encoding) throws IOException {
        escPos = posMap.get(ip);
        if (escPos == null) {
            escPos = new EscPos(ip, port, encoding);
        }
        return escPos;
    }

    public synchronized static EscPos getInstance(String ip, Integer port) throws IOException {
        return getInstance(ip, port, Constant.DEFAULT_ENCODING);
    }

    public static synchronized EscPos getInstance(String ip) throws IOException {
        return getInstance(ip, Constant.DEFAULT_PORT, Constant.DEFAULT_ENCODING);
    }

    /**
     * 根据某班内容和参数打印小票
     *
     * @param template 模板内容
     * @param param    参数
     * @throws IOException
     */
    public static void print(String template, String param) throws IOException {
        PosParam posParam = JSON.parseObject(param, PosParam.class);

        Map<String, Object> keyMap = posParam.getKeys();
        List<Map<String, Object>> goodsParam = posParam.getGoods();

        // replace placeholder in template
        Pattern pattern = Pattern.compile(Constant.REPLACE_PATTERN);

        Matcher matcher = pattern.matcher(template);
        StringBuffer sb = new StringBuffer();

        while (matcher.find()) {
            String key = matcher.group(1);
            matcher.appendReplacement(sb, keyMap.get(key).toString());
        }

        matcher.appendTail(sb);

        template = sb.toString();

        PosTpl posTpl = JSON.parseObject(template, PosTpl.class);

        // 打印文件头
        for (JSONObject jsonObject : posTpl.getHeader()) {
            print(jsonObject);
        }

        // 打印标题
        for (Goods goods : posTpl.getGoods()) {
            printTitle(goods);
        }
        escPos.line(1);

        // 打印详情
        for (Map<String, Object> goods : goodsParam) {
            printGoods(goods, posTpl.getGoods());
        }

        // 打印金额
        for (JSONObject jsonObject : posTpl.getBill()) {
            print(jsonObject);
        }

        // 打印文件尾
        for (JSONObject jsonObject : posTpl.getFooter()) {
            print(jsonObject);
        }

        escPos.line(2);

        escPos.feedAndCut();
    }

    /**
     * 换行
     *
     * @param lineNum 换行数，0为不换行
     * @return
     * @throws IOException
     */
    private EscPos line(int lineNum) throws IOException {
        for (int i=0; i<lineNum; i++) {
            writer.write("\n");
            writer.flush();
        }
        return this;
    }

    /**
     * 下划线
     *
     * @param flag false为不添加下划线
     * @return
     * @throws IOException
     */
    private EscPos underline(boolean flag) throws IOException {
        if (flag) {
            writer.write(0x1B);
            writer.write(45);
            writer.write(2);
        }
        return this;
    }

    /**
     * 取消下划线
     *
     * @param flag true为取消下划线
     * @return
     * @throws IOException
     */
    private EscPos underlineOff(boolean flag) throws IOException {
        if (flag) {
            writer.write(0x1B);
            writer.write(45);
            writer.write(0);
        }
        return this;
    }

    /**
     * 加粗
     *
     * @param flag false为不加粗
     * @return
     * @throws IOException
     */
    private EscPos bold(boolean flag) throws IOException {
        if (flag) {
            writer.write(0x1B);
            writer.write(69);
            writer.write(0xF);
        }
        return this;
    }

    /**
     * 取消粗体
     *
     * @param flag true为取消粗体模式
     * @return
     * @throws IOException
     */
    private EscPos boldOff(boolean flag) throws IOException {
        if (flag) {
            writer.write(0x1B);
            writer.write(69);
            writer.write(0);
        }
        return this;
    }

    /**
     * 排版
     *
     * @param position 0：居左(默认) 1：居中 2：居右
     * @return
     * @throws IOException
     */
    private EscPos align(int position) throws IOException {
        writer.write(0x1B);
        writer.write(97);
        writer.write(position);
        return this;
    }

    /**
     * 初始化打印机
     *
     * @return
     * @throws IOException
     */
    private EscPos init() throws IOException {
        writer.write(0x1B);
        writer.write(0x40);
        return this;
    }

    /**
     * 二维码排版对齐方式
     *
     * @param position   0：居左(默认) 1：居中 2：居右
     * @param moduleSize 二维码version大小
     * @return
     * @throws IOException
     */
    private EscPos alignQr(int position, int moduleSize) throws IOException {
        writer.write(0x1B);
        writer.write(97);
        if (position == 1) {
            writer.write(1);
            centerQr(moduleSize);
        } else if (position == 2){
            writer.write(2);
            rightQr(moduleSize);
        } else {
            writer.write(0);
        }
        return this;
    }

    /**
     * 居中牌排列
     *
     * @param moduleSize  二维码version大小
     * @throws IOException
     */
    private void centerQr(int moduleSize) throws IOException {
        switch (moduleSize) {
            case 1 :{
                printSpace(16);
                break;
            }
            case 2 : {
                printSpace(18);
                break;
            }
            case 3 :{
                printSpace(20);
                break;
            }
            case 4 : {
                printSpace(22);
                break;
            }
            case 5 : {
                printSpace(24);
                break;
            }
            case 6 : {
                printSpace(26);
                break;
            }
            default:
                break;
        }
    }

    /**
     * 二维码居右排列
     *
     * @param moduleSize  二维码version大小
     * @throws IOException
     */
    private void rightQr(int moduleSize) throws IOException {
        switch (moduleSize) {
            case 1 :
                printSpace(14);
                break;
            case 2 :
                printSpace(17);
                break;
            case 3 :
                printSpace(20);
                break;
            case 4 :
                printSpace(23);
                break;
            case 5 :
                printSpace(26);
                break;
            case 6 :
                printSpace(28);
                break;
            default:
                break;
        }
    }

    /**
     * 打印空白
     *
     * @param length  需要打印空白的长度
     * @throws IOException
     */
    private void printSpace(int length) throws IOException {
        for (int i=0; i<length; i++) {
            writer.write(" ");
        }
        writer.flush();
    }

    /**
     * 字体大小
     *
     * @param size 1-8 选择字号
     * @return
     * @throws IOException
     */
    private EscPos size(int size) throws IOException {
        int fontSize;
        switch (size) {
            case 1:
                fontSize = 0;
                break;
            case 2:
                fontSize = 17;
                break;
            case 3:
                fontSize =34;
                break;
            case 4:
                fontSize = 51;
                break;
            case 5:
                fontSize = 68;
                break;
            case 6:
                fontSize = 85;
                break;
            case 7:
                fontSize = 102;
                break;
            case 8:
                fontSize = 119;
                break;
            default:
                fontSize = 0;
        }
        writer.write(0x1D);
        writer.write(33);
        writer.write(fontSize);
        return this;
    }

    /**
     * 重置字体大小
     *
     * @return
     * @throws IOException
     */
    private EscPos sizeReset() throws IOException {
        writer.write(0x1B);
        writer.write(33);
        writer.write(0);
        return this;
    }

    /**
     * 进纸并全部切割
     *
     * @return
     * @throws IOException
     */
    private EscPos feedAndCut() throws IOException {
        writer.write(0x1D);
        writer.write(86);
        writer.write(65);
        writer.write(0);
        writer.flush();
        return this;
    }

    /**
     * 打印条形码
     *
     * @param value
     * @return
     * @throws IOException
     */
    private EscPos barCode(String value) throws IOException {
        writer.write(0x1D);
        writer.write(107);
        writer.write(67);
        writer.write(value.length());
        writer.write(value);
        writer.flush();
        return this;
    }

    /**
     * 打印二维码
     *
     * @param qrData
     * @return
     * @throws IOException
     */
    private EscPos qrCode(int position, String qrData) throws IOException {


        int store_len = qrData.length() + 3;
        char store_pL = (char) (store_len % 256);
        char store_pH = (char) (store_len / 256);


        // QR Code: Select the model
        //              Hex     1D      28      6B      04      00      31      41      n1(x32)     n2(x00) - size of model
        // set n1 [49 x31, model 1] [50 x32, model 2] [51 x33, micro qr code]
        // https://reference.epson-biz.com/modules/ref_escpos/index.php?content_id=140
        char[] modelQR = {(byte)0x1d, (byte)0x28, (byte)0x6b, (byte)0x04, (byte)0x00, (byte)0x31, (byte)0x41, (byte)0x32, (byte)0x00};

        // QR Code: Set the size of module
        // Hex      1D      28      6B      03      00      31      43      n
        // n depends on the printer
        // https://reference.epson-biz.com/modules/ref_escpos/index.php?content_id=141
        // 二维码大小
        char[] sizeQR = {(byte)0x1d, (byte)0x28, (byte)0x6b, (byte)0x03, (byte)0x00, (byte)0x31, (byte)0x43, (byte)0x09};


        //          Hex     1D      28      6B      03      00      31      45      n
        // Set n for error correction [48 x30 -> 7%] [49 x31-> 15%] [50 x32 -> 25%] [51 x33 -> 30%]
        // https://reference.epson-biz.com/modules/ref_escpos/index.php?content_id=142
        // 二维码容错级别
        char[] errorQR = {(byte)0x1d, (byte)0x28, (byte)0x6b, (byte)0x03, (byte)0x00, (byte)0x31, (byte)0x45, (byte)0x31};


        // QR Code: Store the data in the symbol storage area
        // Hex      1D      28      6B      pL      pH      31      50      30      d1...dk
        // https://reference.epson-biz.com/modules/ref_escpos/index.php?content_id=143
        //                        1D          28          6B         pL          pH  cn(49->x31) fn(80->x50) m(48->x30) d1…dk
        char[] storeQR = {(byte)0x1d, (byte)0x28, (byte)0x6b, store_pL, store_pH, (byte)0x31, (byte)0x50, (byte)0x30};


        // QR Code: Print the symbol data in the symbol storage area
        // Hex      1D      28      6B      03      00      31      51      m
        // https://reference.epson-biz.com/modules/ref_escpos/index.php?content_id=144
        char[] printQR = {(byte)0x1d, (byte)0x28, (byte)0x6b, (byte)0x03, (byte)0x00, (byte)0x31, (byte)0x51, (byte)0x30};

        // flush() runs the print job and clears out the print buffer
        writer.flush();

        // write() simply appends the data to the buffer


        writer.write(modelQR);

        writer.write(sizeQR);
        writer.write(errorQR);
        writer.write(storeQR);
        writer.write(qrData.toCharArray());
        writer.write(printQR);


        writer.flush();

        return this;
    }

    /**
     * 打印图片
     *
     * @param path  图片地址
     * @return
     */
    private EscPos image(String path) throws IOException {
//        // trans to byte array
//        Bitmap bmp  = BitmapFactory.decodeFile(path);
//
//        byte[] data = new byte[] { 0x1B, 0x33, 0x00 };
//        write(data);
//        data[0] = (byte)0x00;
//        data[1] = (byte)0x00;
//        data[2] = (byte)0x00;    //重置参数
//
//        int pixelColor;
//
//        // ESC * m nL nH 点阵图
//        byte[] escBmp = new byte[] { 0x1B, 0x2A, 0x00, 0x00, 0x00 };
//
//        escBmp[2] = (byte)0x21;
//
//        //nL, nH
//        escBmp[3] = (byte)(bmp.getWidth() % 256);
//        escBmp[4] = (byte)(bmp.getWidth() / 256);
//
//        // 每行进行打印
//        for (int i = 0; i < bmp.getHeight()  / 24 + 1; i++){
//            write(escBmp);
//
//            for (int j = 0; j < bmp.getWidth(); j++){
//                for (int k = 0; k < 24; k++){
//                    if (((i * 24) + k) < bmp.getHeight()){
//                        pixelColor = bmp.getPixel(j, (i * 24) + k);
//                        if (pixelColor != -1){
//                            data[k / 8] += (byte)(128 >> (k % 8));
//                        }
//                    }
//                }
//
//                write(data);
//                // 重置参数
//                data[0] = (byte)0x00;
//                data[1] = (byte)0x00;
//                data[2] = (byte)0x00;
//            }
//            //换行
//            byte[] byte_send1 = new byte[2];
//            byte_send1[0] = 0x0d;
//            byte_send1[1] = 0x0a;
//            write(byte_send1);
//        }
        return this;
    }

    private void write(byte ...data) throws IOException {
        socketOut.write(data);
        socketOut.flush();
    }

    /**
     * 打印字符串
     *
     * @param str 所需打印字符串
     * @return
     * @throws IOException
     */
    private EscPos printStr(String str) throws IOException {
        writer.write(str);
        writer.flush();
        return this;
    }

    /**
     * 打印任何对象
     *
     * @param jsonObject  需要输出对象
     * @throws IOException
     */
    private static void print(JSONObject jsonObject) throws IOException {
        int type = jsonObject.getInteger("type");

        switch (type) {
            case 0:
                Text text = JSON.toJavaObject(jsonObject, Text.class);
                printText(text);
                break;
            case 1:
                BarCode barCode = JSON.toJavaObject(jsonObject, BarCode.class);
                printBarCode(barCode);
                break;
            case 2:
                QrCode qrCode = JSON.toJavaObject(jsonObject, QrCode.class);
                printQrCode(qrCode);
                break;
            case 3:
                Image image = JSON.toJavaObject(jsonObject, Image.class);
                printImage(image);
                break;
        }
    }

    /**
     * 打印纯文本
     *
     * @param text  文本内容
     * @throws IOException
     */
    private static void printText(Text text) throws IOException {
        escPos.align(text.getFormat())
                .bold(text.isBold())
                .underline(text.isUnderline())
                .size(text.getSize())
                .printStr(text.getText())
                .boldOff(text.isBold())
                .underlineOff(text.isUnderline())
                .sizeReset()
                .line(text.getLine());
    }

    /**
     * 打印条形码
     *
     * @param barCode   条形码内容
     * @throws IOException
     */
    private static void printBarCode(BarCode barCode) throws IOException {
        escPos.align(barCode.getFormat())
                .barCode(barCode.getText())
                .line(barCode.getLine());
    }

    /**
     * 打印二维码
     *
     * @param qrCode   二维码内容
     * @throws IOException
     */
    private static void printQrCode(QrCode qrCode) throws IOException {
        escPos.qrCode(qrCode.getFormat(), qrCode.getText())
                .line(qrCode.getLine());
    }

    /**
     * 打印图片
     *
     * @param image  图片内容
     * @throws IOException
     */
    private static void printImage(Image image) throws IOException {
        escPos.align(image.getFormat())
                .image(image.getPath())
                .line(image.getLine());
        escPos.init();
    }

    /**
     * 打印商品小票的列名
     *
     * @param goods
     * @throws IOException
     */
    private static void printTitle(Goods goods) throws IOException {
        escPos.align(goods.getFormat())
                .bold(false)
                .underline(false)
                .size(1)
                .printStr(fillLength(goods.getName(), goods))
                .boldOff(false)
                .underlineOff(false)
                .sizeReset()
                .line(0);
    }

    /**
     * 循环打印商品信息
     *
     * @param goods
     * @param goodsList
     * @throws IOException
     */
    private static void printGoods(Map<String, Object> goods, List<Goods> goodsList) throws IOException {
        for (Goods ele : goodsList) {
            escPos.align(ele.getFormat())
                    .bold(false)
                    .underline(false)
                    .size(1)
                    .printStr(fillLength(goods.get(ele.getVariable()).toString(), ele))
                    .boldOff(false)
                    .underlineOff(false)
                    .line(0);
        }
        escPos.line(1);
    }

    /**
     * 填充打印文本长度
     *
     * @param str
     * @param goods
     * @return
     */
    private static String fillLength(String str, Goods goods) {
        try {
            int width = goods.getWidth();
            int length = str.getBytes(encoding).length;
            switch (goods.getFormat()) {
                case 0: {
                    while (length < width) {
                        str += " ";
                        length++;
                    }
                    break;
                }
                case 1: {
                    if (length < width) {
                        String text = "";
                        int pre = (width - length) / 2;
                        int end = width - length - pre;
                        while (pre > 0) {
                            text += " ";
                            pre--;
                        }
                        while (end > 0) {
                            str += " ";
                            end--;
                        }
                        str = text + str;
                    }
                    break;
                }
                case 2: {
                    String text = "";
                    while (length < width) {
                        text += " ";
                        length++;
                    }
                    str = text + str;
                    break;
                }
                default:
                    break;
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return str;
    }

    public static void main(String[] args) throws IOException {
        // 获取EscPos实例
        EscPos.getInstance(IP_TM_T82III);
        // 根据模板内容和打印参数执行打印命令
        EscPos.print(TMP, PARAMS);

    }



}
