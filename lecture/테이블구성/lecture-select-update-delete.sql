select * from lecture;

select * from lecture where l_no=1;

--aaa 멤버의 카트에 제품번호 존재여부 (a의 카트에는 1,4,11존재 = 결과1나와야함)
select count(*) from cart where userid='aaa' and l_no=4;

select c.*,l.* from cart c join lecture l
on c.l_no=l.l_no
where c.userid='aaa';

delete from cart where userid='aaa';

select * from orders where userid='aaa';

select * from orders o join order_item oi on o.o_no=oi.o_no join lecture l on oi.l_no=l.l_no where o.o_no=1;

select * from orders o  
join order_item oi  
on o.o_no=oi.o_no 
join lecture l
on oi.l_no=l.l_no
where o.userid='aaa';