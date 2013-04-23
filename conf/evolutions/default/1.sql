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

create table comment (
  id                        bigint not null,
  name                      varchar(255),
  text                      varchar(255),
  article_id                bigint,
  constraint pk_comment primary key (id))
;

create sequence article_seq;

create sequence comment_seq;

alter table comment add constraint fk_comment_article_1 foreign key (article_id) references article (id) on delete restrict on update restrict;
create index ix_comment_article_1 on comment (article_id);



# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists article;

drop table if exists comment;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists article_seq;

drop sequence if exists comment_seq;

