package com.practice.springwebquick.controller;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class KafkaProducerDemo {
    public static void main(String[] args) {
        // 1. 配置生产者参数
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"192.168.1.100:9092");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        props.put(ProducerConfig.ACKS_CONFIG,"all"); // 最高可靠性
        props.put(ProducerConfig.RETRIES_CONFIG,3); // 重试次数

        // 2. 创建生产者实例
        try(
                KafkaProducer<String, String> producer = new KafkaProducer<>(props))

        {
            // 3. 发送消息
            for (int i = 0; i < 10; i++) {
                String key = "key-" + i;
                String value = "message-" + i;
                ProducerRecord<String, String> record = new ProducerRecord<>("test_topic", key, value);
                // 同步发送（也可使用send(record, callback)异步发送）
                producer.send(record).get();
                System.out.println("发送消息成功：" + key + " -> " + value);
            }
        } catch(
                Exception e)

        {
            e.printStackTrace();
        }
    }

}

