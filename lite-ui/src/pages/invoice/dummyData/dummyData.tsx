import { Invoice } from "../Invoice.model";

const invoices: Invoice[] = [
    {
        id: 1,
        status: "DRAFT",
        dueDate: '2023-01-20',
        invoiceNumber: 1,
        customer: {
            givenname: 'Blake',
            surname: 'Mills'
        },
        creationDate: '2023-01-20',
        priceNet: 10,
        priceGross: 11.9
    },
    {
        id: 2,
        status: "OPEN",
        dueDate: '2023-01-20',
        invoiceNumber: 2,
        customer: {
            givenname: 'Thom',
            surname: 'Yorke'
        },
        creationDate: '2023-01-20',
        priceNet: 10,
        priceGross: 11.9
    },
    {
        id: 3,
        status: 'PAID',
        dueDate: '2023-01-20',
        invoiceNumber: 3,
        customer: {
            givenname: 'Hania',
            surname: 'Rani'
        },
        creationDate: '2023-01-20',
        priceNet: 10,
        priceGross: 11.9,
    },
    {
        id: 4,
        status: "CANCELLED",
        dueDate: '2023-01-20',
        invoiceNumber: 4,
        customer: {
            givenname: 'Natalia',
            surname: 'Lafourcade'
        },
        creationDate: '2023-01-20',
        priceNet: 10,
        priceGross: 11.9,
    },
];

export {invoices}