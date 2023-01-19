-- H2 용 --
create table owner (
                       id int unsigned auto_increment primary key,
                       uuid_id binary(16) not null unique,
                       user_id varchar(45) not null unique,
                       pw varchar(45) not null,
                       room varchar(20) not null,
                       dDay date not null,
                       created_at date not null default current_date
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

create table gift (
                      id int unsigned auto_increment primary key,
                      owner_id int unsigned not null,
                      gift_to varchar(45) not null,
                      gift_message varchar(2000) not null,
                      gift_from varchar(45) not null,
                      box_color char(1) not null,
                      ribbon_color char(1) not null,
                      checked tinyint(1) default 0 not null,
                      foreign key(owner_id) references owner(id) on delete restrict
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;