import React from 'react';
import { createRoot } from 'react-dom/client';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import { Link } from 'react-router-dom';
import DragonPage from './Dragon';
import KingdomPage from './Kingdom';
import PersonPage from './Person';
import WhiteWalkerPage from './WhiteWalker';
import './index.css';
import Poem from './Poem';

const container = document.getElementById('root');
const root = createRoot(container);

root.render(
  <Router>
    <div>
      <nav>
        <ul>
          <li>
            <Link to='/dragon'>Dragon</Link>
          </li>
          <li>
            <Link to='/kingdom'>Kingdom</Link>
          </li>
          <li>
            <Link to='/person'>Person</Link>
          </li>
          <li>
            <Link to='/whitewalker'>White Walker</Link>
          </li>
          <li>
            <Link to='/poem'>Poem</Link>
          </li>
        </ul>
      </nav>
      <Switch>
        <Route path='/dragon' component={DragonPage} />
        <Route path='/kingdom' component={KingdomPage} />
        <Route path='/person' component={PersonPage} />
        <Route path='/whitewalker' component={WhiteWalkerPage} />
        <Route path='/poem' component={Poem} />
        <Route path='/' component={DragonPage} />
      </Switch>
    </div>
  </Router>
);
