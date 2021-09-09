import React from 'react'
import { Grid, Container, Header, Divider, Image } from 'semantic-ui-react'
import DisplayMedia from '../components/media/DisplayMedia'
import DisplayMediaGroups from '../components/media/DisplayMediaGroups'

const Home = () => (
  <Grid>
    <Grid.Row>
      <Grid.Column fluid >
        <Container textAlign='justified'>
          <Header as='h3'>
            Trending
          </Header>
          <Divider />

          <DisplayMediaGroups />

        </Container>
      </Grid.Column>
    </Grid.Row>
{/* 
    <Grid.Row>
      <Grid.Column fluid >
        <Container textAlign='justified'>
          <Header as='h3'>
            Trending
          </Header>
          <Divider />
          <Grid columns={4}>
            <Grid.Column>
              <Image
                src='https://www.mapcom.com/wp-content/uploads/2015/07/video-placeholder.jpg'
                as='a'
                size='medium'
                href='http://google.com'
                target='_blank'
              />
            </Grid.Column>
            <Grid.Column>
              <Image
                src='https://www.mapcom.com/wp-content/uploads/2015/07/video-placeholder.jpg'
                as='a'
                size='medium'
                href='http://google.com'
                target='_blank'
              />
            </Grid.Column>
            <Grid.Column>
              <Image
                src='https://www.mapcom.com/wp-content/uploads/2015/07/video-placeholder.jpg'
                as='a'
                size='medium'
                href='http://google.com'
                target='_blank'
              />
            </Grid.Column>
            <Grid.Column>
              <Image
                src='https://www.mapcom.com/wp-content/uploads/2015/07/video-placeholder.jpg'
                as='a'
                size='medium'
                href='http://google.com'
                target='_blank'
              />
            </Grid.Column>
          </Grid>
        </Container>
      </Grid.Column>
    </Grid.Row> */}

  </Grid>
)

export default Home