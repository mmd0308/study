package com.hzqing.netty.bio.tomcat;

import com.hzqing.netty.bio.tomcat.http.HZQRequest;
import com.hzqing.netty.bio.tomcat.http.HZQResponse;
import com.hzqing.netty.bio.tomcat.http.HZQServlet;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author hzqing
 * @date 2019-12-16 08:07
 */
public class TomcatApplication {


    private int port = 8080;

    private ServerSocket server;

    /**
     * 解析web.properties，存储到map中
     */
    private Map<String, HZQServlet> servletMapping = new HashMap<>();

    private Properties webxml = new Properties();

    private void init(){
        // 加载web.xml文件，同步初始化servletMapping对象
        try{
            final String path = this.getClass().getResource("/").getPath();
            final FileInputStream inputStream = new FileInputStream(path + "bio/tomcat/web.properties");
            // 2。web.xml 文件  servlet-name  servlet-class url-pattern
            webxml.load(inputStream);
            // 解析web.properties文件
            for(Object k : webxml.keySet()){
                final String key = k.toString();
                if (key.endsWith(".url")){
                    String servletName = key.replaceAll("\\.url$", "");
                    // 获取请求路径url
                    String url = webxml.getProperty(key);
                    // 获取对应url的servlet
                    String className = webxml.getProperty(servletName + ".className");
                    // servlet是单实例，多线程
                    // 通过反射实例化Servlet
                    HZQServlet obj = (HZQServlet) Class.forName(className).getConstructor().newInstance();

                    // 3. 读取配置文件 url-pattern 和servlet建立映射关系
                    servletMapping.put(url,obj);
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void start() {
        // 1、初始化，解析web.propertis文件
        init();

        try {
            // 4. 配置好端口  默认端口是8080  ServerSocket IP:localhost
            server = new ServerSocket(this.port);
            System.out.println("Tomcat 启动，监听端口是： " + this.port);

            // 等待用户请求，用一个死循环来等待用户请求
            while (true){
                final Socket client = server.accept();
                // 5. Http请求，发送的数据就是字符串 HTTP协议
                process(client);
            }

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void process(Socket client) {
        try {
            InputStream inputStream = client.getInputStream();
            OutputStream outputStream = client.getOutputStream();
            // 6. Request/Response

            // 创建request
            HZQRequest request = new HZQRequest(inputStream);

            // 创建response
            HZQResponse response = new HZQResponse(outputStream);

            // http请求的url路径
            String url = request.getUrl();

            if (servletMapping.containsKey(url)){
                // 调用该url对应的service方法
                // 7. 调用实例的servie方法，执行具体的逻辑
                servletMapping.get(url).service(request,response);
            }else {
                response.write("404 -- Not Found");
            }

            outputStream.flush();
            outputStream.close();

            inputStream.close();
            client.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new TomcatApplication().start();
    }

}
