package com.rtmap.apistore.interfaces.taskland.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rtmap.apistore.interfaces.taskland.bean.TaskInfoBean;
import com.rtmap.apistore.interfaces.taskland.entity.TaskAttachFile;
import com.rtmap.apistore.interfaces.taskland.entity.TaskComment;
import com.rtmap.apistore.interfaces.taskland.entity.TaskParticipant;
import com.rtmap.apistore.interfaces.taskland.service.TaskOperService;

/**
 * 任务田，任务操作
 *
 */
@Controller
@RequestMapping("/taskland/v1/")
public class TaskOperateExtController {
	@SuppressWarnings("unused")
	private final static Logger logger = LoggerFactory.getLogger(TaskOperateExtController.class);
	@Autowired
	private TaskOperService taskOperateService;

	/**
	 * 添加回复/评论任务接口
	 * 
	 * @param comment
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/tasks/{taskId}/comments", method = { RequestMethod.PUT })
	@ResponseBody
	public TaskComment addComment(@PathVariable(value = "taskId") String taskId,
			@RequestParam(required = true, value = "comment") String comment,
			@RequestParam(required = true, value = "userId") String userId) {
		return this.taskOperateService.addTaskComment(taskId, comment, userId);
	}

	/**
	 * 删除回复/评论任务接口
	 * 
	 * @param commentId
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/tasks/{taskId}/comments/{commentId}", method = { RequestMethod.DELETE })
	@ResponseBody
	public void deleteComment(@PathVariable(value = "taskId") String taskId,
			@PathVariable(value = "commentId") String[] commentId,
			@RequestParam(required = true, value = "userId") String userId) {
		this.taskOperateService.delTaskComment(taskId, commentId, userId);
	}

	/**
	 * 添加任务附件接口
	 * 
	 * @param fileName
	 * @param filePath
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/tasks/{taskId}/attaches", method = { RequestMethod.POST })
	@ResponseBody
	public TaskAttachFile addAttach(@PathVariable(value = "taskId") String taskId,
			@RequestParam(required = true, value = "fileName") String fileName,
			@RequestParam(required = true, value = "filePath") String filePath,
			@RequestParam(required = true, value = "userId") String userId) {
		return this.taskOperateService.addAttachFile(taskId, fileName, filePath, userId);
	}

	/**
	 * 删除任务附件接口
	 * 
	 * @param attachId
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/tasks/{taskId}/attaches", method = { RequestMethod.DELETE })
	@ResponseBody
	public void deleteAttach(@PathVariable(value = "taskId") String taskId,
			@PathVariable(value = "attachId") String[] attachId,
			@RequestParam(required = true, value = "userId") String userId) {
		this.taskOperateService.delAttachFile(taskId, attachId, userId);
	}

	/**
	 * 添加子任务接口
	 * 
	 * @param taskInfoBean
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/tasks/{taskId}/subtasks", method = { RequestMethod.POST })
	@ResponseBody
	public TaskInfoBean addSubTask(@PathVariable(value = "taskId") String taskId,
			@RequestBody TaskInfoBean taskInfoBean, @RequestParam(required = true, value = "userId") String userId) {
		return this.taskOperateService.addTask(taskId, taskInfoBean, userId);
	}

	/**
	 * 删除子任务
	 * 
	 * @param subTaskId
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/tasks/{taskId}/attaches/{subTaskId}", method = { RequestMethod.DELETE })
	@ResponseBody
	public void deleteSubTask(@PathVariable(value = "taskPid") String taskPid,
			@PathVariable(value = "subTaskId") String[] taskId,
			@RequestParam(required = true, value = "userId") String userId) {
		this.taskOperateService.delTask(taskPid, taskId, userId);
	}

	/**
	 * 添加参与人
	 * 
	 * @param taskId
	 * @param participant
	 * @param userId
	 */
	@RequestMapping(value = "/tasks/{taskId}/participants", method = { RequestMethod.POST })
	@ResponseBody
	public TaskParticipant addParticipant(@PathVariable(value = "taskId") String taskId,
			@RequestParam(required = true, value = "participant") String participant,
			@RequestParam(required = true, value = "userId") String userId) {
		return this.taskOperateService.addParticipant(taskId, participant, userId);
	}

	/**
	 * 删除参与人
	 * 
	 * @param taskId
	 * @param participant
	 * @param userId
	 */
	@RequestMapping(value = "/tasks/{taskId}/participants", method = { RequestMethod.POST })
	@ResponseBody
	public void delParticipant(@PathVariable(value = "taskId") String taskId,
			@RequestParam(required = true, value = "participant") String[] participant,
			@RequestParam(required = true, value = "userId") String userId) {
		this.taskOperateService.delParticipant(taskId, participant, userId);
	}

}
