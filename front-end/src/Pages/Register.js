import React, {useState} from 'react'
import axios from 'axios'
import { Button, Form, Header, Grid, Segment} from 'semantic-ui-react'
import {useHistory} from 'react-router-dom'
import { useAppContext } from '../lib/contextLib'





export default function Register () {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const {userHasAuthenticated} = useAppContext();
  const history = useHistory()
  

  function validateForm(){
    return username.length > 0 && password.length > 0;
  }


  async function register() {
    const account = { username, password };
    try {
      await axios.post('http://localhost:8080/account/create', account)
      userHasAuthenticated(true)
      history.push("/")
    } catch (e) {
      userHasAuthenticated(false)
      alert(e.message)
    }
  }
  


  return (
    <Grid centered>
      <Grid.Column style={{ maxWidth: 600, marginTop: 20 }}>
        <Segment raised padded='very'>
          <Header>Register</Header>
          <Form >
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
                type='Password'
                placeholder="Password"
                onChange={(e) => setPassword(e.target.value)} />
            </Form.Field>

            <Button
              fluid primary
              onClick={register}
              type='submit'
              disabled={!validateForm()}>Submit</Button>
          </Form>
        </Segment>

      </Grid.Column>

    </Grid>
  );

}
