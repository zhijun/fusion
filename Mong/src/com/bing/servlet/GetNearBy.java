package com.bing.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bing.dao.MongManagerDao;
import com.bing.dao.MongManagerImpl;
import com.bing.vo.GeoPoint;
import com.bing.vo.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * Servlet implementation class GetNearBy
 */
@WebServlet(description = "get the list of near by people", urlPatterns = { "/GetNearBy" })
// http://localhost:8080/Mong/GetNearBy?x=30.753272247314453&y=104.09911346435547
// http://localhost:8080/Mong/GetNearBy?x=30.553272247314453&y=104.09911346435547
public class GetNearBy extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MongManagerImpl mongManagerDao = (MongManagerImpl) new MongManagerDao();
	Gson gson = new Gson();

	/**
	 * Default constructor.
	 */
	public GetNearBy() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String x = request.getParameter("x");

		String y = request.getParameter("y");
		System.out.println("获取的参数: x-->" + x + " y-->" + y);
		List<User> list = new ArrayList<User>();
		Double longitude = 0d, latitude = 0d;
		try {
			longitude = Double.parseDouble(x);
			latitude = Double.parseDouble(y);
		} catch (Exception e) {
			System.out.println("x　转Double出错");
		}
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		list = mongManagerDao
				.getNearBy(new GeoPoint(longitude, latitude), 0.03);

		Type type = new TypeToken<List<User>>() {
		}.getType();
		String beanListToJson = gson.toJson(list, type);
		System.out.println(beanListToJson);
		out.print(beanListToJson);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
