package com.dream.ai.controller;

import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import reactor.core.publisher.Flux;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.chat.memory.InMemoryChatMemory;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author 北极星
 */
@RestController
@RequestMapping("/client")
public class DeepSeekChatClientController {

    private static final String DEFAULT_PROMPT = "你好，我想使用java语言获取到deepseek模型的思维链，有什么api可以给我调用吗";


    @Autowired
    private ChatClient DeepSeekChatClient;

//    private final ChatClient DeepSeekChatClient;
//
//    public DeepSeekChatClientController (@Qualifier("openAiChatModel") OpenAiChatModel chatModel) {
//
//        this.DeepSeekChatClient = ChatClient.builder(chatModel).defaultAdvisors(new MessageChatMemoryAdvisor(new InMemoryChatMemory()))
//                // 实现 Logger 的 Advisor
//                .defaultAdvisors(new SimpleLoggerAdvisor())
//                // 设置 ChatClient 中 ChatModel 的 Options 参数
//                .defaultOptions(OpenAiChatOptions.builder().temperature(0.7d).build()).build();
//    }

    /**
     * 使用自定义参数调用DeepSeek模型
     *
     * @return ChatResponse 包含模型响应结果的封装对象
     * @apiNote 当前硬编码指定模型为deepseek-chat，温度参数0.7以平衡生成结果的创造性和稳定性
     */
    @GetMapping(value = "/ai/customOptions")
    public ChatResponse customOptions () {

//        return this.DeepSeekChatClient.prompt(new Prompt(
//                "你好，我想使用java语言获取到deepseek模型的思维链，有什么api可以给我调用吗",
//                        OpenAiChatOptions.builder().temperature(0.75).build())
//                ).call()
//                .chatResponse();
        ChatResponse chatResponse = this.DeepSeekChatClient.prompt(new Prompt(
                "你好，我想使用java语言创建一个图书管理程序，我该怎么办",
                OpenAiChatOptions.builder().temperature(0.75).build())
        ).call().chatResponse();
        if (!chatResponse.getResults().isEmpty()) {
            Map<String, Object> metadata = chatResponse.getResults()
                    .get(0)
                    .getOutput()
                    .getMetadata();

            System.out.println(metadata.get("reasoningContent"));
        }
        return chatResponse;
    }

    /**
     * 执行默认提示语的 AI 生成请求
     */
    @GetMapping("/ai/generate")
    public String chat () {

        return this.DeepSeekChatClient.prompt(DEFAULT_PROMPT)
                .call()
                .content();
    }

    /**
     * 流式生成接口 - 支持实时获取生成过程的分块响应
     */
    @GetMapping("/ai/stream")
    public Flux<String> stream () {

        return this.DeepSeekChatClient.prompt(DEFAULT_PROMPT)
                .stream()
                .content();
    }

}
