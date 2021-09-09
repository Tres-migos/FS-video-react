import React from 'react'
import { Button, Header, Icon, Segment } from 'semantic-ui-react'
import Uploader from './upload/Uploader'
import UploaderModal from './upload/UploaderModal'

const NoUploadsSegment = () => (
    <Segment placeholder>
        <Header icon>
            <Icon name='video' />
            There are no videos uploaded.
        </Header>
        {}
        <UploaderModal />
    </Segment>
)

export default NoUploadsSegment