package list.mylist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

    @GetMapping("/myList")
    @ResponseBody
    public String index() {
        return "권현욱의 운동일지";
    }

    // 아무것도 입력하지 않았을 때 운동일지 목록으로 접속.
    @GetMapping("/")
    public String root() {
        return "redirect:/workout/list";
    }
}
