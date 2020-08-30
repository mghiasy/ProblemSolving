-- Automatically trun string to date
-- using Sum and Having
Select product_name, Sum(unit) as unit 
    from Products p join orders o
    on p.product_id=o.product_id
    where order_date between '2020-02-01' and '2020-02-29'
    group by p.product_id
    having Sum(unit) >= 100;

-- unig WITH to creat temp table for keep data as variable
With tmp_tbl as (
    Select p.product_id, Sum(unit) as unit 
        from Products p join orders o
        on p.product_id=o.product_id
        where order_date between '2020-02-01' and '2020-02-29'
        group by p.product_id
        having Sum(unit) >= 100
)
Select product_name,unit 
    from Products p join tmp_tbl t
    on p.product_id=t.product_id;