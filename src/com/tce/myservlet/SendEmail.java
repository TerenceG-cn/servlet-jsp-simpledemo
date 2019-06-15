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
		String to = "1151778169@qq.com";// �ռ��˵�������
		String from = "1035260902@qq.com";// �����˵�������
		String host = "smtp.qq.com";// �������Ǵ�qq������ʼ����������͵����ʼ���
		Properties properties = new Properties();// ��ʼ��ϵͳ����
		// properties.setProperty("mail.user", from);
		// properties.setProperty("mail.password", "cwdenawunxeubeij");
		properties.setProperty("mail.smtp.host", host);// �����ʼ�������
		properties.setProperty("mail.debug", "true");// ����debug���ԣ��Ա��ڿ���̨�鿴
		properties.setProperty("mail.smtp.auth", "true");// ���ͷ�������Ҫ�����֤

		// ����SSL���ܣ������ʧ��
		MailSSLSocketFactory sf;
		try {
			sf = new MailSSLSocketFactory();
			sf.setTrustAllHosts(true);
			properties.put("mail.smtp.ssl.enable", "true");
			properties.put("mail.smtp.ssl.socketFactory", sf);

			// ��ȡ�µĵ�session
			Session session = Session.getInstance(properties);
			// ͨ��session�õ�transport����
			Transport ts = session.getTransport();
			// �����ʼ����������������ͣ��ʺţ���Ȩ��������루����ȫ��
			ts.connect("smtp.qq.com", "1035260902", "cwdenawunxeubeij");// ������ַ�����Ȩ��

			MimeMessage msg = new MimeMessage(session);
			// ���� From: header field of the header.
			msg.setFrom(new InternetAddress(from));
			msg.setRecipient(Message.RecipientType.TO, new InternetAddress(to));// addRecipient
			msg.setSubject("This is the Subject Line!");// �ʼ��ı���
//			//1.�򵥵��ı�
//			msg.setText("This is actual message");// �ʼ�������
//			//2.����ʵ�ʵ� HTML ��Ϣ�����ݴ�С����
//	        msg.setContent("<h1>This is actual message</h1>",
//	                            "text/html" );
			// 3.������
			// ������Ϣ����
			BodyPart messageBodyPart = new MimeBodyPart();

			// ��д��Ϣ
			messageBodyPart.setText("This is message body");

			// ����һ���ಿ����Ϣ
			Multipart multipart = new MimeMultipart();

			// �����ı���Ϣ����
			multipart.addBodyPart(messageBodyPart);

			// �ڶ������Ǹ���
			messageBodyPart = new MimeBodyPart();
			String filename = "C:\\Users\\86155\\eclipse-workspaceForweb\\my_servlet\\WebContent\\enclosure\\file1.txt";
			DataSource source = new FileDataSource(filename);
			messageBodyPart.setDataHandler(new DataHandler(source));
			messageBodyPart.setFileName(filename);
			multipart.addBodyPart(messageBodyPart);

			// ������������Ϣ����
			msg.setContent(multipart);

			// ������Ϣ ts.send(msg);
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
		String title = "���͵����ʼ�";
		String res = "�ɹ�������Ϣ������";
		String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
		out.println(docType + "<html>\n" + "<head><title>" + title + "</title></head>\n"
				+ "<body bgcolor=\"#f0f0f0\">\n" + "<h1 align=\"center\">" + title + "</h1>\n" + "<p align=\"center\">"
				+ res + "</p>\n" + "</body></html>");

	}
}
