package tw.com.web;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.com.web.tools.Utils;

@WebServlet("/view_images")
public class ViewImagesServlet extends HttpServlet {
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			Path imagePath = Utils.getImageIOPath();
			List<String> imageFileList = Files.list(imagePath).
					map(p->p.getFileName().toString()).
					collect(Collectors.toList());
			//System.out.println(imageFileList);
			req.setAttribute("imageList", imageFileList);
			req.getRequestDispatcher("image_view.jsp").forward(req, resp);
		}
}
