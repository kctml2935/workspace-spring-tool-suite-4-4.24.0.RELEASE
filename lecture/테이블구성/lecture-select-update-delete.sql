select * from lecture;

select * from lecture where l_no=1;

select * from lecture_category;

select * from lecture where C_no=2;
--aaa 멤버의 카트에 제품번호 존재여부 (a의 카트에는 1,4,11존재 = 결과1나와야함)
select count(*) from cart where user_id='aaa' and l_no=4;

--aaa 멤버한사람의 카트아이템리스트
select c.*,l.* from cart c join lecture l
on c.l_no=l.l_no
where c.user_id='aaa';

--aaa님 카트아이템전체삭제
delete from cart where user_id='aaa';

--aaa 멤버한사람의 주문목록
select * from orders where user_id='aaa';

select * from orders o join order_item oi on o.order_no=oi.order_no join lecture l on oi.l_no=l.l_no where o.order_no=1;

select * from orders o  
join order_item oi  
on o.order_no=oi.order_no 
join lecture l
on oi.l_no=l.l_no
where o.user_id='aaa';