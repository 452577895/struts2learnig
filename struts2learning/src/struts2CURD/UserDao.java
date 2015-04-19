package struts2CURD;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.util.ServletContextAware;

public class UserDao implements ServletRequestAware{
	private HttpServletRequest request;
	private static List<User> allUser = new ArrayList<User>();
	
	static {
		allUser.add(new User("1001","201250080325","123456", 18, "男"));
		allUser.add(new User("1002","201250080326","weq22", 19, "男"));
		allUser.add(new User("1003","201250080327","1234213", 20, "男"));
		allUser.add(new User("1004","201250080328","123asdq", 21, "男"));
		allUser.add(new User("1005","201250080329","wqwwgg", 22, "男"));

	}
	public String showUser(){
		System.out.println("来了显示方法");
		HttpSession session = request.getSession();
		List<User> list = (List<User>) session.getAttribute("allUser");
		if(list.size()==0||list==null){
		session.setAttribute("allUser", allUser);
		}
		return "showUser-success";
	}
	public String deleteUser(){
		System.out.println("来了删除方法");
		HttpSession session = request.getSession();
		List<User> list = (List<User>) session.getAttribute("allUser");
		List<User> temp = new ArrayList<User>();
		String userId = request.getParameter("userId");
		System.out.println(userId);
		for (User user : list) {
			if(user.getUserId().equals(userId)){
				temp.add(user);
			}
		}
		list.removeAll(temp);
		session.setAttribute("allUser", list);
		return "deleteUser-success";
	}
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
}
