package life.hao.community.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import life.hao.community.dto.CommentCreateDTO;
import life.hao.community.dto.CommentDTO;
import life.hao.community.dto.ResultDTO;
import life.hao.community.enums.CommentTypeEnum;
import life.hao.community.exception.CustomizeErrorCode;
import life.hao.community.mapper.CommentMapper;
import life.hao.community.model.Comment;
import life.hao.community.model.User;
import life.hao.community.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class CommentController {
    @Autowired
    private CommentService commentService;

    @ResponseBody
    @RequestMapping(value = "/comment", method = RequestMethod.POST)
        public Object post(@RequestBody CommentCreateDTO commentCreateDTO,
                           HttpServletRequest request){
        User user=(User) request.getSession().getAttribute("user");
        if (user ==null){
            return ResultDTO.errorOf(CustomizeErrorCode.NO_LOGIN);
        }

        if (commentCreateDTO == null || commentCreateDTO.getContent() == null || commentCreateDTO.getContent()=="" ){
            return ResultDTO.errorOf(CustomizeErrorCode.CONTENT_IS_EMPTY);
        }

        Comment comment =new Comment();
        comment.setParentId(commentCreateDTO.getParentId());//父id
        comment.setContent(commentCreateDTO.getContent());//评论
        comment.setType(commentCreateDTO.getType());
        comment.setGmtModified(System.currentTimeMillis());
        comment.setGmtCreate(System.currentTimeMillis());
        comment.setCommentator(user.getId());
        comment.setLikeCount(0L);
        commentService.insert(comment,user);
        return ResultDTO.okOf();

    }
    @ResponseBody
    @RequestMapping(value = "/comment/{id}", method = RequestMethod.GET)
    public ResultDTO<List<CommentDTO>> comments(@PathVariable(name ="id") Long id){
        List<CommentDTO> commentDTOS=commentService.
               listByTargetId(id, CommentTypeEnum.COMMENT);
        return ResultDTO.okOf(commentDTOS);
    }



}
