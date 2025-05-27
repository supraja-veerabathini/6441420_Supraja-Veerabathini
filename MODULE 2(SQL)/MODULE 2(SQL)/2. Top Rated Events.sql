-- 2. Top Rated Events
SELECT E.title, AVG(F.rating) as avg_rating
FROM Events E
JOIN Feedback F ON E.event_id = F.event_id
GROUP BY E.title
HAVING COUNT(F.feedback_id) >= 10
ORDER BY avg_rating DESC;