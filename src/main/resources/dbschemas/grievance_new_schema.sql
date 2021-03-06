drop table IF EXISTS user_grievances;
drop table IF EXISTS grievance_comments;
drop table IF EXISTS grievance;
drop table IF EXISTS comments;
drop table IF EXISTS user;
drop table IF EXISTS member;
drop table IF EXISTS address;
drop table IF EXISTS provider;

create table address(address_id bigint generated by default as identity (start with 1),
address_line_1 varchar(255),
address_line_2 varchar(255),
state varchar(2),
city varchar(100),
zip varchar(10),
po_box varchar(10),
primary key(address_id));
create table provider(provider_id bigint generated by default as identity (start with 1),
provier_name varchar(100),
provider_speciality varchar(100),
provider_type varchar(100),
primary key(provider_id)); 
create table member(member_id bigint generated by default as identity (start with 1),
first_name varchar(100),
last_name varchar(100),
middle_initial varchar(50),
suffix varchar(10),
phone bigint,
address_id bigint,
provider_id bigint,
FOREIGN KEY (provider_id) REFERENCES provider(provider_id),
FOREIGN KEY (address_id) REFERENCES address(address_id),
primary key(member_id));
create table user (user_id bigint generated by default as identity (start with 1), 
password varchar(255),
email_id varchar(255),
last_modified_date timestamp, 
login_name varchar(255),  
created_date date,
verified bit,
role_id integer,
activate_id integer,
dob date,
language varchar(50),
address_id bigint,
FOREIGN KEY (address_id) REFERENCES address(address_id), 
primary key (user_id));
create table comments(comment_id bigint generated by default as identity (start with 1),
comment varchar(1000),
added_by_user bigint,
added_date timestamp,
FOREIGN KEY (added_by_user) REFERENCES user(user_id),
primary key(comment_id));
create table grievance(grievance_id bigint generated by default as identity (start with 1),
grievance_type integer,
ssn varchar(10),
contact_cell varchar(15),
contact_email varchar(20),
license_type varchar(100),
license_number bigint,
lic_exp_date timestamp,
npi bigint,
tax_id bigint,
exclusion_code varchar(50),
exclusion_desc varchar(250),
exclusion_date timestamp,
taxonomy varchar(100),
fed_member_id bigint,
member_id bigint,
FOREIGN KEY (fed_member_id) REFERENCES member(member_id),
FOREIGN KEY (member_id) REFERENCES member(member_id),
primary key(grievance_id));
create table grievance_comments(
grievance_id bigint,
comment_id bigint,
FOREIGN KEY (grievance_id) REFERENCES grievance(grievance_id),
FOREIGN KEY (comment_id) REFERENCES comments(comment_id),
primary key(grievance_id,comment_id));
create table user_grievances(
grievance_id bigint,
user_id bigint,
FOREIGN KEY (grievance_id) REFERENCES grievance(grievance_id),
FOREIGN KEY (user_id) REFERENCES user(user_id),
primary key(grievance_id,user_id));
