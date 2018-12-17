package com.anythy.zkconfigserver.util;

import com.anythy.base.common.utils.JsonHelper;
import com.anythy.zkconfigserver.entity.Properties;
import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;
import org.apache.zookeeper.version.util.VerGen;

import java.io.IOException;

/**
 * @author Leach
 */
public class ZookeeperUtil {
    public static void main(String[] args) {
        try {
            ZooKeeper zk = new ZooKeeper("140.143.236.179:2181", 30000, (event) -> {
                System.out.println("connection success");
            });
//            zk.create("/test", "ttttt".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);

            Properties properties = new Properties();
            properties.setData("测试数据");
            properties.setPath("ppppp");

            zk.setData("/test", JsonHelper.toJSON(properties).getBytes(), Version.REVISION);
            Stat stat = new Stat();
            byte[] bytes = zk.getData("/test", true, stat);
            Properties p = new Properties();
            zk.getData("/test", true, (v1, v2, v3, v4, v5) -> {
                System.out.println(v1);
                System.out.println(v2);
                System.out.println(v3);
                System.out.println(v4);
                System.out.println(v5);
            }, p);
            p = JsonHelper.fromJSON(new String(bytes), Properties.class);
            System.out.println(p);
            System.out.println(stat);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        }
    }
}
