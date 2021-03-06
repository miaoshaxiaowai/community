package life.hao.community.controller;


import life.hao.community.dto.PaginationDTO;
import life.hao.community.service.QuestionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

@Controller
public class IndexController {

    @Resource
    private QuestionService questionService;
    @GetMapping("/")//没有东西时返回的地址为iindex
    public String index( Model model,
                        @RequestParam(name="page",defaultValue = "1") Integer page,
                        @RequestParam(name="size",defaultValue = "5") Integer size,
                         @RequestParam(name = "search", required = false) String search){

       PaginationDTO pagination =questionService.list(search,page,size);
       model.addAttribute("pagination",pagination);
       model.addAttribute("search",search);
        return "index";
    }
}
