CREATE TABLE `guestbook` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT 'guestbook id',
   `name` VARCHAR(255) NOT NULL COMMENT 'user name',
  `content` TEXT NOT NULL COMMENT 'guestbook content',
  `regdate` DATETIME NULL DEFAULT NULL COMMENT '등록일',
  PRIMARY KEY (`id`)) ENGINE=InnoDB DEFAULT CHARSET=utf8;


insert into guestbook value ('0','길동','ㅇㅁdsasasdㄴdsadsfㅁㄴㅇ','2019-11-25 13:15:22');
