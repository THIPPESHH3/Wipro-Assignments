show tables;

select * from orders;
desc orders;
select * from products;

alter table customers add (city varchar(29) default "bengaluru");
update customers set city="pune" where customer_id in (1,5);
update customers set city="manglore" where customer_id in (2,4);
select * from customers;
select customer_name,customer_email from customers where city="bengaluru";

select * from customers c inner join orders o on c.customer_id = o.customer_id where city="bengaluru";

select distinct c.customer_name from customers c left outer join orders o on c.customer_id = o.customer_id ;

select avg(o.quantity*p.product_price) as average_order_value from orders o join products p where o.product_id =p.product_id;

select *,(o.quantity*p.product_price)as Total_order_value from customers c
 join orders o on c.customer_id=o.customer_id 
join products p on p.product_id=o.product_id 
where (o.quantity*p.product_price) > 
(select avg(o.quantity*p.product_price) as average_order_value from orders o 
join products p where o.product_id =p.product_id)
union
select *,(o.quantity*p.product_price)as Total_order_value from customers c
 join orders o on c.customer_id=o.customer_id 
join products p on p.product_id=o.product_id 
where (o.quantity*p.product_price) > 
(select avg(o.quantity*p.product_price) as average_order_value from orders o 
join products p where o.product_id =p.product_id);

start transaction;
insert into orders values(8,3,103,5,date('2024-11-5'));

commit;
SET SQL_SAFE_UPDATES=0;
start transaction;
update products set product_price=0;
select * from products;

rollback;


start transaction;
insert into orders values(9,1,102,7,date('2024-1-9'));
savepoint A;
insert into orders values(10,1,101,6,date('2024-4-13'));
savepoint B;
insert into orders values(11,3,103,9,date('2024-8-11'));
savepoint C;
insert into orders values(12,2,101,2,date('2024-12-30'));
savepoint D;
rollback to C;
select * from orders;

commit;











