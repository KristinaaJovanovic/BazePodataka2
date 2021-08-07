drop table if exists Glumi;
drop table if exists Glumac;
drop table if exists Fiilm;


/*==============================================================*/
/* Table: Glumac                                                */
/*==============================================================*/
create table Glumac
(
   idg		             int not null auto_increment,
   ime               	 varchar(30) not null,
   prezime               varchar(50) not null,
   godinaRodjenja        int not null,
   primary key (idg)
);
/*==============================================================*/
/* Table: Film                                                  */
/*==============================================================*/
create table Fiilm
(
   sifra	           int not null auto_increment,
   naziv               varchar(30) not null,
   godina              int not null,
   zanr				   varchar(50) not null,
   primary key (sifra)
);
/*==============================================================*/
/* Table: Glumi                                                 */
/*==============================================================*/
create table Glumi
(
   idg		             int not null,
   sifra	           	 int not null,
   primary key (idg, sifra)
);

alter table Glumi add constraint FK_glumi foreign key (idg)
      references Glumac (idg) on delete restrict on update restrict;
alter table Glumi add constraint FK_glumi2 foreign key (sifra)
      references Fiilm (sifra) on delete restrict on update restrict;

insert into Glumac values (1, 'Bruce', 'Willis', 1955);
insert into Glumac values (2, 'Jim', 'Carrey', 1962);
insert into Glumac values (3, 'Mark', 'Hamil', 1951);
insert into Glumac values (4, 'Michael', 'Biehn', 1956);
insert into Glumac values (5, 'Leonardo', 'DiCaprion', 1974);

insert into Fiilm values (1, 'The Truman Show', 1998, 'komedija');
insert into Fiilm values (2, 'Star Wars', 1977, 'naucna fantastika');
insert into Fiilm values (3, 'The Terminator', 1984 ,'akcija');
insert into Fiilm values (4, 'Die Hard', 1988 ,'akcija');
insert into Fiilm values (5, 'Inception', 2010, 'avanturisticki');

insert into Glumi values (1, 4);
insert into Glumi values (2, 1);
insert into Glumi values (3, 2);
insert into Glumi values (4, 3);
insert into Glumi values (5, 5);