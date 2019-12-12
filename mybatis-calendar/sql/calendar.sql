
--일정 테이블
create table calendar (
	calendar_no 				number 					primary key				-- 일정 번호 (PK)
	,calendar_name 			varchar2(20)		 	not null	  					-- 작성자
	,calendar_title 				varchar2(200)		 	not null			 			-- 일정 제목	
	,calendar_content 		varchar2(2000) 		not null			  			-- 일정 내용
	,calendar_indate 			date 						default sysdate 			-- 일정 등록일
);

--일정 시퀀스
create sequence calendar_seq;

--일정 등록
insert into 
	calendar (
		calendar_no
		,calendar_name
		,calendar_title
		,calendar_content
	) values (
		calendar_seq.nextval
		,'이종호'
		,'일정 등록 테스트'
		,'등록 되었습니다.'
	);

commit;