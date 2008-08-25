package cn.org.pomer.demo.web.action;

import java.util.Date;

import net.sf.json.JSONObject;
import cn.org.pomer.PageList;
import cn.org.pomer.demo.entity.Student;
import cn.org.pomer.web.ActionBase;

public class StudentAction extends ActionBase {
	private String json;

	public void getList() {
		PageList<Student> stuList = new PageList<Student>();
		stuList.getList().add(new Student(new Long("1"), "linlinyu", new Date()));
		stuList.getList().add(new Student(new Long("2"), "bbb", new Date()));
		stuList.setTotalCount(stuList.getList().size());

		JSONObject jsonObject = JSONObject.fromObject(stuList);

		String jsonStr = jsonObject.toString();
		outJsonResponse(jsonStr);
	}

	public void saveJsonToObject() {
		JSONObject jsonObject = JSONObject.fromObject(json);
		PageList pageList = (PageList) jsonObject.toBean(jsonObject, PageList.class);
		System.out.println(pageList);
		
	}

	public String getJson() {
		return json;
	}

	public void setJson(String json) {
		this.json = json;
	}

}
