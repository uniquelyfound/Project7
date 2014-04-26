package gradebook.domain;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.FetchMode;
import org.hibernate.annotations.Fetch;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class Assignment {
	@Id
	int Aid;
	
	@Column
	String aType;
	
	@Column
	Float grade;
	
	@Column
	Float possible_points;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL, mappedBy="Cid")
	@Column(name = "course")
	@Fetch(FetchMode.JOIN)
	int course;
}
