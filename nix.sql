-- SEQUENCE: public.seq_transferencia

-- DROP SEQUENCE public.seq_transferencia;

CREATE SEQUENCE public.seq_transferencia;

ALTER SEQUENCE public.seq_transferencia
    OWNER TO postgres;


-- Table: public.transferencia

-- DROP TABLE public.transferencia;

CREATE TABLE public.transferencia
(
    id bigint NOT NULL,
    pagador_nome character varying(128) COLLATE pg_catalog."default" NOT NULL,
    pagador_banco character varying(3) COLLATE pg_catalog."default" NOT NULL,
    pagador_agencia character varying(4) COLLATE pg_catalog."default" NOT NULL,
    pagador_conta character varying(6) COLLATE pg_catalog."default" NOT NULL,
    beneficiario_nome character varying(128) COLLATE pg_catalog."default" NOT NULL,
    beneficiario_banco character varying(3) COLLATE pg_catalog."default" NOT NULL,
    beneficiario_agencia character varying(4) COLLATE pg_catalog."default" NOT NULL,
    beneficiario_conta character varying(6) COLLATE pg_catalog."default" NOT NULL,
    valor numeric(15,2) NOT NULL,
    tipo character varying(4) COLLATE pg_catalog."default" NOT NULL,
    status character varying(12) COLLATE pg_catalog."default" NOT NULL,
    data_criacao timestamp without time zone NOT NULL,
    is_excluido boolean NOT NULL,
    CONSTRAINT transferencia_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.transferencia
    OWNER to postgres;