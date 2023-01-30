type InvoiceStatus = 'DRAFT' | 'OPEN' | 'PAID' | 'CANCELLED';

type Invoice = {
	status: InvoiceStatus;
	dueDate: string;
	invoiceNumber: number;
	customer: Customer;
	creationDate?: string;
	priceNet: number;
	priceGross: number;
	id?: number;
	quantity: number;
};

type Customer = {
	givenname: string,
	surname: string,
	id?: number
}

export type {Invoice, Customer, InvoiceStatus}