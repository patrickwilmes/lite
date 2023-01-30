import { Table } from '@mantine/core';
import clsx from 'clsx';
import styles from './Invoices.module.scss';
import {useEffect, useState} from "react";
import {Invoice} from "../Invoice.model";
import {fetchAllInvoices} from "../InvoiceApi";
import {useNavigate} from "react-router-dom";


const Invoices = (): JSX.Element => {
	const [invoices, setInvoices] = useState<Invoice[]>([]);
	const navigate = useNavigate();

	useEffect(() => {
		fetchAllInvoices().then(invoices => {
			setInvoices(invoices);
		});
	}, []);

	const rows = invoices.map((invoice) =>
		<tr className={styles['invoice-table-row']} key={invoice.id} onClick={() => { navigate(`/edit-invoice/${invoice.id}`); }}>
			<td>{invoice.status}</td>
			<td>{new Date(invoice.dueDate).toLocaleDateString('en-GB')}</td>
			<td>{invoice.invoiceNumber}</td>
			<td>{`${invoice.customer.givenname} ${invoice.customer.surname}`}</td>
			<td>{invoice.creationDate ? new Date(invoice.creationDate).toLocaleDateString('en-GB') : '-'}</td>
			<td>{invoice.priceNet}</td>
			<td>{invoice.priceGross}</td>
		</tr>
	);

	return (
		<div className={clsx(styles['invoices'])}>
			<Table highlightOnHover>
				<thead>
					<tr>
						<th>Status</th>
						<th>Due date</th>
						<th>Number</th>
						<th>Customer</th>
						<th>Create date</th>
						<th>Net price</th>
						<th>Gross price</th>
					</tr>
				</thead>
				<tbody>{rows}</tbody>
			</Table>
		</div>
	);
};

export { Invoices };
