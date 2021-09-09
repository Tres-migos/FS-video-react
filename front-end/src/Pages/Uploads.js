import React from 'react'
import { Grid, Container, Header, Divider, Image } from 'semantic-ui-react'
import NoUploadsSegment from '../components/NoUploadsSegment'


const Uploads = () => (
  <Grid>
    <Grid.Row>
      <Grid.Column fluid >
        <Container textAlign='justified'>
          <Header as='h3'>
            My Uploads
          </Header>
          <Divider />
          

          <NoUploadsSegment />
        </Container>
      </Grid.Column>
    </Grid.Row>
  </Grid>
)

export default Uploads