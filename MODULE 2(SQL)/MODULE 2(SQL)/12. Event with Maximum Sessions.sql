-- 12. Event with Maximum Sessions
SELECT E.title
FROM Events E
JOIN Sessions S ON E.event_id = S.event_id
GROUP BY E.title
ORDER BY COUNT(S.session_id) DESC
LIMIT 1;