package com.example.demo;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import redis.clients.jedis.*;

import java.util.HashSet;
import java.util.Set;

@SpringBootTest
public class Readis {
    @Test
    public void test1(){
        Jedis jedis=new Jedis("192.168.133.1",6379);
        jedis.set("name","bar");
        String name=jedis.get("name");
        System.out.println(name);
        jedis.close();
    }
    @Test
    public void poll(){
        JedisPoolConfig config=new JedisPoolConfig();
        //最大连接数
        config.setMaxTotal(30);
        //最大空闲连接数
        config.setMaxIdle(2);

        JedisPool pool=new JedisPool("192.168.133.1",6379);
        //从连接池获取一个链接
        Jedis jedis=pool.getResource();
        jedis.set("456","789");
        String name=jedis.get("456");
        System.out.println(name);
        jedis.close();

    }
    @Test
    public void JedisCluster(){
        JedisPoolConfig config=new JedisPoolConfig();
        //最大连接数
        config.setMaxTotal(30);
        //最大空闲连接数
        config.setMaxIdle(2);
        //集群结点
        Set<HostAndPort> jedisClusterNode = new HashSet<HostAndPort>();
        jedisClusterNode.add(new HostAndPort("192.168.133.1", 7001));
        jedisClusterNode.add(new HostAndPort("192.168.133.1", 7002));
        jedisClusterNode.add(new HostAndPort("192.168.133.1", 7003));
        jedisClusterNode.add(new HostAndPort("192.168.133.1", 7004));
        jedisClusterNode.add(new HostAndPort("192.168.133.1", 7005));
        jedisClusterNode.add(new HostAndPort("192.168.133.1", 7006));
        JedisCluster jc = new JedisCluster(jedisClusterNode, config);

        JedisCluster jcd = new JedisCluster(jedisClusterNode);
        jcd.set("name", "zhangsan");
        String value = jcd.get("name");
        System.out.println(value);
    }
}
