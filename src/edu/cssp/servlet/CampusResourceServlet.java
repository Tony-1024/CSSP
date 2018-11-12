package edu.cssp.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.cssp.beans.CampusResource;
import edu.cssp.dao.CampusResourceDao;
import edu.cssp.dao.impl.CampusResourceDaoImpl;
import net.sf.json.JSONArray;

public class CampusResourceServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3715008534451069014L;
	@Override  
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)  
            throws ServletException, IOException  
    {  
		doPost(req, resp);  
    }
	
	@Override  
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)  
            throws ServletException, IOException  
    {
		String reqType = req.getParameter("reqType");
		if(reqType!=null && reqType.compareToIgnoreCase("getResByDimID")==0)
		{
			String dimIDStr = (String)req.getParameter("dimID");
			if(dimIDStr==null || dimIDStr.trim()=="")
				return;
			int dimID = Integer.parseInt(dimIDStr);
			CampusResourceDao crd = new CampusResourceDaoImpl();
			List<CampusResource> crList = crd.getCampusResourcesByDimensionID(dimID);
			JSONArray jsonArray = JSONArray.fromObject(crList);  
			resp.getWriter().write(jsonArray.toString());
			System.out.println(jsonArray.toString());
		}
    }
}
