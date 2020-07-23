
create table log(
	id bigint(20) unsigned not null auto_increment,
    ip varchar(255) not null,
    method  varchar(10) not null,
    regdate datetime,
    primary key (id)
);
