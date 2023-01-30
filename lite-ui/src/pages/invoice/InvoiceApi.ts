import {Invoice} from "./Invoice.model";
import axiosClient from "../../dataFetching/axiosClient";

async function fetchInvoice(invoiceId: number): Promise<Invoice | undefined> {
    return (await axiosClient.get(`/invoices/${invoiceId}`)).data;
}

async function fetchAllInvoices(): Promise<Invoice[]> {
    return (await axiosClient.get('/invoices')).data;
}

async function createInvoice(invoice: Invoice): Promise<Invoice> {
    return (await axiosClient.post('/invoices', invoice)).data;
}


export { fetchInvoice, fetchAllInvoices, createInvoice }