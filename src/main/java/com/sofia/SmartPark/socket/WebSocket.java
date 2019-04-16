package com.sofia.SmartPark.socket;

import com.sofia.SmartPark.servlet.ParkServlet;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.annotation.SendToUser;

import java.io.IOException;

import java.sql.SQLException;
import java.util.concurrent.ConcurrentHashMap;
import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import static com.sofia.SmartPark.servlet.ParkServlet.messageFromImg;

/**
*@Author: Sofia
*@Email: feng-sofia@foxmail.com
*@Date: 2019/4/15 9:49
*@Description:  @ServerEndpoint 注解是一个类层次的注解，它的功能主要是将目前的类定义成一个websocket服务器端,
 *  * 注解的值将被用于监听用户连接的终端访问URL地址,客户端可以通过这个URL来连接到WebSocket服务器端
*/
@ServerEndpoint("/websocket/{userName}")
public class WebSocket {
    //静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
    private static int onlineCount = 0;

    //concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。若要实现服务端与单一客户端通信的话，可以使用Map来存放，其中Key可以为用户标识
    private static ConcurrentHashMap<String,WebSocket> webSocketSet = new ConcurrentHashMap<>();

    private String userName = "";

    //与某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;

    /**
     * 连接建立成功调用的方法
     * @param session  可选的参数。session为与某个客户端的连接会话，需要通过它来给客户端发送数据
     */
    @OnOpen
    public void onOpen(@PathParam(value = "userName") String param, Session session){

        System.out.println(userName);
        userName = param;
        this.session = session;
        webSocketSet.put(userName,this);     //加入set中
        addOnlineCount();           //在线数加1
        System.out.println("有新连接加入！当前在线人数为" + getOnlineCount());

    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose(){
        if (!userName.equals(""))
        webSocketSet.remove(userName);  //从set中删除
        subOnlineCount();           //在线数减1
        System.out.println("有一连接关闭！当前在线人数为" + getOnlineCount());
    }

    /**
     * 收到客户端消息后调用的方法
     * @param message 客户端发送过来的消息
     * @param session 可选的参数
     */
    @OnMessage
    public void onMessage(String message, Session session) throws Exception{

        System.out.println("来自客户端的消息:" + message);
        if (messageFromImg != ""){
            sendMessage(message,session);
            messageFromImg = "";
        }

    }


//    @SendToUser("")
//    public void sendToUser(Session session){
//        if (messageFromImg != "")
//            try {
//                this.session.getBasicRemote().sendText(messageFromImg);
//            }catch (Exception e){
//                e.printStackTrace();
//            }
//
//    }
    /**
     * 发生错误时调用
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error){
        System.out.println("发生错误");
        error.printStackTrace();
    }

    /**
     * 这个方法与上面几个方法不一样。没有用注解，是根据自己需要添加的方法。
     * @param nameFromWeb
     * @throws IOException
     */
    /*
    * 从前端接收的nameFromWeb，根据这个name原路返回消息给该用户
    * */
//    public void sendToUser(String nameFromWeb) throws IOException{
//
//        try {
//            if (webSocketSet.containsKey(nameFromWeb)){
//                webSocketSet.get(nameFromWeb).sendMessage(nameFromWeb);
//            }else{
//                System.out.println("当前用户不在线");
//            }
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//
//    }

//   /* public void sendAll(String message){
//
//        *//**
//        *@Description: 给所有用户发消息
//        *@params: [message]
//        *@return: void
//        **//*
//        for (String key : webSocketSet.keySet()){
//            try {
//                if (!userName.equals(key)){
//                    webSocketSet.get(key).sendMessage("用户" + userName + "");
//                }
//            }catch (IOException e){
//
//                e.printStackTrace();
//            }
//        }
//
//    }
//*/
    /**
     * 这个方法与上面几个方法不一样。没有用注解，是根据自己需要添加的方法。
     * @param nameFromWeb
     * @throws IOException
     */
    public void sendMessage(String nameFromWeb, Session session) throws IOException {

        System.out.println(messageFromImg);
        //  this.session.getBasicRemote().sendText(ParkServlet.messageFromImg);
        this.session.getAsyncRemote().sendText(messageFromImg);
    }


    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    public static synchronized void addOnlineCount() {
        WebSocket.onlineCount++;
    }

    public static synchronized void subOnlineCount() {
        WebSocket.onlineCount--;
    }
}

