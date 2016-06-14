alter table transaction rename column card_id to to_card_id;
alter table transaction add column from_card_id integer;
alter table transaction rename column from_exchange_rate to from_account_exchange_rate;
alter table transaction rename column to_exchange_rate to to_account_exchange_rate;
alter table transaction add column from_card_exchange_rate numeric;
alter table transaction add column to_card_exchange_rate numeric;
