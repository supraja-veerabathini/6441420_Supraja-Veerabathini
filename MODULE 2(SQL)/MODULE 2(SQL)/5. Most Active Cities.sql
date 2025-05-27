-- 5. Most Active Cities
SELECT city, COUNT(DISTINCT U.user_id) as num_registrations
FROM Registrations R
JOIN Users U ON R.user_id = U.user_id
GROUP BY city
ORDER BY num_registrations DESC
LIMIT 5;