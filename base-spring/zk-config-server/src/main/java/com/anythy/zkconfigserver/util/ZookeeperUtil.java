package com.anythy.zkconfigserver.util;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;

/**
 * @author Leach
 */
public class ZookeeperUtil {
    public static void main(String[] args) {
        try {
            ZooKeeper zk = new ZooKeeper("127.0.0.1:2181", 3000, (event) -> {
                System.out.println("connection success");
            });
            zk.create("/test", "ttttt".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            System.out.println(zk);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        }
    }
}
