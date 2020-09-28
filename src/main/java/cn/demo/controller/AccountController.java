package cn.demo.controller;

import cn.demo.domain.Account;
import cn.demo.service.AccountService;
import com.sun.deploy.net.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSessionActivationListener;
import java.io.IOException;
import java.sql.ClientInfoStatus;
import java.util.List;

/**
 * @ClassName AccountController
 * @Description TOOD
 * @Author zhangbinbin
 * @Date 2020/9/25 19:21
 * @Vestion 1.0
 **/
@Controller
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountService;
    @RequestMapping("/findAll")
    public String findAll(Model model){

        System.out.println("表现层：查询所有账户信息");
        List<Account> list = accountService.findAll();
        model.addAttribute("list",list);
        return "list";
    }
    @RequestMapping("/save")
    public void save(Account account, HttpServletRequest request, HttpServletResponse response) throws IOException {

        accountService.saveAccount(account);
        response.sendRedirect(request.getContextPath()+"/account/findAll");
        return;
    }
}
