import { Button, Center, Container } from '@mantine/core';
import clsx from 'clsx';
import { useNavigate } from 'react-router-dom';
import styles from './Home.module.scss';

const Home = (): JSX.Element => {
	const navigate = useNavigate();

	return (
		<div className={clsx(styles['home'])}>
			<Container mt={'md'} className={styles['welcome-message']}>
				<img className={styles.logo} width='500' src='/sevdesk-light-01.svg' alt='' />
					<p>Welcome to sevDesk Lite,
					<br />
					(soon to be) best bookkeeping software in the world
					</p>
				<Button mt={'md'} onClick={() => { navigate('/edit-invoice/') }}>Create invoice</Button>
			</Container>
		</div>
	);
};

export { Home };
