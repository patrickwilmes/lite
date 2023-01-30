import { render, screen } from '@testing-library/react';

import {Home} from './Home';
import {BrowserRouter} from "react-router-dom";
import userEvent from "@testing-library/user-event";

describe('App', () => {
    it('renders button', () => {
        render(<BrowserRouter><Home /></BrowserRouter>);
        expect(screen.getByRole('button')).toBeInTheDocument();
    });

});