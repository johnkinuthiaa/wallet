import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import {Header} from "./components/Header.jsx";
import {Hero} from "./components/Hero";


const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
      <Header/>
      <Hero />
    <App />
  </React.StrictMode>
);

