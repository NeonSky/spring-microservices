import React from 'react';
import {
    BrowserRouter as Router,
    Switch,
    Route,
} from "react-router-dom";

import Home from './pages/Home';
import Login from './pages/Login';
import User from './pages/User';
import './App.css';

export default function App() {
  return (
      <div>
          <Router>
              <Switch>
                  <Route path="/login"><Login/></Route>
                  <Route path="/user"><User/></Route>
                  <Route path="/"><Home/></Route>
              </Switch>
          </Router>
      </div>
  );
}
