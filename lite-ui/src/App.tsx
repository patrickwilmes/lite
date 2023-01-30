import { createBrowserRouter, RouterProvider } from 'react-router-dom';
import './App.css'
import Shell from './components/shell/Shell'
import routes from './routes/routes';

function App() {

  
  const router = createBrowserRouter(routes);

  return (
    <div className="App">
      <RouterProvider router={router} />
    </div>
  )
}

export default App
