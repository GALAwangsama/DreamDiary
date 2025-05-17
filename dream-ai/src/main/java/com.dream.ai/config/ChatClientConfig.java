package com.dream.ai.config;


import jakarta.annotation.Resource;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.chat.memory.InMemoryChatMemory;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ChatClientConfig {

    //系统提示词
    private static final String DEFAULT_PROMPT = "你现在是一位管理智能开发模板的智能体，你需要根据用户的请求做出相应的回答，帮助用户完成任务";


    private final ChatModel DeepSeekChatModel;

    public ChatClientConfig(OpenAiChatModel deepSeekChatModel) {
        DeepSeekChatModel = deepSeekChatModel;
    }


    //选择模型创建ChatClient
    @Bean(name ="DeepSeekChatClient")
    public ChatClient ChatClient(){
        return ChatClient.builder(DeepSeekChatModel)
                .defaultSystem(DEFAULT_PROMPT)
                // 实现 Chat Memory 的 Advisor
                // 在使用 Chat Memory 时，需要指定对话 ID，以便 Spring AI 处理上下文。
                .defaultAdvisors(
                        new MessageChatMemoryAdvisor(new InMemoryChatMemory())
                )
                //实现 Logger 的 Advisor
                .defaultAdvisors(
                        new SimpleLoggerAdvisor()
                )
                .defaultOptions(OpenAiChatOptions.builder().temperature(0.7d).build())
                .build();
    }


}
