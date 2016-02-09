alter table country add COLUMN code character varying(255);
update country set code='208' where id = 'DK';
update country set code='826' where id = 'UK';
update country set code='804' where id = 'UA';
update country set code='752' where id = 'SE';
update country set code='840' where id = 'US';