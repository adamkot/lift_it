package pl.akotus.lift_it.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class getCode {

    @RequestMapping(value = "/getInstruction", method = RequestMethod.GET)
    @ResponseBody
    public String testPage() {
        return "1L20:2G45:3G20:4D25";
    }
}
