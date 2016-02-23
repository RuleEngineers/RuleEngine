//package com;
//
//import org.apache.catalina.Context;
//import org.apache.catalina.LifecycleException;
//import org.apache.catalina.startup.Tomcat;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.File;
//import java.io.IOException;
//import java.io.Writer;
//
//public class Main {
//
//    public static void main(String[] args) throws LifecycleException, InterruptedException, ServletException {
//        System.out.println("Start of main..");
//        Tomcat tomcat = new Tomcat();
//        tomcat.setPort(9090);
//
//        Context ctx = tomcat.addContext("/", new File("").getAbsolutePath());
//
//        AppCon appCon = new AppCon();
//
//        appCon.applicationContext
//
//        File base = new File("");
//        System.out.println(base.getAbsolutePath());
//        Context rootCtx = tomcat.addContext("", base.getAbsolutePath());
//        AnnotationConfigWebApplicationContext aactx = new AnnotationConfigWebApplicationContext();
//        aactx.scan("com.myapp");
//        aactx.register(MvcConfig.class);
//        DispatcherServlet dispatcher = new DispatcherServlet(ctx);
//        Tomcat.addServlet(rootCtx, "SpringMVC", dispatcher);
//        rootCtx.addServletMapping("/*", "SpringMVC");
//        tomcat.start();
//
//        Tomcat.addServlet(ctx, "hello", new HttpServlet() {
//            protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//                Writer w = resp.getWriter();
//                w.write("Hello, World!");
//                w.flush();
//            }
//        });
//        ctx.addServletMapping("/*", "hello");
//
//
//
//        tomcat.start();
//        tomcat.getServer().await();
//        //tomcat.getService().stop();
//        //tomcat.stop();
//        //tomcat.destroy();
//   }
//
//}
