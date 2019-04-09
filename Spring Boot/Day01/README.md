# Spring Boot基础
## Spring Boot 简介
- 简化Spring应用开发的一个框架
- 整个Spring技术栈的一个大整合；
- J2EE开发的一站式解决方案
## Spring Boot 核心功能
- 1.独立运行 的Spring项目
- 2.内嵌Servlet容器
- 3.提供starter简化Maven配置
- 4.自动配置Spring
- 5.准生产的应用监控
- 6.无代码生成和xml配置
## 微服务
- 一个应用应该是一组小型服务；可以通过HTTP的方式进行互通；
- 每一个功能元素最终都是一个可独立替换和独立开发升级的软件单元；
## 简化部署
      <!--这个插件，可以将应用打包成一个可执行的jar包；-->
      <build>
          <plugins>
              <plugin>
                  <groupId>org.springframework.boot</groupId>
                  <artifactId>spring-boot-maven-plugin</artifactId>
              </plugin>
          </plugins>
      </build>
## Hello World探究
###  1.POM文件
#### 1.父项目
      <parent>
       <groupId>org.springframework.boot</groupId>
       <artifactId>spring-boot-starter-parent</artifactId>
       <version>1.5.9.RELEASE</version>
      </parent>
#### 2.导入的依赖
      <dependencies>
          <dependency>
              <groupId>org.springframework.boot</groupId>
              <artifactId>spring-boot-starter-web</artifactId>
          </dependency>
      </dependencies>
- spring-boot-starter-web：spring-boot场景启动器；帮我们导入了web模块正常运行所依赖的组件；
- Spring Boot将所有的功能场景都抽取出来，做成一个个的starter（启动器），只需要在项目里面引入这些starter相关场景的所有依赖都会导入进来，要用什么功能就导入什么场景的启动器。
### 2.主程序类，主入口类
      /**
      * @SpringBootApplication 来标注一个主程序类，说明这是一个Spring Boot应用
      * Created by asus on 2019/3/11.*/*
      @SpringBootApplication
      public class HelloWorldMainApplication {

      public static void main(String[] args) {

        //Spring应用启动起来
          SpringApplication.run(HelloWorldMainApplication.class,args);
      }
      }
- @SpringBootApplication： Spring Boot应用标注在某个类上说明这个类是SpringBoot的主配置类，SpringBoot就应该运行这个类的main方法来启动SpringBoot应用；
- 配置文件yml还是properties他们都能获取到值：如果说，我们只是在某个业务逻辑中需要获取一下配置文件中的某项值，使用@value；如果说，我们专门编写一个javabean来和配置文件进行映射，我们就可以直接使用@ConfigurationProperties;
- @PropertySource:加载指定配置文件
- @


##  
