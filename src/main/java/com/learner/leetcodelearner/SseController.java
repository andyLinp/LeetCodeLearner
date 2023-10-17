package com.learner.leetcodelearner;

import com.learner.leetcodelearner.lib.utils.SseEmitterUtf8;
import com.learner.leetcodelearner.lib.utils.SseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

/**
 * @Description
 * @Author: andy lin
 * @DATE: 2023/9/6
 */
@Slf4j
@Controller
public class SseController {
    @Autowired
    SseUtil sseUtil;


    @RequestMapping(value = "/push", produces = "text/event-streams")
    public @ResponseBody String push(){
        Random r = new Random();
        try {
            log.info("push time:{}", System.currentTimeMillis());
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "data: Testing 1, 2, 3" + r.nextInt() + "\n\n";
    }

    @RequestMapping(value = "/sse", produces = "text/event-streams")
    public  SseEmitter sse(Long userId, String msgId, String msg){
        SseEmitter connect = sseUtil.connect(userId, str -> System.out.println(str), ()->{
            System.out.println("调用超时");
        });
        sseUtil.sendMessage(userId, msgId, msg);
        return connect;
    }


    @GetMapping(value = "/test/{clientId}", produces = {MediaType.TEXT_EVENT_STREAM_VALUE})
    public SseEmitterUtf8 test(@PathVariable("clientId") String clientId) {
        final SseEmitterUtf8 emitter = sseUtil.getConn(clientId);

        CompletableFuture.runAsync(() -> {
            try {
                sseUtil.send(clientId);
            } catch (Exception e) {
                throw new RuntimeException("推送数据异常");
            }
        });

        return emitter;
    }

    @GetMapping("/closeConn/{clientId}")
    public String closeConn(@PathVariable("clientId") String clientId) {
        sseUtil.closeConn(clientId);
        return "连接已关闭";
    }

}
