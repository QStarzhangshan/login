package cn.zh.jdbc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/*")
public class MapController {

	@RequestMapping(value = "/map")
    public String map(){
        return "map";

    }
}
