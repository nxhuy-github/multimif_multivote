package multimif.vote.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping(value = "/logout")
public class LogOut {

    @RequestMapping(method = RequestMethod.GET)
    public String logOut(HttpServletRequest request) {
        request.getSession(false).invalidate();
        System.out.println("Log Out...");
        return "login";
    }
}
