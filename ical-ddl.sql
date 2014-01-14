-- Table: ical_user_ics_rel

-- DROP TABLE ical_user_ics_rel;

CREATE TABLE ical_user_ics_rel
(
  user_cd character varying(100) NOT NULL,
  ics_name character varying(100) NOT NULL,
  create_user_cd character varying(100) NOT NULL,
  create_date timestamp without time zone NOT NULL,
  record_user_cd character varying(100) NOT NULL,
  record_date timestamp without time zone NOT NULL,
  CONSTRAINT ical_user_ics_rel_pkey PRIMARY KEY (user_cd),
  CONSTRAINT ical_user_ics_rel_ics_name_key UNIQUE (ics_name)
);

-- Table: ical_update_queue

-- DROP TABLE ical_update_queue;

CREATE TABLE ical_update_queue
(
  user_cd character varying(100) NOT NULL,
  last_update_time timestamp without time zone NOT NULL,
  create_user_cd character varying(100) NOT NULL,
  create_date timestamp without time zone NOT NULL,
  record_user_cd character varying(100) NOT NULL,
  record_date timestamp without time zone NOT NULL,
  CONSTRAINT ical_update_queue_pkey PRIMARY KEY (user_cd)
);

-- Function: update_schedule_queue()

-- DROP FUNCTION update_schedule_queue();

CREATE OR REPLACE FUNCTION update_schedule_queue()
  RETURNS trigger AS
$BODY$ declare
    queue_user_cd varchar;
    queue_timestmap timestamp := current_timestamp;
begin
    if (TG_OP = 'INSERT') then
        queue_user_cd = NEW.user_cd;
    elsif (TG_OP = 'UPDATE') then
        queue_user_cd = OLD.user_cd;
    elsif (TG_OP = 'DELETE') then
        queue_user_cd = OLD.user_cd;
    end if;
    loop
        update ical_update_queue set (
                user_cd,
                last_update_time,
                record_user_cd,
                record_date
            ) = (
                queue_user_cd,
                queue_timestmap,
                queue_user_cd,
                queue_timestmap
            ) where user_cd = queue_user_cd;
        if found then
            exit;
        end if;
        begin
            insert into ical_update_queue (
                user_cd,
                last_update_time,
                create_user_cd,
                create_date,
                record_user_cd,
                record_date
            ) values  (
                queue_user_cd,
                queue_timestmap,
                queue_user_cd,
                queue_timestmap,
                queue_user_cd,
                queue_timestmap
            );
        exception when unique_violation then
        end;
    end loop;
return NULL;
end;
$BODY$
LANGUAGE plpgsql VOLATILE;

-- Trigger: update_sch on iac_sch_participant

-- DROP TRIGGER update_sch ON iac_sch_participant;

CREATE TRIGGER update_sch
  AFTER INSERT OR UPDATE OR DELETE
  ON iac_sch_participant
  FOR EACH ROW
  EXECUTE PROCEDURE update_schedule_queue();
  
-- Trigger: update_sch_event on iac_sch_event_participant

-- DROP TRIGGER update_sch_event ON iac_sch_event_participant;

CREATE TRIGGER update_sch_event
  AFTER INSERT OR UPDATE OR DELETE
  ON iac_sch_event_participant
  FOR EACH ROW
  EXECUTE PROCEDURE update_schedule_queue();
