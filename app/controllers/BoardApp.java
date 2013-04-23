package controllers;

import java.util.Date;
import java.util.List;

import models.Article;
import models.Comment;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.board.boardList;
import views.html.board.boardView;

public class BoardApp extends Controller {

	public static Result init() {
		//add sample data
		
		for (int i = 0; i < 50; i++) {
			Article article = new Article();
			article.id = 10L + i;
			article.contents = "test data";
			article.name = "wansoon : " + i;
			article.createDate = new Date();
								
			article.save();
		}
		
		return ok("init ok");
	}
	
	public static Result list() {
		
		String page = request().getQueryString("page");
		
		int pageSize = 10;
		List<Article> list = Article.finder
				.where()
				.orderBy("id asc")
				.findPagingList(pageSize)
				.getPage(Integer.parseInt(page) - 1)
				.getList();
		
		return ok(boardList.render("List Page", list));
	}
	
	public static Result view(Long id) {

		Article article = Article.finder.byId(id);
		
		return ok(boardView.render("View Page", article));
	}
	
	
	public static Result inputForm() {
		
		return ok("inputForm");
	}
	
	public static Result save() {
		return redirect(routes.BoardApp.list());
	}
	
	public static Result saveComment(Long articleId) {
		
		Form<Comment> commentForm = Form.form(Comment.class).bindFromRequest();

		Comment comment = commentForm.get();

		comment.article = Article.finder.byId(articleId);
		comment.save();
		
		return redirect(routes.BoardApp.view(articleId));
	}
	
	public static Result deleteComment(Long articleId, Long commentId) {
		Comment comment = Comment.finder.byId(commentId);
		comment.delete();

		//aaaaaso;dasdl;jasldjkasdklajsdkjasdklj
		return redirect(routes.BoardApp.view(articleId));
	}

}
