package com.isiyi.command;

/**
 * 类描述
 * <p></p>
 *
 * @version 1.0.0
 * @description: 类描述
 * @author: siyi
 * @since: 2021/5/12
 */
public class GotDiamondCommand implements Command {
    String data;
    public GotDiamondCommand(String data){
        this.data = data;
    }
    @Override
    public void execute() {
        // dom something for data
    }
}
