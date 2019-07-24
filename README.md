基于Spring Boot实现的modbus心跳通信
=========================

![Spring Boot 2.1.6](https://img.shields.io/badge/Spring%20Boot-2.1.6-brightgreen.svg)
![JDK 1.8](https://img.shields.io/badge/JDK-1.8-brightgreen.svg)
![jlibmodbus](https://img.shields.io/badge/jlibmodbus-1.2.9.7-yellowgreen.svg)
 
基于Spring Boot实现的modbus定时tcp通信，支持线程池，可从数据库动态设置ip、端口号及执行周期（执行周期需遵循cron表达式）

本项目使用Spring Data Jpa + MySQL，具体依赖见pom.xml

modbus协议基于jlibmodbus实现,Thanks to https://github.com/kochedykov/jlibmodbus


# examples：

- [动态任务实现](https://github.com/yoloyl/modbusHb/blob/master/src/main/java/com/lim/timing/task/DynamicScheduleTask.java)
- [多线程实现](https://github.com/yoloyl/modbusHb/blob/master/src/main/java/com/lim/timing/task/MultithreadScheduleTask.java)
- [modbusTcpService](https://github.com/yoloyl/modbusHb/blob/master/src/main/java/com/lim/timing/service/impl/ModBusPollServiceImpl.java)
