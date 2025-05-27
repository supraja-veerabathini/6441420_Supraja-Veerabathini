-- 21. Top Feedback Providers
SELECT U.full_name
FROM Users U
JOIN Feedback F ON U.user_id = F.user_id
GROUP BY U.user_id
ORDER BY COUNT(*) DESC
LIMIT 5;