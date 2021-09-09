import React from 'react'
import { Grid, Container, Header, Divider, Image } from 'semantic-ui-react'

const VideoGames = () => (
  <Grid>
    <Grid.Row>
      <Grid.Column fluid >
        <Container textAlign='justified'>
          <Header as='h3'>
            Video Games
          </Header>
          <Divider />
          <Grid columns={4}>
            <Grid.Column>
              <Image
                src='https://www.mapcom.com/wp-content/uploads/2015/07/video-placeholder.jpg'
                as='a'
                size='medium'
                href='https://tres-migos-videos.s3.amazonaws.com/Valorant+-+Retake'
                target='_blank'
                
              />
              
            </Grid.Column>
            <Grid.Column>
              <Image
                src='https://www.mapcom.com/wp-content/uploads/2015/07/video-placeholder.jpg'
                as='a'
                size='medium'
                href='https://tres-migos-videos.s3.amazonaws.com/Thresh+Unbound'
                target='_blank'
              />
            </Grid.Column>
            <Grid.Column>
              <Image
                src='https://www.mapcom.com/wp-content/uploads/2015/07/video-placeholder.jpg'
                as='a'
                size='medium'
                href='https://tres-migos-videos.s3.amazonaws.com/Suicide+Squad+Game+Trailer.mp4'
                target='_blank'
              />
            </Grid.Column>
            <Grid.Column>
              <Image
                src='https://www.mapcom.com/wp-content/uploads/2015/07/video-placeholder.jpg'
                as='a'
                size='medium'
                href='https://tres-migos-videos.s3.amazonaws.com/Stray+Gameplay+Trailer.mp4'
                target='_blank'
              />
            </Grid.Column>
          </Grid>
        </Container>
      </Grid.Column>
    </Grid.Row>
    </Grid>
)

export default VideoGames