-- 테이블 생성용 --
create table member (
                       member_id bigint unsigned auto_increment primary key,
                       uuid_id binary(16) not null unique,
                       title varchar(20) not null,
                       d_day datetime not null,
                       created_at datetime not null default CURRENT_TIMESTAMP
);

create table gift (
                      gift_id bigint unsigned auto_increment primary key,
                      member_id bigint unsigned not null,
                      gto varchar(45) not null,
                      message varchar(2000) not null,
                      gfrom varchar(45) not null,
                      box char(1) not null,
                      ribbon int(1) not null,
                      checked tinyint(1) default 0 not null,
                      foreign key(member_id) references member(member_id) on delete restrict
);
