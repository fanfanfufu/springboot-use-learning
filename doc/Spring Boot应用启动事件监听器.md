# Spring Boot应用启动事件监听器

## 概述

在Spring Boot应用中，我们经常需要在应用启动完成后执行一些初始化逻辑，比如：
- 初始化缓存数据
- 启动定时任务
- 连接外部服务
- 加载配置信息
- 预热系统资源

Spring Boot提供了多种事件监听机制来实现这些需求。

## 实现方式

### 方式一：实现ApplicationListener接口

```java
@Component
public class ApplicationStartupListener implements ApplicationListener<ApplicationReadyEvent> {
    
    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        // 应用启动完成后的自定义逻辑
        executeCustomStartupLogic();
    }
}
```

### 方式二：使用@EventListener注解

```java
@Component
public class SimpleStartupListener {
    
    @EventListener(ApplicationReadyEvent.class)
    public void onApplicationReady(ApplicationReadyEvent event) {
        // 应用启动完成后的自定义逻辑
        performSimpleStartupTasks();
    }
}
```

## 主要事件类型

### ApplicationReadyEvent
- **触发时机**: 应用启动完成，所有Bean都已初始化完成
- **使用场景**: 执行需要依赖其他Bean的初始化逻辑
- **推荐使用**: 大多数情况下推荐使用此事件

### ApplicationStartedEvent
- **触发时机**: 应用启动开始，但Bean还未完全初始化
- **使用场景**: 执行不依赖其他Bean的早期初始化逻辑

### ApplicationFailedEvent
- **触发时机**: 应用启动失败
- **使用场景**: 清理资源、记录错误日志等

## 项目中的实现

### 1. ApplicationStartupListener
- 实现了完整的启动后初始化流程
- 包含缓存初始化、定时任务启动、外部服务连接、配置加载等功能
- 使用实现接口的方式

### 2. SimpleStartupListener
- 使用@EventListener注解方式实现
- 获取应用上下文信息
- 打印系统信息
- 更简洁的实现方式

## 测试验证

### 启动应用
启动Spring Boot应用，观察控制台日志输出：

```
=== Spring Boot应用启动完成，开始执行自定义逻辑 ===
正在初始化缓存数据...
缓存数据初始化完成
正在启动定时任务...
定时任务启动完成
正在连接外部服务...
外部服务连接完成
正在加载配置信息...
配置信息加载完成
所有自定义启动逻辑执行成功
=== 自定义启动逻辑执行完成 ===

=== 简单监听器：Spring Boot应用启动完成 ===
应用名称: springboot-use-learning
开始执行简单的启动后任务...
Java版本: 11.0.x
操作系统: Mac OS X
用户目录: /path/to/project
简单启动后任务执行完成
```

### API测试
访问以下接口验证功能：

- `GET /listener/test` - 测试监听器功能
- `GET /listener/info` - 获取监听器信息

## 注意事项

1. **执行顺序**: 多个监听器的执行顺序不保证，如果需要特定顺序，可以使用@Order注解
2. **异常处理**: 在监听器中要妥善处理异常，避免影响应用启动
3. **性能考虑**: 监听器中的逻辑应该尽量快速完成，避免阻塞应用启动
4. **依赖注入**: 在ApplicationReadyEvent中，所有Bean都已初始化完成，可以安全使用依赖注入

## 扩展应用

可以根据实际需求扩展监听器功能：

- 数据预热：预加载常用数据到缓存
- 健康检查：启动后检查系统各组件状态
- 资源清理：定期清理临时文件、过期数据等
- 监控上报：向监控系统上报应用启动状态
- 配置验证：验证配置文件的完整性和正确性 