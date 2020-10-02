alter table account add COLUMN admin boolean DEFAULT false;
alter table card add COLUMN account_id character varying(255);
alter table customer add COLUMN account_id character varying(255);
alter table transaction add COLUMN create_date timestamp with time zone DEFAULT now();
alter table transaction add COLUMN order_id character varying(255);