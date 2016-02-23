package com;


import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletException;
import java.io.File;

//@ComponentScan("com")
public class TomcatMain {

    public static void main(String[] args) throws LifecycleException, InterruptedException, ServletException {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.scan("com");


        Tomcat tomcat = new Tomcat();
        tomcat.setPort(9090);

        //File base = new File("");
        Context rootCtx = tomcat.addContext("/", new File("").getAbsolutePath());
        //System.out.println(base.getAbsolutePath());

        //AppCon appCon = new AppCon();

        DispatcherServlet dispatcher = new DispatcherServlet(context);
        Tomcat.addServlet(rootCtx, "SpringMVC", dispatcher);
        rootCtx.addServletMapping("/*", "SpringMVC");


        tomcat.start();

        tomcat.getServer().await();

    }
}