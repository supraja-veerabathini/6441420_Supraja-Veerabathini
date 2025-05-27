-- 22. Duplicate Registrations Check
SELECT U.full_name, E.title, COUNT(*)
FROM Users U
JOIN Registrations R ON U.user_id = R.user_id
JOIN Events E ON R.event_id = E.event_id
GROUP BY U.user_id, E.event_id
HAVING COUNT(*) > 1;