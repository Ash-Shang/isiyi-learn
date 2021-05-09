package com.isiyi.builder;

import org.junit.Test;

import java.beans.Transient;

/**
 * 类描述
 * <p></p>
 *
 * @version 1.0.0
 * @description: 类描述
 * @author: siyi
 * @since: 2021/5/9
 */
public class ResourcePoolConfigTest {

    @Test
    public void testResourcePoolConfigInDp(){
        ResourcePoolConfigInDp dbconnectionpool = new ResourcePoolConfigInDp.Builder()
                .setName("dbconnectionpool")
                .setMaxTotal(16)
                .setMaxIdle(10)
                .setMinIdle(10)
                .build();
    }

}
