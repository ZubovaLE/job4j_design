select i.name as Item_name, s.name as Item_state, c.name as Item_category, 
u.name as User_name, r.name as User_role
from items as i
join states as s
on i.state_id = s.id
join categories as c
on i.category_id = c.id
join users as u
on i.user_id = u.id
join roles as r
on u.role_id = r.id
order by u.name asc;