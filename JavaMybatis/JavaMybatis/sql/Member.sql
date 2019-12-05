-- Java-Mybaits Project의 회원 테이블 삭제
drop table mybatis_member;

-- Java-Mybatis Project의 회원 테이블 생성
create table mybatis_member (
	member_no					number 				primary key					-- 회원 번호 (PK)
	,member_name			varchar2(20)		not null							--	회원 이름
	,member_age				number				not null							-- 회원 나이
	,member_phone			varchar2(20)												-- 회원 전화번호
	,member_address		varchar2(200)												--	회원 주소
	,member_indate			date						default sysdate				--	회원 등록일
);

-- Java-Mybatis Project의 회원 번호 시퀀스 삭제
drop sequence member_seq;

-- Java-Mybatis Project의 회원 번호 시퀀스 생성
create sequence member_seq;

-- Java-Mybatis Project의 회원 정보 등록
insert into
	mybatis_member (
		member_no
		,member_name
		,member_age
		,member_phone
		,member_address
	) values ( 
		member_seq.nextval
		,'홍길동'
		,20
		,'010-1234-5678'
		,'코엑스 4층 ICT 교육센터'
	);

commit;