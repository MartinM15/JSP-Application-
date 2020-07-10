package org.fullstack;


import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.fullstack.hibernate.DAO.FilesDAO;
import org.fullstack.hibernate.entity.Files;


@WebServlet("/ImageUpload")
public class ImageUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public String path = "C:/images/";
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		
		switch (action) {
		case "filesUpload":
			filesUpload(request, response);
			break;
		case "listingImages":
			listingImages(request,response);
		
			break;
		default:
			request.getRequestDispatcher("index.jsp").forward(request, response);
			break;
		}
		
	
	}
	
	
	
	private void listingImages(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Files> files = new FilesDAO().listFiles();
		request.setAttribute("files", files);
		request.setAttribute("path", path);
		request.getRequestDispatcher("listFiles.jsp").forward(request, response);
		
	}



	public void filesUpload(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletFileUpload upload = new ServletFileUpload(new DiskFileItemFactory());
		
		try {
			List<FileItem> images = upload.parseRequest(request);
			for(FileItem image : images) {
				String name = image.getName();	
				
				
				try {
					System.out.println(name);
					File file = new File((path+name));
					if(!file.exists()) {
						new FilesDAO().addFilesDetails(new Files(name));
						image.write(file);
					}
					listingImages(request, response);
			
				} catch (Exception e) {
					
					e.printStackTrace();
				}
			}
		} catch (FileUploadException e) {
			
			e.printStackTrace();
		}
		
	}
}
