drop table if exists employers;
create table employers (
    id int not null auto_increment primary key,
    name varchar(80) not null unique,
    industry varchar(80), 
    description text not null
) engine=innodb;

insert into employers (id, name, description, industry)
values 
(1, 'Myer', 'Australia\'s largest department store chain','retail'),
(2, 'David Jones', 'Australia\'s most pretentious department store chain', 'retail');


drop table if exists jobs;
create table jobs (
    id int not null auto_increment primary key,
    employer int references employers(id),
    title varchar(80) not null,
    location varchar(80) not null,
    description text not null,
    salary int not null,
    startDate DATE,
    finalDate DATE
) engine=innodb;

drop table if exists people;
create table people (
	id INT NOT NULL AUTO_INCREMENT,
	username varchar(32) NOT NULL,
	password varchar(32) NOT NULL,
	email varchar(32) NOT NULL,
	firstname varchar(32),
	lastname varchar(32),
	category varchar(32) NOT NULL,
	employer int references employers(id),
	phone int NOT NULL,
	imagedata blob default "",
    imagename varchar(40) default "",
    imagetype varchar(40) default "",
    imagesize varchar(40) default "",
	PRIMARY KEY (id),
	UNIQUE KEY (username),
	UNIQUE KEY (email),
	KEY (password)) engine=innodb;

drop table if exists apply;
create table apply(
	id int not null auto_increment primary key,
	employerId int references people(id),
	letter varchar(300),
	Time    TIMESTAMP,
	firstname varchar(32) NOT NULL,
	lastname varchar(32) NOT NULL,
	jobTitle varchar(32) NOT NULL,
	jobId int references jobs(id)) engine=innodb;
	
insert into jobs (employer, title, location, description, salary)
values 
(1, 'CEO', 'Brisbane', 'Chief Elephant Orderer', 100000),
(1, 'Sales assistant', 'Brisbane', 'Sales assistant in Menswear', 50000),
(1, 'CIO', 'Sydney', 'He who makes the computer sytems work', 200000),
(2, 'Accountant', 'Melbourne', 'Does the books', 75000);

insert into people(username, password, email, firstname, lastname, category, employer, phone, imagedata, imagename, imagetype, imagesize)
values
('admin','ad7NbXmflAESA','watb@gmail.com','DongMin','Kim','Administrator', NULL,0422165337,NULL,NULL,NULL,NULL);