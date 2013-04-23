package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.apache.commons.lang3.StringUtils;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;

@Entity
public class Comment extends Model {
	private static final long serialVersionUID = -6011507996193307620L;
	
	public static Finder<Long, Comment> finder = new Finder<Long, Comment>(Long.class, Comment.class);
	
	@Id
	public Long id;
	
	@Required
	public String name;
	
	public String text;
	
    @ManyToOne
    public Article article;
    
    // ad-hoc validation
    /*public String validate() {
    	if (StringUtils.isEmpty(name)) {
    		return "Invalid name value";
    	}
    	return null;
    }*/
}
