-- 17. Multi-Session Speakers
SELECT speaker_name
FROM Sessions
GROUP BY speaker_name
HAVING COUNT(*) > 1;