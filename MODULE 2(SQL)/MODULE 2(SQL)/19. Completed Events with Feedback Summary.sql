-- 19. Completed Events with Feedback Summary
SELECT E.title, COUNT(R.user_id), AVG(F.rating)
FROM Events E
JOIN Registrations R ON E.event_id = R.event_id
JOIN Feedback F ON E.event_id = F.event_id
WHERE E.status = 'completed'
GROUP BY E.title;