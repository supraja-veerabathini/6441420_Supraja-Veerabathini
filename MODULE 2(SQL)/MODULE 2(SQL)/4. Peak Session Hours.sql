-- 4. Peak Session Hours
SELECT E.title, COUNT(S.session_id)
FROM Events E
JOIN Sessions S ON E.event_id = S.event_id
WHERE HOUR(S.start_time) >= 10 AND HOUR(S.start_time) < 12
GROUP BY E.title;