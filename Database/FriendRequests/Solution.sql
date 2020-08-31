-- use IFNULL , ROUND
Select round( IFNULL(
    (Select Count(distinct requester_id,accepter_id) from request_accepted) / 
    (Select Count(distinct sender_id,send_to_id) from friend_request),0 )
    ,2) as accept_rate;
    
    
    -- Can you write a query to return the accept rate but for every month?
    -- ?
    Select round( IFNULL(
    (Select Count(distinct requester_id,accepter_id) from request_accepted r group by Month(r.accept_date)) / 
    (Select Count(distinct sender_id,send_to_id) from friend_request f group by Month(f.request_date)),0 )
    ,2) as accept_rate;