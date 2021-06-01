package Mlem.com.Common.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Mlem.com.Common.Entity.CatagoriesCourse;

@Repository
public interface CategoriesCourseRepository extends JpaRepository<CatagoriesCourse, Integer> {

}
