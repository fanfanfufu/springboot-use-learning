package cn.fuqi.springbootuselearning.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * Spring Boot应用启动完成事件监听器
 * 监听ApplicationReadyEvent事件，该事件在应用启动完成后触发
 * 
 * @author fuqi
 * @date 2024-01-01
 */
@Slf4j
@Component
public class ApplicationStartupListener implements ApplicationListener<ApplicationReadyEvent> {

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        log.info("=== Spring Boot应用启动完成，开始执行自定义逻辑 ===");
        
        // 执行自定义启动逻辑
        executeCustomStartupLogic();
        
        log.info("=== 自定义启动逻辑执行完成 ===");
    }
    
    /**
     * 执行自定义启动逻辑
     */
    private void executeCustomStartupLogic() {
        try {
            // 1. 初始化缓存数据
            initializeCacheData();
            
            // 2. 启动定时任务
            startScheduledTasks();
            
            // 3. 连接外部服务
            connectExternalServices();
            
            // 4. 加载配置信息
            loadConfiguration();
            
            log.info("所有自定义启动逻辑执行成功");
            
        } catch (Exception e) {
            log.error("执行自定义启动逻辑时发生错误: {}", e.getMessage(), e);
        }
    }
    
    /**
     * 初始化缓存数据
     */
    private void initializeCacheData() {
        log.info("正在初始化缓存数据...");
        // 这里可以添加具体的缓存初始化逻辑
        // 例如：从数据库加载配置到Redis缓存
        try {
            Thread.sleep(1000); // 模拟初始化过程
            log.info("缓存数据初始化完成");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.warn("缓存初始化被中断");
        }
    }
    
    /**
     * 启动定时任务
     */
    private void startScheduledTasks() {
        log.info("正在启动定时任务...");
        // 这里可以添加定时任务的启动逻辑
        // 例如：启动数据同步任务、清理任务等
        try {
            Thread.sleep(500); // 模拟启动过程
            log.info("定时任务启动完成");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.warn("定时任务启动被中断");
        }
    }
    
    /**
     * 连接外部服务
     */
    private void connectExternalServices() {
        log.info("正在连接外部服务...");
        // 这里可以添加外部服务连接逻辑
        // 例如：连接消息队列、缓存服务、第三方API等
        try {
            Thread.sleep(800); // 模拟连接过程
            log.info("外部服务连接完成");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.warn("外部服务连接被中断");
        }
    }
    
    /**
     * 加载配置信息
     */
    private void loadConfiguration() {
        log.info("正在加载配置信息...");
        // 这里可以添加配置加载逻辑
        // 例如：从配置中心加载配置、验证配置有效性等
        try {
            Thread.sleep(300); // 模拟加载过程
            log.info("配置信息加载完成");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.warn("配置加载被中断");
        }
    }
} 