package Mlem.com.Common.Entity;


import java.util.Date;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "GeneralCourse")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class GeneralCourse {
	@Id
	@Column(name = "general_course_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "lc_id")
	private int lcId;
	@Column(name = "manager_id")
	private int managerId;
	@Column(name = "name_general_course")
	private String nameGeneralCourse;
	@Column(name = "des_general_course")
	private String desGeneralCourse;
	@Column(name = "price_course")
	private int priceCourse;
	@Column(name = "create_date")
	private Date createDate;
	@Column(name = "image_course")
	private String image;
}
