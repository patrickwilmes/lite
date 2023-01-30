import clsx from 'clsx';
import styles from './TopSecret.module.scss';


const TopSecret = (): JSX.Element => {
	return <div className={clsx(styles['top-secret'])}>
		<h1>The answer is 42</h1>
	</div>;
};

export { TopSecret };
