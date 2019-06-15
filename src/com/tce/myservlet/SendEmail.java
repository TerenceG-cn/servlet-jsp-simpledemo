package com.tce.myservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.GeneralSecurityException;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.mail.util.MailSSLSocketFactory;

public class SendEmail extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String to = "1151778169@qq.com";// 收件人电子邮箱
		String from = "1035260902@qq.com";// 发件人电子邮箱
		String host = "smtp.qq.com";// 假设你是从qq邮箱的邮件服务器发送电子邮件？
		Properties properties = new Properties();// 初始化系统属性
		// properties.setProperty("mail.user", from);
		// properties.setProperty("mail.password", "cwdenawunxeubeij");
		properties.setProperty("mail.smtp.host", host);// 设置邮件服务器
		properties.setProperty("mail.debug", "true");// 开启debug调试，以便在控制台查看
		properties.setProperty("mail.smtp.auth", "true");// 发送服务器需要身份验证

		// 开启SSL加密，否则会失败
		MailSSLSocketFactory sf;
		try {
			sf = new MailSSLSocketFactory();
			sf.setTrustAllHosts(true);
			properties.put("mail.smtp.ssl.enable", "true");
			properties.put("mail.smtp.ssl.socketFactory", sf);

			// 获取新的的session
			Session session = Session.getInstance(properties);
			// 通过session得到transport对象
			Transport ts = session.getTransport();
			// 连接邮件服务器：邮箱类型，帐号，授权码代替密码（更安全）
			ts.connect("smtp.qq.com", "1035260902", "cwdenawunxeubeij");// 后面的字符是授权码

			MimeMessage msg = new MimeMessage(session);
			// 设置 From: header field of the header.
			msg.setFrom(new InternetAddress(from));
			msg.setRecipient(Message.RecipientType.TO, new InternetAddress(to));// addRecipient
			msg.setSubject("This is the Subject Line!");// 邮件的标题
//			//1.简单的文本
//			msg.setText("This is actual message");// 邮件的内容
//			//2.设置实际的 HTML 消息，内容大小不限
//	        msg.setContent("<h1>This is actual message</h1>",
//	                            "text/html" );
			// 3.带附件
			// 创建消息部分
			BodyPart messageBodyPart = new MimeBodyPart();

			// 填写消息
			messageBodyPart.setText("This is message body");

			// 创建一个多部分消息
			Multipart multipart = new MimeMultipart();

			// 设置文本消息部分
			multipart.addBodyPart(messageBodyPart);

			// 第二部分是附件
			messageBodyPart = new MimeBodyPart();
			String filename = "C:\\Users\\86155\\eclipse-workspaceForweb\\my_servlet\\WebContent\\enclosure\\file1.txt";
			DataSource source = new FileDataSource(filename);
			messageBodyPart.setDataHandler(new DataHandler(source));
			messageBodyPart.setFileName(filename);
			multipart.addBodyPart(messageBodyPart);

			// 发送完整的消息部分
			msg.setContent(multipart);

			// 发送消息 ts.send(msg);
			ts.sendMessage(msg, msg.getAllRecipients());
			ts.close();

		} catch (NoSuchProviderException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (GeneralSecurityException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (MessagingException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		} catch (Exception en) {
			// TODO: handle exception
			en.printStackTrace();
		}

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String title = "发送电子邮件";
		String res = "成功发送消息。。。";
		String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
		out.println(docType + "<html>\n" + "<head><title>" + title + "</title></head>\n"
				+ "<body bgcolor=\"#f0f0f0\">\n" + "<h1 align=\"center\">" + title + "</h1>\n" + "<p align=\"center\">"
				+ res + "</p>\n" + "</body></html>");

	}
}
