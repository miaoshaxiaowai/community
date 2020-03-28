package life.hao.community.mapper;

import life.hao.community.dto.QuestionQueryDTO;
import life.hao.community.model.Question;
import life.hao.community.model.QuestionExample;

import java.util.List;

public interface QuestionExtMapper {

    int incView(Question record);
    int incCommentCount(Question record);
    List<Question> selectRelated(Question question);

    Integer countBySearch(QuestionQueryDTO questionQueryDTO);

    List<Question> selectBySearch(QuestionQueryDTO questionQueryDTO);
}