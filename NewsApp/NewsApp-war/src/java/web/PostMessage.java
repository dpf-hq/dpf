/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package web;

import ejb.NewsEntity;
import java.io.IOException;
import java.io.PrintWriter;
import javax.annotation.Resource;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author fma
 */
public class PostMessage extends HttpServlet {

    @Resource (mappedName="jms/NewMessageFactory")
    private ConnectionFactory connectionFactory;

    @Resource (mappedName="jms/NewMessage")
    private Queue queue;

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String title = request.getParameter("title");
        String body = request.getParameter("body");

        if(null!=title && null != body){
            try {
                Connection con = connectionFactory.createConnection();
                Session session = con.createSession(false, Session.AUTO_ACKNOWLEDGE);
                MessageProducer messageProducer = session.createProducer(queue);

                ObjectMessage m = session.createObjectMessage();
                //here we create NewsEntity, that will be sent in JMS message
                NewsEntity e = new NewsEntity();
                e.setTitle(title);
                e.setBody(body);

                m.setObject(e);
                messageProducer.send(m);
                messageProducer.close();;
                con.close();;
                response.sendRedirect("ListNews");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet ListNews</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<form>");
        out.println("Title: <input type='text' name='title'/><br/>");
        out.println("Message: <textarea name='body'></textarea><br/>");
        out.println("<input type='submit'/><br/>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");

    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
