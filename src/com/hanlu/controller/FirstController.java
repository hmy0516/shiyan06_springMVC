package com.hanlu.controller;

import com.hanlu.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author HMY
 * @date 2018/12/26-13:23
 */
@Controller
//@RequestMapping("springmvc")
@SessionAttributes(value = "name",types = {User.class})
public class FirstController {
    @RequestMapping("firstController")
    public String test1(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.setAttribute("name","value1");
        //return "redirect:/first.jsp";
        return "redirect:test2";
    }

    @RequestMapping("test2")
    public String test2(HttpServletRequest request){
        request.setAttribute("name","value2");
        return "first";
    }

    @RequestMapping("test3")
    public String test3(Map<String,Object> map){
        map.put("name","value3");
        User user = new User(1, "Tom", "123456", "tom@qq.com", 12);
        map.put("user",user);
        return "redirect:/first.jsp";
    }
}
