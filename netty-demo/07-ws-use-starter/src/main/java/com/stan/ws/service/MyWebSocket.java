package com.stan.ws.service;

import io.netty.channel.ChannelId;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.timeout.IdleStateEvent;
import org.springframework.util.MultiValueMap;
import org.yeauty.annotation.*;
import org.yeauty.pojo.Session;

import java.io.IOException;
import java.util.Map;

/**
 * @author zengxp
 * @date 2022/1/21 15:50
 */
@ServerEndpoint(path = "/ws/{arg}", port = "9001")
public class MyWebSocket {

    @BeforeHandshake
    public void handshake(Session session, HttpHeaders headers, @RequestParam String req, @RequestParam MultiValueMap reqMap, @PathVariable String arg, @PathVariable Map pathMap) {
        session.setSubprotocols("stomp");
        if (!"ok".equals(req)) {
            System.out.println("Authentication failed!");
            session.close();
        } else {
            ChannelId channelId = session.id();
            System.out.println("channelId: " + channelId);
            System.out.println("arg: " + arg);
            System.out.println("reqMap: " + reqMap);
            System.out.println("pathMap: " + pathMap);
        }
    }

    @OnOpen
    public void onOpen(Session session, HttpHeaders headers, @RequestParam String req, @RequestParam MultiValueMap reqMap, @PathVariable String arg, @PathVariable Map pathMap) {
        System.out.println("new connection, arg=" + arg);
        ChannelId channelId = session.id();
        System.out.println("channelId: " + channelId);
        System.out.println("arg: " + arg);
        System.out.println("reqMap: " + reqMap);
        System.out.println("pathMap: " + pathMap);
        session.setAttribute("str", "a");
    }

    @OnClose
    public void onClose(Session session) throws IOException {
        System.out.println("one connection closed");
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        throwable.printStackTrace();
    }

    @OnMessage
    public void onMessage(Session session, String message) {
        System.out.println(message);
        session.sendText("Hello Netty!");
    }

    @OnBinary
    public void onBinary(Session session, byte[] bytes) {
        for (byte b : bytes) {
            System.out.println(b);
        }
        session.sendBinary(bytes);
    }

    @OnEvent
    public void onEvent(Session session, Object evt) {
        if (evt instanceof IdleStateEvent) {
            IdleStateEvent idleStateEvent = (IdleStateEvent) evt;
            switch (idleStateEvent.state()) {
                case READER_IDLE:
                    System.out.println("read idle");
                    break;
                case WRITER_IDLE:
                    System.out.println("write idle");
                    break;
                case ALL_IDLE:
                    System.out.println("all idle");
                    break;
                default:
                    break;
            }
        }
    }

}