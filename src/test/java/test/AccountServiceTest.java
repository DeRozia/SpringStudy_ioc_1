package test;

import domain.Account;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.IAccountService;

import java.util.List;

/**
 * 使用junit单元测试，测试我们的配置
 */
public class AccountServiceTest {
    @Test
    public void testFindAll(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("bean.xml");

        IAccountService accountService=applicationContext.getBean("accountService",IAccountService.class);

        List<Account> accounts=accountService.findAllAccount();

        for(Account account:accounts){

            System.out.println(account);
        }

    }

    @Test
    public void testFindOne(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("bean.xml");

        IAccountService accountService=applicationContext.getBean("accountService",IAccountService.class);

        Account account=accountService.findAccountById(1);
        System.out.println(account);
    }

    @Test
    public void testSave(){
        Account account=new Account();

        account.setName("test");
        account.setMoney(12345f);
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("bean.xml");

        IAccountService accountService=applicationContext.getBean("accountService",IAccountService.class);

        accountService.saveAccount(account);
    }

    @Test
    public void testUpdate(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("bean.xml");

        IAccountService accountService=applicationContext.getBean("accountService",IAccountService.class);
        Account account=accountService.findAccountById(4);
        account.setMoney(23456f);
        accountService.updateAccount(account);

    }

    @Test
    public void testDelete(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("bean.xml");

        IAccountService accountService=applicationContext.getBean("accountService",IAccountService.class);

        accountService.deleteAccount(4);
    }
}
