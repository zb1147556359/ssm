package cn.demo.test;

import cn.demo.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName TestSpring
 * @Description TOOD
 * @Author zhangbinbin
 * @Date 2020/9/25 19:35
 * @Vestion 1.0
 **/
public class TestSpring {
    @Test
    public void run1(){
        ApplicationContext ac=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        AccountService as = ac.getBean("accountService",AccountService.class);
        as.findAll();
    }
}
