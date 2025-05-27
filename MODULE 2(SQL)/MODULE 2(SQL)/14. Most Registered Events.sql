-- 14. Most Registered Events
SELECT E.title
FROM Events E
JOIN Registrations R ON E.event_id = R.event_id
GROUP BY E.title
ORDER BY COUNT(R.user_id) DESC
LIMIT 3;