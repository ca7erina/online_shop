package util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CheckCodeServlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Random r = new Random(System.currentTimeMillis());
		BufferedImage image = new BufferedImage(80, 30,
				BufferedImage.TYPE_INT_RGB);
		Graphics g = image.getGraphics();
		g.setColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
		g.fillRect(0, 0, 80, 30);

		String number = r.nextInt(999999) + "";
		HttpSession session = request.getSession();
		session.setAttribute("number", number);
		g.setColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
		g.setFont(new Font("arial", Font.BOLD, 18));
		g.drawString(number, 5, 20);
		for (int i = 0; i < 8; i++) {
			g.drawLine(r.nextInt(80), r.nextInt(30), r.nextInt(80), r
					.nextInt(30));
		}
		response.setContentType("image/jpg");
		OutputStream ops = response.getOutputStream();

		javax.imageio.ImageIO.write(image, "jpeg", ops);

	}

}
