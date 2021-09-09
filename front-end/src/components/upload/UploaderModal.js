import React from 'react'
import { Button, Icon, Image, Modal } from 'semantic-ui-react'
import Uploader from './Uploader'

const UploaderModal = () => {
    const [open, setOpen] = React.useState(false)

    return (
        <Modal
            centered={true}
            size='small'
            open={open}
            onClose={() => setOpen(false)}
            onOpen={() => setOpen(true)}
            trigger={<Button content= 'Upload Video' icon='plus' labelPosition='right' color='green' />}
        >
            <Modal.Header>Upload Video</Modal.Header>
            <Modal.Content>
                <Modal.Description>
                    <Uploader />
                </Modal.Description>
            </Modal.Content>
        </Modal>
    )
}

export default UploaderModal