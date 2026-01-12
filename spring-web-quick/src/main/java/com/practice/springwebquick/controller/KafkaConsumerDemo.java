package com.practice.springwebquick.controller;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

public class KafkaConsumerDemo {
    public static void main(String[] args) {
        // 1. 配置消费者参数
        Properties props = new Properties();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.1.100:9092");
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "group1"); // 消费者组ID
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest"); // 无offset时从开头消费
        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false); // 关闭自动提交，手动控制

        // 2. 创建消费者实例
        try (KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props)) {
            // 3. 订阅主题
            consumer.subscribe(Collections.singletonList("test_topic"));

            // 4. 循环拉取消息
            while (true) {
                ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));
                for (ConsumerRecord<String, String> record : records) {
                    System.out.printf("消费消息：topic=%s, partition=%d, offset=%d, key=%s, value=%s%n",
                            record.topic(), record.partition(), record.offset(), record.key(), record.value());
                }
                // 手动提交offset（消息处理完成后提交）
                consumer.commitSync();
            }
        }
    }
}
