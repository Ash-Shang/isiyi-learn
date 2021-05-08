package com.isiyi.printer;

import com.isiyi.printer.constant.PrinterConstant;
import com.isiyi.printer.template.*;
import org.junit.Test;

/**
 * 类描述
 * <p></p>
 *
 * @version 1.0.0
 * @description: EscPosTest
 * @author: 向鹏飞
 * @since: 2021/5/7
 */
public class EscPosTest {

    @Test
    public void testPrint(){
        try {
           // 获取EscPos实例
            EscPos.getInstance(PrinterConstant.IP_TM_T82III);
            // 根据模板内容和打印参数执行打印命令
            EscPos.print(TicketTestTemplateConstant.TEMPLATE, TicketTestTemplateConstant.PARAMS);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void testPrintServer(){
        try {
           // TicketTestTemplateConstant.print(TicketTestTemplateConstant.PARAMS);
            //FoodOrderTemplate.print(FoodOrderTemplate.PARAM);
            //RepairFoodOrderTemplate.print(RepairFoodOrderTemplate.PARAM);
            //InformLobbyLobbyTemplate.print(InformLobbyLobbyTemplate.PARAM);
           // InformKitchenTemplate.print(InformKitchenTemplate.PARAM);
            //ReturnLobbyTemplate.print(ReturnLobbyTemplate.PARAM);
            //ReturnKitchenTemplate.print(ReturnKitchenTemplate.PARAM);
           // BillLobbyTemplate.print(BillLobbyTemplate.PARAM);
            //MoneyLobbyTemplate.print(MoneyLobbyTemplate.PARAM);
            //RepairMoneyLobbyTemplate.print(RepairMoneyLobbyTemplate.PARAM);
            //RepairBillLobbyTemplate.print(RepairBillLobbyTemplate.PARAM);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
