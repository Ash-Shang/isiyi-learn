package com.isiyi.printer;



import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.isiyi.printer.constant.PrinterConstant;
import com.isiyi.printer.params.*;
import com.isiyi.printer.template.TicketTestTemplateConstant;


import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.util.List;
import java.util.Map;

/**
 * 打印机服务
 * <p></p>
 *
 * @version 1.0.0
 * @description: PrintServer
 * @author: 向鹏飞
 * @since: 2021/4/23
 */
public class PrintServer {

    private String encoding;
    private OutputStream socketOut = null;
    private OutputStreamWriter writer = null;

    private PrintServer(){}
    private PrintServer(String encoding, Socket socket) throws IOException{
        this.encoding = encoding;
        this.socketOut = socket.getOutputStream();
        this.writer = new OutputStreamWriter(this.socketOut, encoding);
    }

    /**
     * 获取对象实例
     *  指定ip, 默认端口：9100， 默认编码：GBK
     * <p></p>
     *
     * @param ipStr ip地址
     * @return
     * @author 向鹏飞
     * @version 1.0.0
     * @date 2021/4/23 16:57
     */
    public static PrintServer getInstance(String ipStr) throws IOException {
        return getInstance(ipStr, PrinterConstant.DEFAULT_PORT, PrinterConstant.DEFAULT_ENCODING);
    }
    /**
     * 获取对象实例
     * <p></p>
     *
     * @param ipStr ip地址
     * @param port 端口
     * @param codeType  编码类型
     * @return
     * @author 向鹏飞
     * @version 1.0.0
     * @date 2021/4/23 16:57
     */
    public static PrintServer getInstance(String ipStr, int port, String codeType) throws IOException {
        Socket socket = new Socket(ipStr, port);
        return new PrintServer(codeType, socket);
    }



    /**
     * 循环打印商品信息
     *
     * @param goods
     * @param goodsList
     * @throws IOException
     */
    public void printGoods(Map<String, Object> goods, List<Goods> goodsList) throws IOException {
        for (Goods ele : goodsList) {
            this.align(ele.getFormat())
                    .bold(false)
                    .underline(false)
                    .size(1)
                    .printStr(fillLength(goods.get(ele.getVariable()).toString(), ele))
                    .boldOff(false)
                    .underlineOff(false)
                    .line(0);
        }
        this.line(1);
    }
    /**
     * 打印任何对象
     *
     * @param jsonObject  需要输出对象
     * @throws IOException
     */
    public void print(JSONObject jsonObject) throws IOException {
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
     * 打印条形码
     *
     * @param barCode   条形码内容
     * @throws IOException
     */
    private void printBarCode(BarCode barCode) throws IOException {
        this.align(barCode.getFormat())
                .barCode(barCode.getText())
                .line(barCode.getLine());
    }

    /**
     * 打印图片
     *
     * @param image  图片内容
     * @throws IOException
     */
    private void printImage(Image image) throws IOException {
        this.align(image.getFormat())
                .image(image.getPath())
                .line(image.getLine());
        this.init();
    }

    /**
     * 打印图片
     *
     * @param path  图片地址
     * @return
     */
    private PrintServer image(String path) throws IOException {
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
    /**
     * 打印条形码
     *
     * @param value
     * @return
     * @throws IOException
     */
    private PrintServer barCode(String value) throws IOException {
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
     * @param qrCode   二维码内容
     * @throws IOException
     */
    private void printQrCode(QrCode qrCode) throws IOException {
        this.qrCode(qrCode.getFormat(), qrCode.getText())
                .line(qrCode.getLine());
    }
    /**
     * 打印商品小票的列名
     *
     * @param goods
     * @throws IOException
     */
    public void printTitle(Goods goods) throws IOException {
        this.align(goods.getFormat())
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
     * 填充打印文本长度
     *
     * @param str
     * @param goods
     * @return
     */
    private String fillLength(String str, Goods goods) {
        try {
            int width = goods.getWidth();
            int length = str.getBytes(this.encoding).length;
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
    /**
     * 打印二维码
     *
     * @param qrData
     * @return
     * @throws IOException
     */
    private PrintServer qrCode(int position, String qrData) throws IOException {


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
     * 打印纯文本
     *
     * @param text  文本内容
     * @throws IOException
     */
    public void printText(Text text) throws IOException {
        this.align(text.getFormat())
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
     * 打印字符串
     *
     * @param str 所需打印字符串
     * @return
     * @throws IOException
     */
    private PrintServer printStr(String str) throws IOException {
        writer.write(str);
        writer.flush();
        return this;
    }
    /**
     * 初始化打印机
     *
     * @return
     * @throws IOException
     */
    public PrintServer init() throws IOException {
        writer.write(0x1B);
        writer.write(0x40);
        writer.write(0x1C);
        writer.write('&');
        return this;
    }
    /**
     * 换行
     *
     * @param lineNum 换行数，0为不换行
     * @return
     * @throws IOException
     */
    public PrintServer line(int lineNum) throws IOException {
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
    private PrintServer underline(boolean flag) throws IOException {
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
    private PrintServer underlineOff(boolean flag) throws IOException {
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
    private PrintServer bold(boolean flag) throws IOException {
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
    private PrintServer boldOff(boolean flag) throws IOException {
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
     * @param align 0：居左(默认) 1：居中 2：居右
     * @return
     * @throws IOException
     */
    private PrintServer align(int  align) throws IOException {
        writer.write(0x1B);
        writer.write(97);
        writer.write(align);
        return this;
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
    private PrintServer size(int size) throws IOException {
      //  int fontSize = (size - 1) * 17;
        writer.write(0x1D);
        writer.write(33);
        writer.write(1);
        return this;
    }

    /**
     * 重置字体大小
     *
     * @return
     * @throws IOException
     */
    private PrintServer sizeReset() throws IOException {
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
    public PrintServer end() throws Exception{
        writer.write(PrinterConstant.END_CUT);
//        writer.write(0x1D);
//        writer.write(86);
//        writer.write(65);
//        writer.write(0);
        writer.flush();
        if(null != socketOut){
            socketOut.close();
        }
        if(null != writer){
            writer.close();
        }
        return this;
    }

}
