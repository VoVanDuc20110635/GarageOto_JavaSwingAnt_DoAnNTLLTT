/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.Service;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
/**
 *
 * @author WINDOWS 10
 */
public class MailSender {
    public void sendEmail(String to, String from, String host, String subject, String customerName, String[][] items) {
        // Get system properties
        Properties properties = System.getProperties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        // Setup mail server
        properties.setProperty("mail.smtp.host", host);

        
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication(){
                return new  PasswordAuthentication("voduc0100@gmail.com", "arozojkhspxuuxeg");
            }
        });

        try {
            // Create a default MimeMessage object
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: header field
            message.setSubject(subject);

            // Now set the actual message
//            message.setText(text);
            
//            String htmlMessage = buildHtmlBill(customerName, items);
            String htmlMessage = buildHtmlBill2();
//            message.setContent(htmlMessage, "text/html");
            message.setContent(htmlMessage, "text/html; charset=UTF-8");
            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
    private String buildHtmlBill(String customerName, String[][] items) {
        StringBuilder sb = new StringBuilder();
        sb.append("<html><body>");
        sb.append("<html><head><meta charset='UTF-8'></head><body>");
        sb.append("<h1>Garage Car Bill</h1>");
        sb.append("<p>Customer Name: ").append(customerName).append("</p>");
        sb.append("<table border='1' style='border-collapse: collapse;'>");
        sb.append("<tr><th>Item</th><th>Quantity</th><th>Price</th><th>Total</th></tr>");
        for (String[] item : items) {
            sb.append("<tr>");
            sb.append("<td>").append(item[0]).append("</td>");
            sb.append("<td>").append(item[1]).append("</td>");
            sb.append("<td>").append(item[2]).append("</td>");
            sb.append("<td>").append(item[3]).append("</td>");
            sb.append("</tr>");
        }
        sb.append("</table>");
        sb.append("</body></html>");
        return sb.toString();
    }

    public String buildHtmlBill2() {
    // Use StringBuilder to create the HTML content
        StringBuilder sb = new StringBuilder();
        sb.append("<html><head><meta charset='UTF-8'></head><body style='font-family: Arial, sans-serif; background-color: #f7f7f7; color: #333;'>");
        sb.append("<div style='max-width: 600px; margin: auto; background-color: #fff; padding: 20px; border: 1px solid #ddd;'>");
        sb.append("<h2 style='text-align: center; color: #4A90E2;'>Garage oto Lâm Vinh</h2>");
        sb.append("<p style='text-align: center;'>Thời gian in phiếu: 03/04/2024 22:20</p>");
        sb.append("<h1 style='background-color: #4A90E2; color: #fff; padding: 10px; text-align: center;'>HÓA ĐƠN</h1>");
        sb.append("<p>Mã phiếu: HD027KH001</p>");
        sb.append("<p>Khách hàng: Nguyễn Văn An - 123 Đường ABC, Quận 1, TP.HCM</p>");
        sb.append("<p>Người thực hiện: Tuyết Tuyết Nhi - Mã nhân viên: NV005</p>");
        sb.append("<p>Thời gian nhập: 2024-04-03 22:20:00</p>");
        sb.append("<p>Tổng thành tiền: <strong>2,120,000đ</strong></p>");
        sb.append("<br>");

        sb.append("<table style='width: 100%; border-collapse: collapse; border: 1px solid #ddd; background-color: #fff;'>");
        sb.append("<tr style='background-color: #4A90E2; color: #fff;'>");
        sb.append("<th style='padding: 8px; border: 1px solid #ddd;'>Mã hàng hóa</th>");
        sb.append("<th style='padding: 8px; border: 1px solid #ddd;'>Tên hàng hóa</th>");
        sb.append("<th style='padding: 8px; border: 1px solid #ddd;'>Giá</th>");
        sb.append("<th style='padding: 8px; border: 1px solid #ddd;'>Số lượng</th>");
        sb.append("<th style='padding: 8px; border: 1px solid #ddd;'>Giảm giá</th>");
        sb.append("<th style='padding: 8px; border: 1px solid #ddd;'>Tổng</th>");
        sb.append("</tr>");
        sb.append("<tr>");
        sb.append("<td style='padding: 8px; border: 1px solid #ddd;'>HH002</td>");
        sb.append("<td style='padding: 8px; border: 1px solid #ddd;'>HH002</td>");
        sb.append("<td style='padding: 8px; border: 1px solid #ddd;'>120,000đ</td>");
        sb.append("<td style='padding: 8px; border: 1px solid #ddd;'>1</td>");
        sb.append("<td style='padding: 8px; border: 1px solid #ddd;'>0.0</td>");
        sb.append("<td style='padding: 8px; border: 1px solid #ddd;'>120,000đ</td>");
        sb.append("</tr>");
        sb.append("<tr>");
        sb.append("<td style='padding: 8px; border: 1px solid #ddd;'>HH005</td>");
        sb.append("<td style='padding: 8px; border: 1px solid #ddd;'>HH005</td>");
        sb.append("<td style='padding: 8px; border: 1px solid #ddd;'>2,000,000đ</td>");
        sb.append("<td style='padding: 8px; border: 1px solid #ddd;'>1</td>");
        sb.append("<td style='padding: 8px; border: 1px solid #ddd;'>0.0</td>");
        sb.append("<td style='padding: 8px; border: 1px solid #ddd;'>2,000,000đ</td>");
        sb.append("</tr>");
        sb.append("</table>");
        sb.append("<br>");

        sb.append("<div style='width: 100%; overflow: auto; margin-bottom: 50px;'>"); // Container for the three signature blocks

        // Individual signature blocks
        sb.append("<div style='width: 33%; float: left; text-align: center;'>");
        sb.append("<p>Người lập phiếu</p>");
        sb.append("<p>(Ký và ghi rõ họ tên)</p>");
        sb.append("<p></p>");
        sb.append("</div>");

        sb.append("<div style='width: 33%; float: left; text-align: center;'>");
        sb.append("<p>Nhân viên nhận</p>");
        sb.append("<p>(Ký và ghi rõ họ tên)</p>");
        sb.append("<p></p>");
        sb.append("</div>");

        sb.append("<div style='width: 33%; float: left; text-align: center;'>");
        sb.append("<p>Nhà cung cấp</p>");
        sb.append("<p>(Ký và ghi rõ họ tên)</p>");
        sb.append("<p></p>");
        sb.append("</div>");

        sb.append("</div>");
        sb.append("</body></html>");

        return sb.toString();
    }
}
