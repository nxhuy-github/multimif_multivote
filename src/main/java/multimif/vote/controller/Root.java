package multimif.vote.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/")
public class Root {

    @RequestMapping(method = RequestMethod.GET)
    public String root(){
        return "index";
    }

    @RequestMapping(value = "/loginpage", method = RequestMethod.GET)
    public String logInPage(){
        return "login";
    }

    @RequestMapping(value = "/signuppage", method = RequestMethod.GET)
    public String signUpPage(){
        return "signup";
    }
}
