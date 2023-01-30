-- liquibase formatted sql

-- changeset sevdesk:1667831598

alter table INVOICES
    alter column ID BIGINT auto_increment;

alter table INVOICES
    alter column INVOICE_NUMBER rename to status;

alter table INVOICES
    alter column status set null;

alter table INVOICES
    alter column RECIPIENT rename to CUSTOMER_ID;

alter table INVOICES
    alter column CUSTOMER_ID set null;

alter table INVOICES
    alter column INVOICE_DATE rename to creation_date;

alter table INVOICES
    alter column creation_date DATETIME not null;

alter table INVOICES
    alter column PAY_DATE rename to due_date;

alter table INVOICES
    add invoice_number VARCHAR2(50) not null;

alter table INVOICES
    add quantity double default 0 not null;

alter table INVOICES
    add price_net double default 0 not null;

alter table INVOICES
    add price_gross double default 0 not null;

create table CUSTOMERS
(
    ID        INTEGER auto_increment,
    GIVENNAME CHARACTER VARYING(255),
    SURNAME   CHARACTER VARYING(255) not null
);




-- rollback drop table CUSTOMERS;