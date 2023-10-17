package com.learner.leetcodelearner.lib.utils;

import cn.hutool.core.util.IdUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;

@Slf4j
@Component
public class SseUtil {

    private static final Map<Long, SseEmitter> sseEmitterMap = new ConcurrentHashMap<>();

    /**
     * 创建连接
     */
    public SseEmitter connect(Long userId, Consumer<Throwable> errorCallback,Runnable timeOutCallback) {
        if (sseEmitterMap.containsKey(userId)) {
            SseEmitter sseEmitter =sseEmitterMap.get(userId);
            sseEmitterMap.remove(userId);
            sseEmitter.complete();
        }
        try {
            // 设置超时时间，0表示不过期。默认30秒
            SseEmitter sseEmitter = new SseEmitter(5*60*1000L);
            sseEmitter.send(SseEmitter.event().id(IdUtil.simpleUUID()).reconnectTime(1*60*1000L).data(""));
            // 注册回调
            sseEmitter.onCompletion(() -> {
            });
            sseEmitter.onError(errorCallback);
            sseEmitter.onTimeout(timeOutCallback);
            sseEmitterMap.put(userId, sseEmitter);
            log.info("创建sse连接完成，当前用户：{}", userId);
            return sseEmitter;
        } catch (Exception e) {
            log.info("创建sse连接异常，当前用户：{}", userId);
        }
        return null;
    }

    /**
     * 给指定用户发送消息
     *
     */
    public boolean sendMessage(Long userId,String messageId, String message) {
        if (sseEmitterMap.containsKey(userId)) {
            SseEmitter sseEmitter = sseEmitterMap.get(userId);
            try {
                sseEmitter.send(SseEmitter.event().id(messageId).reconnectTime(1*60*1000L).data(message));
                log.info("用户{},消息id:{},推送成功:{}", userId,messageId, message);
                return true;
            }catch (Exception e) {
                sseEmitterMap.remove(userId);
                log.info("用户{},消息id:{},推送异常:{}", userId,messageId, e.getMessage());
                sseEmitter.complete();
                return false;
            }
        }else {
            log.info("用户{}未上线", userId);
        }
        return false;
    }

    /**
     * 断开
     * @param userId
     */
    public void removeUser(Long userId){
        if (sseEmitterMap.containsKey(userId)) {
            SseEmitter sseEmitter = sseEmitterMap.get(userId);
            sseEmitterMap.remove(userId);
            sseEmitter.complete();
        }else {
            log.info("用户{} 连接已关闭",userId);
        }

    }

    private static final Map<String, SseEmitterUtf8> SSE_CACHE = new ConcurrentHashMap<>();


    public SseEmitterUtf8 getConn(String clientId) {
        final SseEmitterUtf8 sseEmitter = SSE_CACHE.get(clientId);

        if (sseEmitter != null) {
            return sseEmitter;
        } else {
            // 设置连接超时时间，需要配合配置项 spring.mvc.async.request-timeout: 600000 一起使用
            final SseEmitterUtf8 emitter = new SseEmitterUtf8(600_000L);
            // 注册超时回调，超时后触发
            emitter.onTimeout(() -> {
                log.info("连接已超时，正准备关闭，clientId = {}", clientId);
                SSE_CACHE.remove(clientId);
            });
            // 注册完成回调，调用 emitter.complete() 触发
            emitter.onCompletion(() -> {
                log.info("连接已关闭，正准备释放，clientId = {}", clientId);
                SSE_CACHE.remove(clientId);
                log.info("连接已释放，clientId = {}", clientId);
            });
            // 注册异常回调，调用 emitter.completeWithError() 触发
            emitter.onError(throwable -> {
                log.error("连接已异常，正准备关闭，clientId = {}", clientId, throwable);
                SSE_CACHE.remove(clientId);
            });

            SSE_CACHE.put(clientId, emitter);

            return emitter;
        }
    }

    /**
     * 模拟类似于 chatGPT 的流式推送回答
     *
     * @param clientId 客户端 id
     * @throws IOException 异常
     */
    public void send(String clientId) throws IOException, InterruptedException {
        final SseEmitterUtf8 emitter = SSE_CACHE.get(clientId);
        for(;;){
            // 推流内容到客户端
            emitter.send("此去经年", org.springframework.http.MediaType.APPLICATION_JSON);
            emitter.send("此去经年，应是良辰好景虚设");
            emitter.send("此去经年，应是良辰好景虚设，便纵有千种风情");
            emitter.send("此去经年，应是良辰好景虚设，便纵有千种风情，更与何人说");
            Thread.sleep(5000);
        }
        // 结束推流
//        emitter.complete();
    }

    public void closeConn(String clientId) {
        final SseEmitterUtf8 sseEmitter = SSE_CACHE.get(clientId);
        if (sseEmitter != null) {
            sseEmitter.complete();
        }
    }


}