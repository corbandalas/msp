CREATE SEQUENCE wallet_transaction_seq
INCREMENT 1
MINVALUE 1
MAXVALUE 9223372036854775807
START 10000
CACHE 1;

ALTER TABLE wallet_transaction_seq
OWNER TO msp_db;

CREATE TABLE wallet_transaction (
    id bigint NOT NULL,
    amount_cts bigint NOT NULL,
    currency character varying(255) NOT NULL,
    description character varying(255) NOT NULL,
    date_added bigint NOT NULL,
    type character varying(255) NOT NULL,
    src_token character varying(255) NOT NULL,
    dest_token character varying(255) NOT NULL,
    uuid character varying(255) NOT NULL
);

ALTER TABLE wallet_transaction
OWNER TO msp_db;

ALTER TABLE ONLY wallet_transaction
    ADD CONSTRAINT wallet_transaction_pkey PRIMARY KEY (id);

