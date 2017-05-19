alter table fee_interval add COLUMN fee_destination_type character varying(255);

update fee_interval set fee_destination_type = 'THIRD_PARTY';