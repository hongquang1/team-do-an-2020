package Mlem.com.Common.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Mlem.com.Common.Entity.CatagoriesCourse;
import Mlem.com.Common.Repository.CategoriesCourseRepository;

@Service
public class CategoriesCourseService {

	@Autowired
	CategoriesCourseRepository repo;
	
	public void saveCategoriesCourse(int[] array,int course) {
		for (int i = 0; i < array.length; i++) {
			CatagoriesCourse c = new  CatagoriesCourse();
			c.setCourseId(course);
			c.setCateId(array[i]);
			repo.save(c);
		}
	}
}
