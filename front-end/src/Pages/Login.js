import React, { useState } from "react";
import { useHistory } from 'react-router-dom'
import { Button, Form, Header, Grid, Segment } from 'semantic-ui-react'
import axios from 'axios'
import { useAppContext } from "../lib/contextLib";

export default function Login() {
  const { userHasAuthenticated } = useAppContext();
  const history = useHistory()
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");

  const instance = axios.create({
    baseURL: 'http://localhost:8080/account',
    headers: {
      'Content-Type': 'application/x-www-form-urlencoded'
    },
    params: {
      username: username,
      password: password
    }
  });

  function validateForm() {
    return username.length > 0 && password.length > 0;
  }

  const handleSubmit = async (e) => {
    e.preventDefault();
    const account = { username: username, password: password };
    console.log(account)
    try {
      await instance.get("http://localhost:8080/account/login", account)
      userHasAuthenticated(true)
      history.push("/")
    } catch (e) {
      userHasAuthenticated(false)
      alert(e.message)
    }
  }

  return (
    <Grid>
      <Grid.Row centered>
        <Grid.Column style={{ maxWidth: 600, marginTop: 20 }}>
          <Segment raised padded='very'>
            <Header>Sign in</Header>
            <Form>
              <Form.Field>
                <label>Username</label>
                <input
                  value={username}
                  placeholder="Username"
                  onChange={(e) => setUsername(e.target.value)} />
              </Form.Field>
              <Form.Field>
                <label>Password</label>
                <input
                  value={password}
                  type='password'
                  placeholder="Password"
                  onChange={(e) => setPassword(e.target.value)} />
              </Form.Field>
              <Button
                fluid
                primary
                onClick={handleSubmit}
                type='submit'
                disabled={!validateForm()}
              >Login</Button>
            </Form>
          </Segment>
        </Grid.Column>
      </Grid.Row>
    </Grid>
  )
}