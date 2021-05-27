﻿CREATE TABLE LevelCourse(
    lc_id int  NOT NULL primary key,
    level_name varchar(255)
	
);
Insert into LevelCourse (lc_id,level_name) values (1,'Sơ Cấp');
Insert into LevelCourse (lc_id,level_name) values (2,'Trung Cấp');
Insert into LevelCourse (lc_id,level_name) values (3,'Cao cấp');
CREATE TABLE categories(
	cate_id int  NOT NULL primary key,
   cate_name varchar(100)
);
Insert into categories (cate_id,cate_name) values (1,'Nướng');
Insert into categories (cate_id,cate_name) values (2,'Hấp');
Insert into categories (cate_id,cate_name) values (3,'Xào');
Insert into categories (cate_id,cate_name) values (4,'Món chay');
Insert into categories (cate_id,cate_name) values (5,'Món chiên');
CREATE TABLE GeneralCourse(
    general_course_id int  GENERATED BY DEFAULT AS IDENTITY NOT NULL primary key,
	lc_id int ,
	manager_id int,
	name_general_course varchar(500),
	des_general_course varchar(2000),
	price_course float8,
    create_date "timestamp" ,
	sale_price FLOAT8,
	content_general_course varchar(2000),
	imgae_course varchar(500),
	urlvideo_course varchar(500),
	urlyoutube_course varchar(500),
	cate_id int,
	FOREIGN KEY (lc_id) REFERENCES LevelCourse(lc_id),
	FOREIGN KEY (cate_id) REFERENCES categories(cate_id)
);
CREATE TABLE categoriesdetail(
	cate_id int ,
   general_course_id int,
	FOREIGN KEY (cate_id) REFERENCES categories(cate_id),
	FOREIGN KEY (general_course_id) REFERENCES GeneralCourse(general_course_id),
	PRIMARY KEY(cate_id,general_course_id)

);
