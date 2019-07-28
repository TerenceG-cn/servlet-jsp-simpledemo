package com.tce.myservlet;

import java.io.*;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletConfig;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


public class UploadServlet extends HttpServlet {
	private boolean isMulitpart; // ���������һ���ļ��ϴ�����
	private String filePath;
	private int maxFilesSize = 50 * 1024;
	private int maxMemSize = 4 * 1024;
	private File file;

	public void init() {
		//��ȡ�ļ������洢��λ��
		filePath = getServletContext().getInitParameter("file-upload");
		System.out.println("filepath:"+filePath);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		isMulitpart = ServletFileUpload.isMultipartContent(request);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		if (!isMulitpart) {
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Servlet upload</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<p>No file uploaded</p>");
			out.println("</body>");
			out.println("</html>");
			return;
		}
		DiskFileItemFactory df_factory = new DiskFileItemFactory();
		// �ļ���С�����ֵ���洢���ڴ���
		df_factory.setSizeThreshold(maxFilesSize);
		df_factory.setRepository(new File("c:\\temp"));

		// ����һ���µ��ļ��ϴ��������
		ServletFileUpload upload = new ServletFileUpload(df_factory);
		// �����ϴ����ļ���С�����ֵ
		upload.setSizeMax(maxFilesSize);

		try {
			List fileItems = upload.parseRequest(request);
			Iterator iterator = fileItems.iterator();

			out.println("<html>");
			out.println("<head>");
			out.println("<title>Servlet upload</title>");
			out.println("</head>");
			out.println("<body>");
			while (iterator.hasNext()) {
				FileItem fi = (FileItem) iterator.next();
				if (!fi.isFormField()) {
					String fielddName = fi.getFieldName();
					String fileName = fi.getName();
					String contentType = fi.getContentType();
					boolean isInMemory = fi.isInMemory();
					long sizeInBytes = fi.getSize();
					// д���ļ�
					if (fileName.lastIndexOf("\\") >= 0) {
						file = new File(filePath + fileName.substring(fileName.lastIndexOf("\\") + 1));
					} else {
						file = new File(filePath + fileName.substring(fileName.lastIndexOf("\\") + 1));
					}
					fi.write(file);
					out.println("Upload Filename: " + fileName + "<br>");
				}
			}
			out.println("</body>");
			out.println("</html>");
		} catch (Exception ex) {
			// TODO: handle exception
			System.out.println(ex);
		}
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {
		throw new ServletException("GET method used with " + getClass().getName() + ": POST method required.");
	}
}
