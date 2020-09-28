package cn.demo.service.impl;

import cn.demo.dao.AccountDao;
import cn.demo.domain.Account;
import cn.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName AccountServiceImpl
 * @Description TOOD
 * @Author zhangbinbin
 * @Date 2020/9/25 19:19
 * @Vestion 1.0
 **/
@Service("accountService")
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;
    public List<Account> findAll() {
        System.out.println("业务层，查询所有用户");
        return accountDao.findAll();
    }

    public void saveAccount(Account account) {
        System.out.println("业务层，保存所有用户");
        accountDao.saveAccount(account);
    }
}
