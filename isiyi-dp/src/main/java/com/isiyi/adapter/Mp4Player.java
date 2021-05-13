package com.isiyi.adapter;

/**
 * 类描述
 * <p></p>
 *
 * @version 1.0.0
 * @description: Mp4Player
 * @author: 向鹏飞
 * @since: 2021/5/13
 */
public class Mp4Player implements AdvancedMediaPlayer{

    @Override
    public void playVlc(String fileName) {
        //什么也不做
    }

    @Override
    public void playMp4(String fileName) {
        System.out.println("Playing mp4 file. Name: "+ fileName);
    }
}
