package com.isiyi.printer.constant;

/**
 * 打印机常量
 * <p></p>
 *
 * @version 1.0.0
 * @description: 打印机常量
 * @author: 向鹏飞
 * @since: 2021/4/28
 */
public class PrinterConstant {
    private PrinterConstant(){}

    /**
     * 默认编码
     */
    public final static String DEFAULT_ENCODING = "GBK";

    /**
     * 默认端口
     */
    public final static int DEFAULT_PORT = 9100;

    public final static String KEYS = "keys";

    /**
     * 替换占位符的正则表达式
     */
    public final static String REPLACE_PATTERN = "\\{\\$(.+?)\\}";

    public final static  String IP_TM_T82III="192.168.197.75";

    public final static  String IP_TM_T82II="192.168.197.82";

    public final static  String IP_TM_U288="192.168.197.74";

    public final static  String IP_XY_C2008="192.168.197.77";

    public final static  String IP_BY_BTPU80="192.168.197.78";

    public final static  String IP_XY_C300H="192.168.197.80";

    public final static  String IP_SPRT_POS88="192.168.197.76";


    public final String LEFT = "LEFT";

    public final String CENTER = "CENTER";

    public final String RIGHT = "RIGHT";

    public static final byte HT = 0x9;

    public static final byte LF = 0x0A;

    public static final byte CR = 0x0D;

    public static final byte ESC = 0x1B;

    public static final byte DLE = 0x10;

    public static final byte GS = 0x1D;

    public static final byte FS = 0x1C;

    public static final byte STX = 0x02;

    public static final byte US = 0x1F;

    public static final byte CAN = 0x18;

    public static final byte CLR = 0x0C;

    public static final byte EOT = 0x04;

    /* 初始化打印机 */

    public static final byte[] ESC_INIT = new byte[] {ESC, '@'};

    /* 设置标准模式 */

    public static final byte[] ESC_STANDARD = new byte[] {ESC, 'S'};

    /* 设置汉字打印模式 */

    public static final byte[] ESC_CN_FONT = new byte[] {FS, '&'};

    /* 选择字符集 */

    public static final byte[] ESC_SELECT_CHARACTER = new byte[] {ESC, 'R', 9};

    /* 设置用户自定义汉字字体 焗7118 */

    public static final byte[] ESC_FS_2 = new byte[] {FS, 0x32, 0x71, 0x18};

    /* 取消用户自定义字体 */

    public static final byte[] ESC_CANCEL_DEFINE_FONT = new byte[]{ESC, '%', 0};

    /* 打开钱箱指令 */

    public static final byte[] ESC_OPEN_DRAWER = new byte[]{ESC, 'p', 0x00, 0x10, (byte) 0xff};

    /* 切纸指令GS V m

     * m  0,48 Executes a full cut(cuts the paper completely)

     *    1,49 Excutes a partilal cut(one point left uncut)

     */

    public static final byte[] POS_CUT_MODE_FULL = new byte[]{GS, 'V', 0x00};

    public static final byte[] POS_CUT_MODE_PARTIAL = new byte[]{GS, 'V', 0x01};

    /* 西文字符 (半宽)字体A (6 ×12)，汉字字符 (全宽)字体A (12×12) */

    public static final byte[] ESC_FONT_A = new byte[]{ESC, '!', 0};

    /* 西文字符 (半宽)字体B (8×16)，汉字字符 (全宽)字体B (16×16) */

    public static final byte[] ESC_FONT_B = new byte[]{ESC, '!', 1};

    /* 12*24   0/48*/

    public static final byte[] ESC_FONTA= new byte[]{ESC, 'M', 48};

    /* 9*17    1/49*/

    public static final byte[] ESC_FONTB= new byte[]{ESC, 'M', 1};

    /* 默认颜色字体指令 */

    public static final byte[] ESC_FONT_COLOR_DEFAULT = new byte[] {ESC, 'r', 0x00};

    /* 红色字体指令 */

    public static final byte[] ESC_FONT_COLOR_RED = new byte[] {ESC, 'r', 0x01 };

    /* 标准大小 */

    public static final byte[] FS_FONT_ALIGN = new byte[]{FS, 0x21, 1, ESC, 0x21, 1};

    /* 横向放大一倍 */

    public static final byte[] FS_FONT_ALIGN_DOUBLE = new byte[]{FS, 0x21, 4, ESC, 0x21, 4};

    /* 纵向放大一倍 */

    public static final byte[] FS_FONT_VERTICAL_DOUBLE = new byte[]{FS, 0x21, 8, ESC, 0x21, 8, GS, '!', 0x01};

    /* 横向纵向都放大一倍 */

    public static final byte[] FS_FONT_DOUBLE = new byte[]{FS, 0x21, 12, ESC, 0x21, 48};

    /* 靠左打印命令 */

    public static final byte[] ESC_ALIGN_LEFT = new byte[]{0x1b,'a', 0x00};

    /* 居中打印命令 */

    public static final byte[] ESC_ALIGN_CENTER = new byte[]{0x1b,'a', 0x01};

    /* 靠右打印命令 */

    public static final byte[] ESC_ALIGN_RIGHT = new byte[]{0x1b,'a', 0x02};

    /* 字体加粗 */

    public static final byte[] ESC_SETTING_BOLD = new byte[]{ESC, 0x45, 1};

    /* 取消字体加粗 */

    public static final byte[] ESC_CANCEL_BOLD = new byte[]{ESC, 0x45, 0};

    //DLE EOT n 实时状态传送

    //如果返回结果为22

    /**

     * 、DLE EOT n 实时状态传送

     [格式] ASCII码 DLE EOT n

     十六进制码 10 04 n

     十进制码 16 4 n

     [范围] 1 ≤ n ≤ 4

     [描述] 根据下列参数，实时传送打印机 状态，参数 n 用来指定所要传送的打印机状态：

     n = 1：传送打印机状态

     n = 2：传送脱机状态

     n = 3：传送错误状态

     n = 4：传送纸传感器状态

     [注释] 打印机收到该命令后立即返回相关状态

     该命令尽量不要插在2个或更多字节的命令序列中。

     即使打印机被ESC =(选择外设)命令设置为禁止，该命令依然有效。

     打印机传送当前状态，每一状态用1个字节数据表示。

     打印机传送状态时并不确认主机是否收到。

     打印机收到该命令立即执行。

     该命令只对串口打印机有效。打印机在任何状态下收到该命令都立即执行。

     */
    public static final byte[] PRINT_STATE_DLE_EOT = new byte[] {DLE, EOT,0x01};

    public static final char[] END_CUT = new char[]{GS, 86, 65, 0};
}
