package com.anythy.zkconfigserver.util;

import com.anythy.base.common.utils.JsonHelper;
import com.anythy.zkconfigserver.entity.PropertiesVo;
import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

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

            PropertiesVo properties = new PropertiesVo();
            properties.setKey("测试数据");
            properties.setRemark("ppppp");

            zk.setData("/test", JsonHelper.toJSON(properties).getBytes(), Version.REVISION);
            Stat stat = new Stat();
            byte[] bytes = zk.getData("/test", true, stat);
            PropertiesVo p = new PropertiesVo();
            zk.getData("/test", true, (v1, v2, v3, v4, v5) -> {
                System.out.println(v1);
                System.out.println(v2);
                System.out.println(v3);
                System.out.println(v4);
                System.out.println(v5);
            }, p);
            p = JsonHelper.fromJSON(new String(bytes), PropertiesVo.class);
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
