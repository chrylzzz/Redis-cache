package cn.tx.service.impl;

import cn.tx.dao.AccountMapper;
import cn.tx.model.Account;
import cn.tx.service.AccountService;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountMapper accountMapper;

    public List<Account> selectAll() {
        return null;
    }


    @Cacheable(value = "accountCache")
    public Account getAccountById(int accountId) {
        return accountMapper.getAccountById(accountId);
    }

    @CachePut(value = "accountCache", key = "#account.id")
    public void save(Account account){
        accountMapper.save(account);
    }
}
