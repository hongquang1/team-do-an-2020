package Mlem.com.Common.Entity;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Entity
@Table(name = "payment")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PayMent {

	@Id
	@Column(name = "pay_ment_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "general_course_id")
	private int generalCourseId;
	@Column(name = "account_id")
	private int accountId;

}
