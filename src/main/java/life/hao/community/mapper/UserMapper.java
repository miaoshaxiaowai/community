package life.hao.community.mapper;

import java.util.List;
import life.hao.community.model.User;
import life.hao.community.model.UserExample;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Tue Mar 10 17:17:52 CST 2020
     */
    long countByExample(UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Tue Mar 10 17:17:52 CST 2020
     */
    int deleteByExample(UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Tue Mar 10 17:17:52 CST 2020
     */
    int deleteByPrimaryKey(Byte id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Tue Mar 10 17:17:52 CST 2020
     */
    int insert(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Tue Mar 10 17:17:52 CST 2020
     */
    int insertSelective(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Tue Mar 10 17:17:52 CST 2020
     */
    List<User> selectByExample(UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Tue Mar 10 17:17:52 CST 2020
     */
    User selectByPrimaryKey(Byte id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Tue Mar 10 17:17:52 CST 2020
     */
    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Tue Mar 10 17:17:52 CST 2020
     */
    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Tue Mar 10 17:17:52 CST 2020
     */
    int updateByPrimaryKeySelective(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Tue Mar 10 17:17:52 CST 2020
     */
    int updateByPrimaryKey(User record);
}