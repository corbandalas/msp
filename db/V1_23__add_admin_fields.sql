alter table account add COLUMN admin boolean DEFAULT false;
alter table card add COLUMN account_id character varying(255);
alter table customer add COLUMN account_id character varying(255);
