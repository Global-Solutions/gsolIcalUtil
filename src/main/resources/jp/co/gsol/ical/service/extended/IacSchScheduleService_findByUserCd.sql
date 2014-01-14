SELECT
    S.*
FROM iac_sch_participant P
INNER JOIN iac_sch_schedule S
ON P.schedule_cd = S.schedule_cd
WHERE user_cd = /*userCd*/
AND S.start_date BETWEEN /*startDate*/ AND /*endDate*/