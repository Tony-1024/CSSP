package edu.cssp.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.cssp.beans.Clubs;
import edu.cssp.dao.ClubsDao;
import edu.cssp.dao.impl.ClubsDaoImpl;
import net.sf.json.JSONArray;

public class ClubServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -685624275519308138L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String reqType = req.getParameter("reqType");
		if (reqType != null && reqType.compareToIgnoreCase("getClubByDimID") == 0) {
			String dimIDStr = (String) req.getParameter("dimID");
			if (dimIDStr == null || dimIDStr.trim() == "")
				return;
			int dimID = Integer.parseInt(dimIDStr);
			ClubsDao cbd = new ClubsDaoImpl();
			List<Clubs> cbList = cbd.getClubsByDimensionID(dimID);
			JSONArray jsonArray = JSONArray.fromObject(cbList);
			resp.getWriter().write(jsonArray.toString());
			System.out.println(jsonArray.toString());
		}
	}
}