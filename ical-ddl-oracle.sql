-- Table: ical_user_ics_rel

--  DROP TABLE ical_user_ics_rel;

CREATE TABLE ical_user_ics_rel
(
  user_cd varchar2(100) NOT NULL,
  ics_name varchar2(200) NOT NULL,
  create_user_cd varchar2(100) NOT NULL,
  create_date timestamp NOT NULL,
  record_user_cd varchar2(100) NOT NULL,
  record_date timestamp NOT NULL,
  CONSTRAINT ical_user_ics_rel_pkey PRIMARY KEY (user_cd),
  CONSTRAINT ical_user_ics_rel_ics_name_key UNIQUE (ics_name)
);

-- Table: ical_update_queue

-- DROP TABLE ical_update_queue;

CREATE TABLE ical_update_queue
(
  user_cd varchar2(100) NOT NULL,
  last_update_time timestamp NOT NULL,
  create_user_cd varchar2(100) NOT NULL,
  create_date timestamp NOT NULL,
  record_user_cd varchar2(100) NOT NULL,
  record_date timestamp NOT NULL,
  CONSTRAINT ical_update_queue_pkey PRIMARY KEY (user_cd)
);


-- Trigger: update_sch on iac_sch_participant

-- DROP TRIGGER update_sch ON iac_sch_participant;

CREATE OR REPLACE TRIGGER update_sch
  AFTER INSERT OR UPDATE OR DELETE
  ON iac_sch_participant
  FOR EACH ROW

DECLARE
  q_user_cd varchar2(100);
  now timestamp := current_timestamp;

BEGIN
  IF (INSERTING) THEN
    q_user_cd := :NEW.user_cd;
  ELSE
    q_user_cd := :OLD.user_cd;
  END IF;

  MERGE INTO ical_update_queue up_q
  USING DUAL ON (up_q.user_cd = q_user_cd)
  WHEN MATCHED THEN
    UPDATE SET 
      up_q.last_update_time = now,
      up_q.record_user_cd = q_user_cd,
      up_q.record_date = now
  WHEN NOT MATCHED THEN
    INSERT (
      user_cd,
      last_update_time,
      create_user_cd,
      create_date,
      record_user_cd,
      record_date
    )
    VALUES (
      q_user_cd,
      now,
      q_user_cd,
      now,
      q_user_cd,
      now
    )
  ;
END;
/

-- Trigger: update_sch_event on iac_sch_event_participant

-- DROP TRIGGER update_sch_event ON iac_sch_event_participant;

CREATE OR REPLACE TRIGGER update_sch_event
  AFTER INSERT OR UPDATE OR DELETE
  ON iac_sch_event_participant
  FOR EACH ROW

DECLARE
  q_user_cd varchar2(100);
  now timestamp := current_timestamp;

BEGIN
  IF (INSERTING) THEN
    q_user_cd := :NEW.user_cd;
  ELSE
    q_user_cd := :OLD.user_cd;
  END IF;

  MERGE INTO ical_update_queue up_q
  USING DUAL ON (up_q.user_cd = q_user_cd)
  WHEN MATCHED THEN
    UPDATE SET 
      up_q.last_update_time = now,
      up_q.record_user_cd = q_user_cd,
      up_q.record_date = now
  WHEN NOT MATCHED THEN
    INSERT (
      user_cd,
      last_update_time,
      create_user_cd,
      create_date,
      record_user_cd,
      record_date
    )
    VALUES (
      q_user_cd,
      now,
      q_user_cd,
      now,
      q_user_cd,
      now
    )
  ;
END;
/
