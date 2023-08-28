import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import reportWebVitals from './reportWebVitals';

// Router
import { BrowserRouter } from 'react-router-dom';
import BlogRouter from './BlogRouter';

// ROOT
const root = ReactDOM.createRoot(document.getElementById('root'));
// RENDER
root.render(
  <React.StrictMode>
    <BrowserRouter>
     <BlogRouter/>
    </BrowserRouter>
  </React.StrictMode>
);

reportWebVitals();
