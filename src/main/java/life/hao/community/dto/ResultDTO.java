package life.hao.community.dto;

import life.hao.community.exception.CustomizeErrorCode;
import life.hao.community.exception.CustomizeException;
import life.hao.community.model.User;
import lombok.Data;

import java.util.List;

@Data
public class ResultDTO<T> {
    private Integer code;
    private String message;
    private T data;

    public static ResultDTO errorOf(Integer code,String message){
        ResultDTO resultDTO =new ResultDTO();
        resultDTO.setCode(code);
        resultDTO.setMessage(message);
        return resultDTO;
    }

    public static Object errorOf(CustomizeErrorCode errorCode) {
        return errorOf(errorCode.getCode(),errorCode.getMessage());

    }
    public static ResultDTO okOf(){
        ResultDTO resultDTO =new ResultDTO();
        resultDTO.setCode(200);
        resultDTO.setMessage("请求成功");
        return resultDTO;
    }

    public static Object errorOf(CustomizeException e) {
        return errorOf(e.getCode(),e.getMessage());
    }

    public static <T> ResultDTO okOf(Object t){
        ResultDTO resultDTO =new ResultDTO();
        resultDTO.setCode(200);
        resultDTO.setMessage("请求成功");
        resultDTO.setData(t);
        return resultDTO;
    }
}
