package gradebook.domain;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
public class Course {
	
	@Id
	int Cid;
	
	@Column
	@ManyToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL, mappedBy="id")
	int profID;	
	@Column
	String courseName;
	@Column
	String dept;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL, mappedBy="id")
	@Column(name = "students")
	@Fetch(FetchMode.JOIN)
	Set<Student> students = new HashSet<Student>();
	
	@OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL, mappedBy="Aid")
	@Column(name = "assignments")
	@Fetch(FetchMode.JOIN)
	Set<Assignment> assignments = new HashSet<Assignment>();
}
