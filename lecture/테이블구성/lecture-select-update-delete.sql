select * from lecture;

select * from lecture where l_no=1;

select * from lecture_category;

--카테고리의 강의
select * from lecture where C_no=2;

--aaa 멤버한사람의 강의목록
select * from orders where user_id='aaa';
select * from orders where order_no=1;
select * from orders;
select * from order_item where order_no=1;
select * from order_item WHERE order_no = 6;
delete from order_item where order_no=2;

select * from orders o join order_item oi on o.order_no=oi.order_no join lecture l on oi.l_no=l.l_no where o.order_no=2;

select * from orders o  
join order_item oi  
on o.order_no=oi.order_no 
join lecture l
on oi.l_no=l.l_no
where o.user_id='aaa';

--aaa가 수강할수있는 강의목록(강의 이름,강의 설명,강의 이미지)
select l.l_name,l.l_desc,l.l_image from orders o  
join order_item oi  
on o.order_no=oi.order_no 
join lecture l
on oi.l_no=l.l_no
where o.user_id='aaa';