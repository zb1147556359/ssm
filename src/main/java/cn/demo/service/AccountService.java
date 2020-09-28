package cn.demo.service;

import cn.demo.domain.Account;

import java.util.List;

public interface AccountService {
    //查询所有
    public List<Account> findAll();
    //保存用户信息
    public void saveAccount(Account account);
}
