package cn.demo.test;

import cn.demo.dao.AccountDao;
import cn.demo.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @ClassName Test
 * @Description TOOD
 * @Author zhangbinbin
 * @Date 2020/9/25 23:15
 * @Vestion 1.0
 **/
public class TestMyBatis {
    @Test
    public void run1() throws Exception {
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建sqlsessionfactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        SqlSession session = factory.openSession();
        //获取代理对象
        AccountDao dao = session.getMapper(AccountDao.class);
        List<Account> list = dao.findAll();
        list.forEach(System.out::println);
        session.close();
        in.close();
    }
    @Test
    public void run2() throws Exception {
        Account account =new Account();
       ;
        account.setName("张晓");
        account.setMoney(300d);
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建sqlsessionfactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        SqlSession session = factory.openSession();
        //获取代理对象
        AccountDao dao = session.getMapper(AccountDao.class);
        dao.saveAccount(account);
        session.commit();
        session.close();
        in.close();
    }
}
