package com.isiyi.netty.rpc;

/**
 * 这个是接口，是服务提供方和 服务消费方都需要
 * <p></p>
 *
 * @version 1.0.0
 * @description: 类描述
 * @author: siyi
 * @since: 2021/5/9
 */
public interface HelloService {

    String hello(String mes);
}
