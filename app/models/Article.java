package models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import play.data.format.Formats;
import play.data.validation.Constraints;
import play.db.ebean.Model;



@Entity
public class Article extends Model {
	
	private static final long serialVersionUID = -4743335036682300002L;

	@Id
	@SequenceGenerator(name = "article_seq")
	public Long id;

	@Constraints.Required
	public String name;
	
	public String contents;
	
	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date createDate;
	
	public static Finder<Long, Article> finder = new Finder<Long, Article>(Long.class, Article.class);
}
