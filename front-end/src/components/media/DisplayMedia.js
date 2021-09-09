import React, { useState, useEffect } from 'react'
import axios from 'axios'
import { Dimmer, Loader, Image, Segment, Grid, Embed } from 'semantic-ui-react'
import {Carousel} from '3d-react-carousal';

const instance = axios.create({
    baseURL: 'http://localhost:8080/video',
    headers: {
        'Content-Type': 'application/x-www-form-urlencoded'
    },
  });

const DisplayMedia = ({ media }) => {
    const [isLoading, setLoading] = useState(false)
    const [video, setVideo] = useState([])
    const [slides, setSlides] = useState([])

    const handleLoader = () => {
        setLoading(isLoading => !isLoading)
    }

    const getMediaURL = async () => {
        handleLoader()
        let media_URL = ""
        media_URL = await instance.get(`/${media.bucketName}/${media.key}`)
        setVideo(media_URL.data)
    }

    useEffect(() => {
        getMediaURL()
        handleLoader()
    }, [])

    return (
        <>
            {isLoading && video == null && <Dimmer active><Loader size='large'>Loading</Loader></Dimmer>}
            {
                !isLoading && video != null &&
                <div style={{ padding: '5%'}}>
                <Embed
                    url={video}
                />
                </div>

            }

        </>
    )

}

export default DisplayMedia