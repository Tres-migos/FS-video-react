import { BrowserRouter as Router, Switch, Route } from 'react-router-dom'
import { Grid } from 'semantic-ui-react'
import React, {useState} from 'react'
import HeaderBar from './components/HeaderBar'
import SideNav from './components/SideNav'
import Home from './Pages/Home'
import VideoGames from './Pages/VideoGames'
import Music from './Pages/Music'
import Upload from './Pages/Uploads'
import './App.css';
import Login from './Pages/Login'
import Register from './Pages/Register'
import HeaderBarAuth from './components/HeaderBarAuth'
import {AppContext} from './lib/contextLib'


const routes = [
  {
    path: "/",
    exact: true,
    main: () => <Home />
  },
  {
    path: "/my-uploads",
    main: () => <Upload />
  },
  {
    path: "/video-games",
    main: () => <VideoGames />
  },
  {
    path: "/music",
    main: () => <Music />
  },
  {
    path: "/login",
    main: () => <Login />
  },
  {
    path: "/register",
    main: () => <Register />
  }
];

function App() {
  const [isAuthenticated, userHasAuthenticated] = useState(false);

  return (
    <AppContext.Provider value={{ isAuthenticated, userHasAuthenticated }}>
      <Router>
        <div className="App">
          {isAuthenticated ? <HeaderBarAuth /> : <HeaderBar />}
          <Grid padded>
            <Grid.Row columns={2}>
              <Grid.Column floated='left' width={3}>
                <SideNav />
              </Grid.Column>
              <Grid.Column width={12}>
                <Switch>
                  {routes.map((route, index) => (
                    <Route
                      key={index}
                      path={route.path}
                      exact={route.exact}
                      children={<route.main />}
                    />
                  ))}
                </Switch>
              </Grid.Column>
            </Grid.Row>
          </Grid>
        </div>
      </Router>
    </AppContext.Provider>

  );
}

export default App;
