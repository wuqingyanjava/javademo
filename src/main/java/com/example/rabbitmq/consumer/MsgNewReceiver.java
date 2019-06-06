package com.example.rabbitmq.consumer;

import com.example.rabbitmq.RabbitConfig;
import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Description 另一种消费机制 确认机制
 * @Author wuqingyan
 * Date 2019/6/6 15:15
 * Modify Log
 **/
@Component
public class MsgNewReceiver {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @RabbitListener(queues = {RabbitConfig.QUEUE_C})
    public void onMessage(Message message, Channel channel) throws Exception {
        channel.basicQos(1);
        byte[] body = message.getBody();
        logger.info("接收处理队列A或B当中的消息:" + new String(body));
        /**为了保证永远不会丢失消息，RabbitMQ支持消息应答机制。
         当消费者接收到消息并完成任务后会往RabbitMQ服务器发送一条确认的命令，然后RabbitMQ才会将消息删除。*/
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
    }
}
