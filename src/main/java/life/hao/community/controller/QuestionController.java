package life.hao.community.controller;

import life.hao.community.dto.CommentDTO;
import life.hao.community.dto.QuestionDTO;
import life.hao.community.enums.CommentTypeEnum;
import life.hao.community.model.Comment;
import life.hao.community.service.CommentService;
import life.hao.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @Autowired
    private CommentService commentService;
    @GetMapping("/question/{id}")

    public String question(@PathVariable(name = "id") Long id,
    Model model){
        QuestionDTO questionDTO=questionService.getById(id);
        //累加阅读数
        List<QuestionDTO> relatedQuestions = questionService.selectRelated(questionDTO);
        List<CommentDTO> comments =commentService.listByTargetId(id, CommentTypeEnum.QUESTION);
        questionService.incView(id);
        model.addAttribute("question",questionDTO);
        model.addAttribute("comments",comments);
        model.addAttribute("relatedQuestions",relatedQuestions);
        return "question";
    }
}
