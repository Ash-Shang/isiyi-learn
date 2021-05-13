package com.isiyi.adapter;

/**
 * 类描述
 * <p></p>
 *
 * @version 1.0.0
 * @description: VlcPlayer
 * @author: 向鹏飞
 * @since: 2021/5/13
 */
public class VlcPlayer implements AdvancedMediaPlayer{
    @Override
    public void playVlc(String fileName) {
        System.out.println("Playing vlc file. Name: "+ fileName);
    }

    @Override
    public void playMp4(String fileName) {
        //什么也不做
    }
}
