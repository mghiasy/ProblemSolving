
select  year(date) as y,
case  
		when Month(date) between 1 and 3 then 1
        when Month(date) between 4 and 6 then 2
        when Month(date) between 7 and 9 then 3
        when Month(date) between 10 and 12 then 4
	end as quarter,
    profit - lose as net_profit
 from Leetcode.accounting 
 
order by y,quarter
