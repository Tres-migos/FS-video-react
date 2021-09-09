
import { Link } from 'react-router-dom'
import { Grid, Button, Image, Input, Header } from 'semantic-ui-react'
import React, {Component} from 'react'

export default function HeaderBar(){
  


  return (
    <div>
      <Grid columns={3} padded >
        <Grid.Row>
          <Grid.Column floated='left' width={3}>
            <Header as='h2' textAlign='center'>
              <Image src='https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSr0rW1tknKsOH9mpMeuXG1zAONQijhtFGmbQ&usqp=CAU' fluid />
            </Header>
          </Grid.Column>
          <Grid.Column width={7}>
            <Input fluid icon='search' placeholder='Search...' />
          </Grid.Column>

          <Grid.Column floated='right' width={3}>
            <Button.Group>
              <Button 
              inverted color='green'>
              <Link to="/login">Login</Link>
              </Button>
              
              <Button>
                <Link to="/register">Register</Link>
              </Button>
            </Button.Group>
          </Grid.Column>

        </Grid.Row>
      </Grid>
    </div>
  )
}

