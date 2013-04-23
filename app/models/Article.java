package models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;

import play.data.format.Formats;
import play.data.validation.Constraints;
import play.db.ebean.Model;
import scala.runtime.TraitSetter;



@Entity
public class Article extends Model {
	
	private static final long serialVersionUID = -4743335036682300002L;
	public static Finder<Long, Article> finder = new Finder<Long, Article>(Long.class, Article.class);

	@Id
	public Long id;

	@Constraints.Required
	public String name;
	
	public String contents;
	
	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date createDate;
	
	@OneToMany(cascade = CascadeType.ALL)
	public List<Comment> comments;
	
	@Transient
	public int getCommentCount() {
		return comments.size();
	}
}
