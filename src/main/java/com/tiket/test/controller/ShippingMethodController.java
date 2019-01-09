package com.tiket.test.controller;

import com.tiket.test.model.Welcome;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test/shippingmethod")
public class ShippingMethodController {

  private static final String welcomemsg = "anjay %s!";

  @GetMapping("/welcome/user")
  @ResponseBody
  public Welcome welcomeUser(
      @RequestParam(name = "name", required = false, defaultValue = "mantap gan") String name) {
    return new Welcome(String.format(welcomemsg, name));

  }
}
