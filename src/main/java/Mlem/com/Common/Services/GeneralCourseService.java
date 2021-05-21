package Mlem.com.Common.Services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Mlem.com.Common.Entity.GeneralCourse;
import Mlem.com.Common.Repository.GeneralCourseRepository;


@Service
@Transactional
public class GeneralCourseService {
 @Autowired
	private GeneralCourseRepository repo;
 
public List<GeneralCourse> listAll() {
    return repo.findAll();
}
 
public void save(GeneralCourse generalCourse) {
    repo.save(generalCourse);
}
 
public GeneralCourse get(int id) {
    return repo.findById(id).get();
}
 
public void GeneralCourse(int id) {
    repo.deleteById(id);
}
}
