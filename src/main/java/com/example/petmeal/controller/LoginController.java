package com.example.petmeal.controller;


import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import com.example.petmeal.domain.Order;
import com.example.petmeal.domain.User;
import com.example.petmeal.service.OrderService;
import com.example.petmeal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;
    private OrderService orderService;

    @RequestMapping(value="/login", method = RequestMethod.GET)
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }


    @RequestMapping(value="/registration", method = RequestMethod.GET)
    public ModelAndView registration(){
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        User userExists = userService.findUserByEmail(user.getEmail());
        if (userExists != null) {
            bindingResult
                    .rejectValue("email", "error.user",
                            "There is already a user registered with the email provided");
        }
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("registration");
        } else {
            userService.saveUser(user);
            return new ModelAndView( "redirect:/login");
            
        }
        return modelAndView;
    }

    @RequestMapping(value="/myaccount", method = RequestMethod.GET)
    public ModelAndView myaccount(ModelAndView mav, Principal principal){
        mav.setViewName("myaccount");
        User user=userService.findUserByEmail(principal.getName());
        Long buyerId=user.getId();
        List<Order> orderList=orderService.findOrderByBuyerId(buyerId);
        mav.addObject("orderlist",orderList);
        return mav;
    }


}