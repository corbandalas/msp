CREATE TABLE fee (
    id bigint NOT NULL,
    start_amount_range bigint NOT NULL,
    end_amount_range bigint NOT NULL,
    currency_id character varying(255) NOT NULL,
    account_id integer NOT NULL,
    operation_type character varying(255) NOT NULL
);


CREATE SEQUENCE fee_seq
INCREMENT 1
MINVALUE 1
MAXVALUE 9223372036854775807
START 1
CACHE 1;


ALTER TABLE fee_seq
OWNER TO msp_db;

ALTER TABLE ONLY fee
    ADD CONSTRAINT fee_pkey PRIMARY KEY (id);

ALTER TABLE fee
  ADD CONSTRAINT fee_account FOREIGN KEY (account_id)
      REFERENCES account (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION;

ALTER TABLE fee
  ADD CONSTRAINT fee_currency FOREIGN KEY (currency_id)
      REFERENCES currency (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION;

ALTER TABLE fee OWNER TO msp_db;

CREATE TABLE fee_interval (
    id bigint NOT NULL,
    fee_id bigint NOT NULL,
    fee_interval_type character varying(255) NOT NULL,
    amount bigint,
    percent bigint,
    account_id integer NOT NULL
);

ALTER TABLE ONLY fee_interval
    ADD CONSTRAINT fee_interval_pkey PRIMARY KEY (id);

ALTER TABLE fee_interval
  ADD CONSTRAINT fee_account FOREIGN KEY (account_id)
      REFERENCES account (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION;

ALTER TABLE fee_interval
  ADD CONSTRAINT fee_id FOREIGN KEY (fee_id)
      REFERENCES fee (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION;


CREATE SEQUENCE fee_interval_seq
INCREMENT 1
MINVALUE 1
MAXVALUE 9223372036854775807
START 1
CACHE 1;


ALTER TABLE fee_interval_seq
OWNER TO msp_db;


ALTER TABLE fee_interval OWNER TO msp_db;