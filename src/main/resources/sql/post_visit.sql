create table post_visit (
  id int not null auto_increment,
  post_id varchar(15) not null unique,
  visit int not null, primary key(id));