package Mlem.com.Common.Request;

import Mlem.com.Common.Entity.GeneralCourse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateGeneralCourseRequest {
	GeneralCourse generalCourse;
	int[] cateIdArray;
}
