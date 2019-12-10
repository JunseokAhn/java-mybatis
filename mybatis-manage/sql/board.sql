
--게시판 글정보 테이블
create table board (
	boardnum 	number 			primary key,	--게시글 일련번호
	name 		varchar2(20) 	not null,  		--작성자 이름
	title 		varchar2(200) 	not null, 		--글제목
	content 	varchar2(2000) 	not null,  		--글내용
	hits 		number default 0, 				--조회수
	indate 		date default sysdate 			--작성일
);

--게시판 글 일련번호에 사용할 시퀀스 생성
create sequence boardseq;

--게시판 글 저장 예
insert into board (boardnum, name, title, content)
values (boardseq.nextval, '홍길동', '글제목', '글내용입니다.');


--리플 정보 테이블
create table reply (
	replynum	number	primary key,   		--리플 일련번호
	boardnum	number  not null, 			--본문글번호
	name		varchar2(20) not null, 		--리플 작성자 이름
	retext		varchar2(1000) not null,  	--리플내용
	constraint reply_fk foreign key(boardnum) 
	references board(boardnum) on delete cascade
);

--리플 테이블 일련번호에 사용할 시퀀스 생성
create sequence replyseq;

--리플 저장 예
insert into reply values (replyseq.nextval, 1, '김철수', '리플내용');



