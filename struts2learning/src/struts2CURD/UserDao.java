package struts2CURD;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.util.ServletContextAware;

import com.opensymphony.xwork2.ModelDriven;

public class UserDao implements ServletRequestAware,ModelDriven<User>{
	private HttpServletRequest request;
	private static List<User> allUser = new ArrayList<User>();
	private User user;
	private String userId;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
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
		if(list==null||list.size()==0){
		session.setAttribute("allUser", allUser);
		}
		return "showUser-success";
	}
	public String deleteUser(){
		System.out.println("来了删除方法");
		HttpSession session = request.getSession();
		List<User> list = (List<User>) session.getAttribute("allUser");
		List<User> temp = new ArrayList<User>();
		//String userId = request.getParameter("userId");
		System.out.println(user.getUserId());
		for (User tuser : list) {
			if(tuser.getUserId().equals(user.getUserId())){
				temp.add(tuser);
			}
		}
		list.removeAll(temp);
		session.setAttribute("allUser", list);
		return "deleteUser-success";
	}
	
	public String addUser(){
		HttpSession session = request.getSession();
		List<User> list = (List<User>) session.getAttribute("allUser");
		if(list==null){
			list = new ArrayList<User>();
		}
		Random rand = new Random();
		int x = rand.nextInt(100000);
		user.setUserId(x+"");
		list.add(user);
		session.setAttribute("allUser", list);
		return "addUser-success";
	}
	public String edit(){
		/*HttpSession session = request.getSession();
		List<User> list = (List<User>) session.getAttribute("allUser");
		User tuser = new User();
		for (User temp : list) {
			if(temp.getUserId().equals(user.getUserId())){
				tuser = temp;
			}
		}
		//user 在值栈栈顶
		user.setUsername(tuser.getUsername());
		user.setPassword(tuser.getPassword());
		user.setAge(tuser.getAge());
		user.setSex(tuser.getSex());*/
		
		return "edit-success";
	}
	public String update(){
		HttpSession session = request.getSession();
		List<User> list = (List<User>) session.getAttribute("allUser");
		List<User> tlist = new ArrayList<User>();
		for (User temp : list) {
			if(temp.getUserId().equals(user.getUserId())){
				tlist.add(temp);
			}
			
		}
		list.removeAll(tlist);
		list.add(user);
		session.setAttribute("allUser", list);
		return "update-success";
	}
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	@Override
	public User getModel() {
		if(userId == null){
		user = new User();
		}else{
			HttpSession session = request.getSession();
			List<User> list = (List<User>) session.getAttribute("allUser");
			int index  = 0;
			for (User temp : list) {
				if(temp.getUserId().equals(userId)){
					index = list.indexOf(temp);
					System.out.println(index);
				}
			}
			user = list.get(index);
		}
		return user;
	}
	
}
