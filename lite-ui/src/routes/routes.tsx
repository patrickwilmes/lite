import { Home } from '../pages/home/Home';
import { RouteObject } from 'react-router-dom';
import Shell from '../components/shell/Shell'
import { Invoices } from '../pages/invoice/invoices/Invoices';
import { TopSecret } from '../pages/top-secret/TopSecret';
import {EditInvoice} from "../pages/invoice/edit-invoice/EditInvoice";

const routes: RouteObject[] = [
	{
		path: '/',
		id: 'APP',
		element: <Shell />,
		children: [
			{
				id: 'DASH',
				element: <Home />,
				index: true,
			},
			{
				id: 'INVOICES',
				element: <Invoices />,
				path: 'invoices'
			},
			{
				id: 'EDIT_EXISTING_INVOICE',
				element: <EditInvoice />,
				path: 'edit-invoice/:invoiceId'
			},
			{
				id: 'EDIT_INVOICE',
				element: <EditInvoice />,
				path: 'edit-invoice'
			},
			{
				id: 'TOPSECRET',
				element: <TopSecret />,
				path: 'top-secret'
			}
		],
	}
];

export default routes;
