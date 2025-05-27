
SELECT E.title
FROM Events E
JOIN Registrations R ON E.event_id = R.event_id
JOIN Users U ON R.user_id = U.user_id
WHERE E.status = 'upcoming'
AND U.city = E.city
ORDER BY E.start_date;

