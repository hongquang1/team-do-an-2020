package Mlem.com.Common.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "categories_course")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CatagoriesCourse {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	@Column(name = "course_id")
	int courseId;
	@Column(name = "cate_id")
	int cateId;
}
