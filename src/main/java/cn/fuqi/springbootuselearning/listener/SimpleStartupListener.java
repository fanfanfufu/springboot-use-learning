package cn.fuqi.springbootuselearning.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * 简单的Spring Boot应用启动完成事件监听器
 * 使用@EventListener注解方式实现
 * 
 * @author fuqi
 * @date 2024-01-01
 */
@Slf4j
@Component
public class SimpleStartupListener {

    /**
     * 监听应用启动完成事件
     * 使用@EventListener注解，Spring会自动注册为事件监听器
     * 
     * @param event 应用启动完成事件
     */
    @EventListener(ApplicationReadyEvent.class)
    public void onApplicationReady(ApplicationReadyEvent event) {
        log.info("=== 简单监听器：Spring Boot应用启动完成 ===");
        
        // 获取应用上下文信息
        String applicationName = event.getApplicationContext().getApplicationName();
        log.info("应用名称: {}", applicationName);
        
        // 执行简单的启动后逻辑
        performSimpleStartupTasks();
    }
    
    /**
     * 执行简单的启动后任务
     */
    private void performSimpleStartupTasks() {
        log.info("开始执行简单的启动后任务...");
        
        // 示例：打印系统信息
        log.info("Java版本: {}", System.getProperty("java.version"));
        log.info("操作系统: {}", System.getProperty("os.name"));
        log.info("用户目录: {}", System.getProperty("user.dir"));
        
        log.info("简单启动后任务执行完成");
    }
} 