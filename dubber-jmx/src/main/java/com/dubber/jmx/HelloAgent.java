package com.dubber.jmx;

import javax.management.*;
import javax.management.remote.JMXConnectorServer;
import javax.management.remote.JMXConnectorServerFactory;
import javax.management.remote.JMXServiceURL;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Created on 2018/5/21.
 *
 * @author dubber
 */
public class HelloAgent {
    public static void main(String[] args) throws MalformedObjectNameException, NotCompliantMBeanException, InstanceAlreadyExistsException, MBeanRegistrationException, IOException {
        //首先建立一个MBeanServer，MBeanServer用来管理我们的MBean，通常是通过MBeanServer来获取我们MBean的信息
        MBeanServer server = ManagementFactory.getPlatformMBeanServer();
        //create object name
        ObjectName objectName = new ObjectName("jmxBean:name=hello");

        //create mbean and register mbean
        server.registerMBean(new Hello(), objectName);

        /**
         * JMXConnectorServer service
         */
        //这句话非常重要，不能缺少！注册一个端口，绑定url后，客户端就可以使用rmi通过url方式来连接JMXConnectorServer
        Registry registry = LocateRegistry.createRegistry(1099);

        //构造JMXServiceURL
        JMXServiceURL jmxServiceURL = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://localhost:1099/jmxrmi");
        //创建JMXConnectorServer
        JMXConnectorServer cs = JMXConnectorServerFactory.newJMXConnectorServer(jmxServiceURL, null, server);
        //启动
        cs.start();
        System.out.println("JMX server 已启动！");
    }
}
