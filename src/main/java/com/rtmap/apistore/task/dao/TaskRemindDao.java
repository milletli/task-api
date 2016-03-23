package com.rtmap.apistore.task.dao;

import com.rtmap.apistore.task.entity.TaskRemind;

public interface TaskRemindDao {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task_remind
     *
     * @mbggenerated Wed Mar 23 22:16:36 CST 2016
     */
    int deleteByPrimaryKey(String remindId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task_remind
     *
     * @mbggenerated Wed Mar 23 22:16:36 CST 2016
     */
    int insert(TaskRemind record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task_remind
     *
     * @mbggenerated Wed Mar 23 22:16:36 CST 2016
     */
    int insertSelective(TaskRemind record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task_remind
     *
     * @mbggenerated Wed Mar 23 22:16:36 CST 2016
     */
    TaskRemind selectByPrimaryKey(String remindId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task_remind
     *
     * @mbggenerated Wed Mar 23 22:16:36 CST 2016
     */
    int updateByPrimaryKeySelective(TaskRemind record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task_remind
     *
     * @mbggenerated Wed Mar 23 22:16:36 CST 2016
     */
    int updateByPrimaryKey(TaskRemind record);
}