SELECT
    E.*
FROM iac_sch_event_participant P
INNER JOIN iac_sch_event E
ON P.event_cd = E.event_cd
WHERE user_cd = /*userCd*/
AND E.start_date BETWEEN /*startDate*/ AND /*endDate*/