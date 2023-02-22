-- 테이블 생성용 --
create table member (
                       member_id bigint unsigned auto_increment primary key,
                       uuid_id binary(16) not null unique,
                       title varchar(20) not null,
                       dDay date not null,
                       created_at date not null default current_date
)

create table gift (
                      gift_id bigint unsigned auto_increment primary key,
                      member_id int unsigned not null,
                      g_to varchar(45) not null,
                      message varchar(2000) not null,
                      g_from varchar(45) not null,
                      box char(1) not null,
                      ribbon char(1) not null,
                      checked tinyint(1) default 0 not null,
                      foreign key(member_id) references member(member_id) on delete restrict
)