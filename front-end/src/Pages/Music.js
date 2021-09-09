import React from 'react'
import { Grid, Container, Header, Divider, Image } from 'semantic-ui-react'

const Music = () => (
  <Grid>
    <Grid.Row>
      <Grid.Column fluid >
        <Container textAlign='justified'>
          <Header as='h3'>
            Music
          </Header>
          <Divider />
          <Grid columns={4}>
            <Grid.Column>
              <Image
                src='https://www.mapcom.com/wp-content/uploads/2015/07/video-placeholder.jpg'
                as='a'
                size='medium'
                href='https://tres-migos-videos.s3.amazonaws.com/More+-+KDA'
                target='_blank'
              />
            </Grid.Column>
            <Grid.Column>
              <Image
                src='https://www.mapcom.com/wp-content/uploads/2015/07/video-placeholder.jpg'
                as='a'
                size='medium'
                href='https://tres-migos-videos.s3.amazonaws.com/Porter+Robinson+-+Shelter'
                target='_blank'
              />
            </Grid.Column>
            <Grid.Column>
              <Image
                src='https://www.mapcom.com/wp-content/uploads/2015/07/video-placeholder.jpg'
                as='a'
                size='medium'
                href='https://tres-migos-videos.s3.amazonaws.com/Say+So+Doja+Cat.mp4'
                target='_blank'
              />
            </Grid.Column>
            <Grid.Column>
              <Image
                src='https://www.mapcom.com/wp-content/uploads/2015/07/video-placeholder.jpg'
                as='a'
                size='medium'
                href='https://tres-migos-videos.s3.amazonaws.com/Circles+Post+Malone.mp4'
                target='_blank'
              />
            </Grid.Column>
            <Grid.Column>
              <Image
                src='https://www.mapcom.com/wp-content/uploads/2015/07/video-placeholder.jpg'
                as='a'
                size='medium'
                href='https://tres-migos-videos.s3.amazonaws.com/NewRules-DuaLipa'
                target='_blank'
              />
            </Grid.Column>
          </Grid>
        </Container>
      </Grid.Column>
    </Grid.Row>
    </Grid>
)

export default Music