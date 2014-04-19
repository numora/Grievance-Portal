INSERT INTO ADDRESS
	(ADDRESS_ID, ADDRESS_LINE_1, ADDRESS_LINE_2, STATE, CITY, ZIP, PO_BOX)
VALUES 
	(1, 'TEST STREET1', 'TEST APT1', 'CA', 'FREMONT', '94538', '123');

INSERT INTO USER
	(USER_ID, PASSWORD, EMAIL_ID, LAST_MODIFIED_DATE, LOGIN_NAME, CREATED_DATE, VERIFIED, ROLE_ID, DOB, "LANGUAGE", ADDRESS_ID,activate_id)
VALUES 
	(1, '1234', 'test1@test.com','2013-06-05' , 'test1','2013-06-05' , 'Y', 1, '2013-06-05', 'english',1,1);

INSERT INTO USER
	(USER_ID, PASSWORD, EMAIL_ID, LAST_MODIFIED_DATE, LOGIN_NAME, CREATED_DATE, VERIFIED, ROLE_ID, DOB, "LANGUAGE", ADDRESS_ID,activate_id)
VALUES 
	(2, '1234', 'test2@test.com','2014-01-01' , 'test2','2014-01-01' , 'Y', 2, '2014-01-01', 'english',1,1);
INSERT INTO USER
	(USER_ID, PASSWORD, EMAIL_ID, LAST_MODIFIED_DATE, LOGIN_NAME, CREATED_DATE, VERIFIED, ROLE_ID, DOB, "LANGUAGE", ADDRESS_ID,activate_id)
VALUES 
	(3, '1234', 'test3@test.com','2014-01-01' , 'test3','2014-01-01' , 'Y', 3, '2014-01-01', 'english',1,1);
	
	insert into provider(provider_id,provier_name,provider_speciality,provider_type) values (1,'Kaiser','Kaiser','Kaiser');
	insert into provider(provider_id,provier_name,provider_speciality,provider_type) values (2,'Anthem','Anthem','Anthem');
	insert into provider(provider_id,provier_name,provider_speciality,provider_type) values (0,'Anthem Kaiser','Anthem Kaiser','Anthem Kaiser');
	insert into member(member_id,first_name,last_name,middle_initial,suffix,phone,address_id,provider_id) values (1,'sujan','kumar','v','v','4159909362',1,1)
	