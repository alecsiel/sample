# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table article (
  id                        bigint not null,
  name                      varchar(255),
  contents                  varchar(255),
  create_date               timestamp,
  constraint pk_article primary key (id))
;

create sequence article_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists article;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists article_seq;

