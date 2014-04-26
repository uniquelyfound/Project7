package gradebook.domain;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;

import org.hibernate.FetchMode;
import org.hibernate.annotations.Fetch;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class Student {
	@Id
	int Sid;
	
	@Column
	String name;
		
	@ManyToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL, mappedBy="Aid")
	@Column(name = "assignments")
	@Fetch(FetchMode.JOIN)
	Set<Assignment> grades = new HashSet<Assignment>();
	
	@ManyToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL, mappedBy="Cid")
	@Column(name = "courses")
	@Fetch(FetchMode.JOIN)
	Set<Course> courses = new HashSet<Course>();
}
