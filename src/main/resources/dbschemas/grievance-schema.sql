CREATE TABLE  IF NOT EXISTS grievance_schema;

CREATE TABLE  IF NOT EXISTS `grievance_schema`.`user` (
          `id` bigint(20) NOT NULL AUTO_INCREMENT,
          `emailAddress` varchar(255) DEFAULT NULL,
          `lastAccessTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
          `login_name` varchar(255) DEFAULT NULL,
          `password` varchar(255) DEFAULT NULL,
          `registrationDate` date DEFAULT NULL,
          `verified` bit(1) DEFAULT NULL,
          PRIMARY KEY (`id`)
        ) ;


CREATE TABLE   IF NOT EXISTS `grievance_schema`.`grievance_details` (
         `member_id` bigint(20) NOT NULL AUTO_INCREMENT,
         `SSN` bigint(15) DEFAULT '0',
         `member_name` varchar(765) DEFAULT 'NULL',
         `request_type` varchar(765) DEFAULT 'NULL',
         `request_date` datetime DEFAULT NULL,
         `email_id` varchar(765) DEFAULT 'NULL',
         `contact_no` bigint(15) DEFAULT '0',
         `comments` varchar(765) DEFAULT 'NULL',
         `file` blob,
         PRIMARY KEY (`member_id`)
       );

CREATE TABLE IF NOT EXISTS `grievance_schema`.`greivance_registration` (
          `reg_id` bigint(20) NOT NULL AUTO_INCREMENT,
          `mem_first_name` varchar(100) DEFAULT NULL,
          `mem_last_name` varchar(100) DEFAULT NULL,
          `mem_middle_initial` varchar(50) DEFAULT NULL,
          `mem_suffix` varchar(10) DEFAULT NULL,
          `mem_provider_type` varchar(50) DEFAULT NULL,
          `mem_provider_speciality` varchar(50) DEFAULT NULL,
          `fed_first_name` varchar(100) DEFAULT NULL,
          `fed_last_name` varchar(100) DEFAULT NULL,
          `fed_middle_initail` varchar(50) DEFAULT NULL,
          `fed_suffix` varchar(10) DEFAULT NULL,
          `fed_provider_type` varchar(50) DEFAULT NULL,
          `fed_provider_speciality` varchar(50) DEFAULT NULL,
          `fed_date_of_birth` timestamp NULL DEFAULT NULL,
          `mem_street` varchar(100) DEFAULT NULL,
          `mem_city` varchar(100) DEFAULT NULL,
          `mem_state` varchar(100) DEFAULT NULL,
          `mem_zip` bigint(20) DEFAULT NULL,
          `mem_phone` bigint(20) DEFAULT NULL,
          `fed_street` varchar(100) DEFAULT NULL,
          `fed_city` varchar(100) DEFAULT NULL,
          `fed_state` varchar(100) DEFAULT NULL,
          `fed_zip` bigint(20) DEFAULT NULL,
          `fed_phone` bigint(20) DEFAULT NULL,
          `license_type` varchar(100) DEFAULT NULL,
          `license_number` bigint(50) DEFAULT NULL,
          `lic_exp_date` timestamp NULL DEFAULT NULL,
          `npi` bigint(20) DEFAULT NULL,
          `tax_id` bigint(20) DEFAULT NULL,
          `exclusion_code` varchar(50) DEFAULT NULL,
          `exclusion_desc` varchar(250) DEFAULT NULL,
          `exclusion_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
          `prov_speciality` varchar(100) DEFAULT NULL,
          `taxonomy` varchar(100) DEFAULT NULL,
          `attach_file` blob,
          `reg_status` varchar(30) DEFAULT NULL,
          PRIMARY KEY (`reg_id`)
        );
 CREATE TABLE IF NOT EXISTS `grievance_schema`.`signin_details` (
          `sign_id` int(11) NOT NULL AUTO_INCREMENT,
          `login_name` varchar(50) DEFAULT 'null',
          `password` varchar(50) DEFAULT 'null',
          `first_name` varchar(50) DEFAULT 'null',
          `last_name` varchar(50) DEFAULT 'null',
          `email_address` varchar(50) DEFAULT 'null',
          `repeat_email` varchar(50) DEFAULT 'null',
          `birthday` varchar(50) DEFAULT 'null',
          `month` varchar(50) DEFAULT '0',
          `year` year(4) DEFAULT NULL,
          `gender` varchar(50) DEFAULT 'null',
          `city` varchar(50) DEFAULT 'null',
          `country_region` varchar(50) DEFAULT 'null',
          `languege` varchar(50) DEFAULT 'null',
          `skype_name` varchar(50) DEFAULT 'null',
          `skype_password` varchar(50) DEFAULT 'null',
          `repeat_password` varchar(50) DEFAULT 'null',
          `skypeName_helper` varchar(50) DEFAULT 'null',
          PRIMARY KEY (`sign_id`)
        ) ;