package com.isiyi.base.java4.unit7;

/**
 * @ClassName Test72_Chess
 * @Description 测试有参构造器
 * @Author Ash-Shang
 * @Date 2020/2/17 10:25
 * @Version 1.0
 */
public class Test72_Chess extends BoardGame {

    public Test72_Chess(int i){
        super(i);
    }


    public static void main(String[] args) {

    }
}

class Game{
    Game(int i){
        System.out.println("game");
    }
    Game(){

    }
}

class BoardGame extends Game{
    BoardGame(int i){
        //super(i);
        System.out.println("boadGame");
    }
}