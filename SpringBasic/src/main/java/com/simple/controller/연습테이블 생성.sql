create table score(
    num NUMBER(10,0),
    name varchar2(50),
    kor varchar2(50),
    eng varchar2(50),
    math varchar2(50)    
);
alter table score add constraint score_pk PRIMARY KEY (num);
create SEQUENCE score_seq INCREMENT by 1 START with 1;


