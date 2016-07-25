SELECT I.*
FROM ical_user_ics_rel I
INNER JOIN ical_update_queue Q
ON I.user_cd = Q.user_cd
WHERE Q.last_update_time > /*lastUpdateTime*/